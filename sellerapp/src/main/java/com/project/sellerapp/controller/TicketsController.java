package com.project.sellerapp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sellerapp.dto.Occupancy;
import com.project.sellerapp.dto.TicketsDTO;
import com.project.sellerapp.helpers.TicketsMapper;
import com.project.sellerapp.model.RegisteredUser;
import com.project.sellerapp.model.Tickets;
import com.project.sellerapp.model.User;
import com.project.sellerapp.service.RegisteredUserService;
import com.project.sellerapp.service.TicketsService;



@RestController
@RequestMapping(value = "/api/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketsController {
	
	private static Logger log = LoggerFactory.getLogger(TicketsController.class);
	private final TicketsService ticketsService;
	private final RegisteredUserService registeredUserService;
	
	@Autowired
	public TicketsController(TicketsService ticketsService, RegisteredUserService regService) {
		this.ticketsService = ticketsService;
		this.registeredUserService = regService;
	}


	@RequestMapping(value = "/final-price", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('REGISTERED_USER')")
    public ResponseEntity<TicketsDTO> getFinalPrice(@RequestBody TicketsDTO ticketsDto) {
		
		try {
			log.debug("Item request received for: " + ticketsDto.getSkiResort().getName());
			System.out.println(ticketsDto.getUsingPeriod());
			TicketsDTO dto = ticketsService.getFinalPrice(ticketsDto);
			System.out.println("Price: " + dto.getBill());
	        return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		catch(Exception e) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
    }
	
	@RequestMapping(value="/my-tickets", method = RequestMethod.GET)
	@PreAuthorize("hasRole('REGISTERED_USER')")
	public ResponseEntity<List<TicketsDTO>> getMyTickets(){
		RegisteredUser registeredUser;

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User) currentUser.getPrincipal()).getEmail();
        registeredUser = registeredUserService.findByEmail(username);
        List<TicketsDTO> retVal = toDtoList(registeredUser.getTickets());
        
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('REGISTERED_USER')")
	public ResponseEntity<TicketsDTO> getOne(@PathVariable Long id){
        TicketsDTO retVal = ticketsService.getById(id);
        
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value="/num-of-users/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('REGISTERED_USER')")
	public ResponseEntity<Integer> getNumOfUSers(@PathVariable Long id){
        TicketsDTO retVal = ticketsService.getById(id);
        if(retVal != null) {
        	return new ResponseEntity<>(retVal.getNumberOfUsers(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasRole('REGISTERED_USER')")
	public ResponseEntity<TicketsDTO> createTickets(@RequestBody TicketsDTO tickets){
		RegisteredUser registeredUser;

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(currentUser);
        String username = ((User) currentUser.getPrincipal()).getEmail();
        registeredUser = registeredUserService.findByEmail(username);
        
		Tickets created = ticketsService.create(tickets);
		registeredUser.getTickets().add(created);
		registeredUserService.save(registeredUser);
		
		return new ResponseEntity<>(TicketsMapper.toDto(created), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/occupancy/{id}/{day}/{month}/{year}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Occupancy> calculateOccupacyRate(@PathVariable Long id, @PathVariable int day, @PathVariable int month, @PathVariable int year) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String inputString2 = day + "/" + month + "/" + year;
		Occupancy o = new Occupancy();
		try {
		    Date date2 = myFormat.parse(inputString2);
			double occupacy = ticketsService.calculateOccupacy(date2, id);
			o.setPercent(occupacy);
			o.setForDay(inputString2);
			return new ResponseEntity<>(o, HttpStatus.OK);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReservation(@PathVariable Long id){
		try {
			ticketsService.delete(id);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	private List<TicketsDTO> toDtoList(Set<Tickets> set){
		List<TicketsDTO> retVal = new ArrayList<TicketsDTO>();
		for(Tickets t: set) {
			TicketsDTO dto = TicketsMapper.toDto(t);
			retVal.add(dto);
		}
		
		return retVal;
	}
}
