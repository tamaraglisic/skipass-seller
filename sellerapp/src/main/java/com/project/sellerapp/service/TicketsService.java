package com.project.sellerapp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.sellerapp.dto.RegisteredUserDTO;
import com.project.sellerapp.dto.ReservationEvent;
import com.project.sellerapp.dto.TicketUserDTO;
import com.project.sellerapp.dto.TicketsDTO;
import com.project.sellerapp.helpers.TicketsMapper;
import com.project.sellerapp.model.RegisteredUser;
import com.project.sellerapp.model.SkiResort;
import com.project.sellerapp.model.Tickets;
import com.project.sellerapp.model.User;
import com.project.sellerapp.repository.SkiResortRepository;
import com.project.sellerapp.repository.TicketsRepository;

@Service
public class TicketsService {
	
	@Autowired
	private TicketsRepository ticketsRepository;
	@Autowired
	private SkiResortRepository skiResortRepository;

	@Autowired
	private RegisteredUserService registeredUserService;
	
	@Autowired
	private KieService kieService;
	

	public TicketsDTO getFinalPrice(TicketsDTO tickets) {
		System.out.println("Calculating final price");

		
		kieService.getRuleSession().getAgenda().getAgendaGroup("transport_type").setFocus();
		kieService.getRuleSession().insert(tickets);
		kieService.getRuleSession().fireAllRules();
		
		kieService.getRuleSession().getAgenda().getAgendaGroup("using_period").setFocus();
		kieService.getRuleSession().insert(tickets);
		kieService.getRuleSession().fireAllRules();
		
		kieService.getRuleSession().getAgenda().getAgendaGroup("user_type_discount").setFocus();
		kieService.getRuleSession().insert(tickets);
		kieService.getRuleSession().fireAllRules();
		
		
		kieService.getRuleSession().getAgenda().getAgendaGroup("period_discount").setFocus();
		kieService.getRuleSession().insert(tickets);
		kieService.getRuleSession().fireAllRules();
		
		kieService.getRuleSession().getAgenda().getAgendaGroup("type_ticket").setFocus();
		kieService.getRuleSession().insert(tickets);
		kieService.getRuleSession().fireAllRules();
		
		kieService.getRuleSession().getAgenda().getAgendaGroup("calculating_bill").setFocus();
		kieService.getRuleSession().insert(tickets);
		kieService.getRuleSession().fireAllRules();
		
		kieService.getRuleSession().getAgenda().getAgendaGroup("type_ticket_discount").setFocus();
		kieService.getRuleSession().insert(tickets);
		kieService.getRuleSession().fireAllRules();
		
		// preuzimanje usera is konteksta
		RegisteredUser registeredUser;
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User) currentUser.getPrincipal()).getEmail();
        registeredUser = registeredUserService.findByEmail(username);
        
        RegisteredUserDTO regDto = new RegisteredUserDTO();
        regDto.setTickets(toDtoSet(registeredUser.getTickets()));
        
        System.out.println(registeredUser.getTickets().stream().findFirst().get().getUsingStart());
        
        kieService.getRuleSession().getAgenda().getAgendaGroup("regular_guest").setFocus();
        kieService.getRuleSession().insert(regDto);
        kieService.getRuleSession().insert(tickets);
        kieService.getRuleSession().fireAllRules();
		
        kieService.getRuleSession().getAgenda().getAgendaGroup("occupancy_rate").setFocus();
        kieService.getRuleSession().insert(tickets.getSkiResort());
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(tickets.getUsingEnd()); 
		cal.add(Calendar.DATE, 1);
		Date nextDay = cal.getTime();
		
		List<TicketsDTO> res = toDtoList(findTicketsByDate(nextDay, tickets.getSkiResort().getId()));
		kieService.getRuleSession().insert(res);

		kieService.getRuleSession().fireAllRules();
		System.out.println(tickets.getSkiResort().getOccupacyRate());
		
		
		kieService.getRuleSession().getAgenda().getAgendaGroup("bonus").setFocus();
        kieService.getRuleSession().insert(tickets);
        kieService.getRuleSession().fireAllRules();

		kieService.disposeRuleSession();
		
		System.out.println(tickets);
		
		return tickets;
		
	}
	private List<TicketsDTO> toDtoList(List<Tickets> list){
		List<TicketsDTO> retVal = new ArrayList<TicketsDTO>();
		for(Tickets t: list) {
			TicketsDTO dto = TicketsMapper.toDto(t);
			retVal.add(dto);
		}
		return retVal;
	}
	
	private Set<TicketsDTO> toDtoSet(Set<Tickets> list){
		Set<TicketsDTO> retVal = new HashSet<TicketsDTO>();
		for(Tickets t: list) {
			TicketsDTO dto = TicketsMapper.toDto(t);
			retVal.add(dto);
		}
		return retVal;
	}
	
	
	public double calculateOccupacy(Date forDate, Long skiResortId) {
		int sum = 0;
		List<Tickets> tickets = findTicketsByDate(forDate, skiResortId);
		for(Tickets t: tickets) {
			sum = sum + t.getNumOfChildren() + t.getNumOfAdult() + t.getNumOfSenior();
		}
		SkiResort resort = skiResortRepository.findById(skiResortId).orElse(null);
		if(resort != null) {
			return 100*sum/resort.getCapacity();
		}
		
		return 0;
	}
	
	public List<Tickets> findTicketsByDate(Date forDate, Long skiResortId)
	{
		List<Tickets> tickets = ticketsRepository.findByDate(skiResortId, forDate);
		return tickets;
	}

	public Tickets create(TicketsDTO tickets) {
		
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User) currentUser.getPrincipal()).getEmail();
        
		Tickets t = new Tickets();

		SkiResort resort = skiResortRepository.findById(tickets.getSkiResort().getId()).orElse(null);
		t.setSkiResort(resort);
		t.setTypeTicket(tickets.getTypeTicket());
		t.setUsingPeriod(tickets.getUsingPeriod());
		t.setTransportType(tickets.getTransportType());
		t.setUsingStart(tickets.getUsingStart());
		t.setUsingEnd(tickets.getUsingEnd());
		t.setInitialPrice(tickets.getInitialPrice());
		for(TicketUserDTO tu: tickets.getTicketUsers()) {
			switch(tu.getUserType()) {
			case CHILD:
				t.setNumOfChildren(tu.getCount());
				break;
			case ADULT:
				t.setNumOfAdult(tu.getCount());
				break;
			case SENIOR:
				t.setNumOfSenior(tu.getCount());
				break;
			}
		}
		t.setBill(tickets.getBill());
		t = ticketsRepository.save(t);
		
		ReservationEvent event = new ReservationEvent(username);
		kieService.getCepSession().insert(event);
		kieService.getCepSession().getAgenda().getAgendaGroup("reservations").setFocus();
		kieService.getCepSession().fireAllRules();
		System.out.println("reservation event");
		
		return t;
	}
	public void delete(Long id) {
		Tickets found = ticketsRepository.findById(id).orElse(null);
		if(found != null) {
			ticketsRepository.delete(found);
		}
		
	}
	public TicketsDTO getById(Long id) {
		Tickets found = ticketsRepository.findById(id).orElse(null);
		if(found != null) {
			return TicketsMapper.toDto(found);
		}
		return null;
	}
	
}
