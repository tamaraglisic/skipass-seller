package com.project.sellerapp.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import com.project.sellerapp.helpers.Utility;
import com.project.sellerapp.model.TransportType;
import com.project.sellerapp.model.TypeTicket;
import com.project.sellerapp.model.UserType;
import com.project.sellerapp.model.UsingPeriod;
public class TicketsDTO {

	private Long id;
	private SkiResortDTO skiResort;
	private TypeTicket typeTicket; // porodicna, grupna, pojedinacna
	private UsingPeriod usingPeriod; // dnevna, poludnevna, nocn
	private TransportType transportType; // zicara, gondola, zicara+gondola
	private Date usingStart;
	private Date usingEnd;
	private double initialPrice;
	private Set<TicketUserDTO> ticketUsers; // TicketUser, count
	private double bill;
	private Set<String> privilege; // student or loyalty
	private Set<PurchasedPolicyDTO> purchasedPolicies;
	
	private String regGuest;
	
	
	public TicketsDTO() {
		super();
	}
	
	

	public TicketsDTO(Long id, SkiResortDTO skiResort) {
		super();
		this.id = id;
		this.skiResort = skiResort;
	}



	public TicketsDTO(Long id, SkiResortDTO skiResort,  TypeTicket typeTicket, UsingPeriod usingPeriod, TransportType transportType,
			Date usingStart, Date usingEnd, double initialPrice, Set<TicketUserDTO> ticketUsers, double bill,
			Set<PurchasedPolicyDTO> purchasedPolicies) {
		super();
		this.id = id;
		this.skiResort = skiResort;
		this.typeTicket = typeTicket;
		this.usingPeriod = usingPeriod;
		this.transportType = transportType;
		this.usingStart = usingStart;
		this.usingEnd = usingEnd;
		this.initialPrice = initialPrice;
		this.ticketUsers = ticketUsers;
		this.bill = bill;
		this.purchasedPolicies = purchasedPolicies;
	}

//	public TicketsDTO(Long id, SkiResortDTO skiResort, String typeTicket, String usingPeriod, String transportType, Date usingStart,
//			Date usingEnd, double initialPrice, Set<TicketUserDTO> ticketUsers, double bill, Set<String> privilege) {
//		super();
//		this.id = id;
//		this.skiResort = skiResort;
//		this.typeTicket = typeTicket;
//		this.usingPeriod = usingPeriod;
//		this.transportType = transportType;
//		this.usingStart = usingStart;
//		this.usingEnd = usingEnd;
//		this.initialPrice = initialPrice;
//		this.ticketUsers = ticketUsers;
//		this.bill = bill;
//		this.privilege = privilege;
//	}

	public TicketsDTO(Long id, SkiResortDTO skiResort,  TypeTicket typeTicket, UsingPeriod usingPeriod, TransportType transportType,
			Date usingStart, Date usingEnd, double initialPrice, Set<TicketUserDTO> ticketUsers, double bill) {
		super();
		this.id = id;
		this.skiResort = skiResort;
		this.typeTicket = typeTicket;
		this.usingPeriod = usingPeriod;
		this.transportType = transportType;
		this.usingStart = usingStart;
		this.usingEnd = usingEnd;
		this.initialPrice = initialPrice;
		this.ticketUsers = ticketUsers;
		this.bill = bill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SkiResortDTO getSkiResort() {
		return skiResort;
	}

	public void setSkiResort(SkiResortDTO skiResort) {
		this.skiResort = skiResort;
	}


	public TypeTicket getTypeTicket() {
		return typeTicket;
	}



	public void setTypeTicket(TypeTicket typeTicket) {
		this.typeTicket = typeTicket;
	}



	public UsingPeriod getUsingPeriod() {
		return usingPeriod;
	}



	public void setUsingPeriod(UsingPeriod usingPeriod) {
		this.usingPeriod = usingPeriod;
	}



	public TransportType getTransportType() {
		return transportType;
	}



	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}



	public Date getUsingStart() {
		return usingStart;
	}

	public void setUsingStart(Date usingStart) {
		this.usingStart = usingStart;
	}

	public Date getUsingEnd() {
		return usingEnd;
	}

	public void setUsingEnd(Date usingEnd) {
		this.usingEnd = usingEnd;
	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public Set<TicketUserDTO> getTicketUsers() {
		return ticketUsers;
	}

	public void setTicketUsers(Set<TicketUserDTO> ticketUsers) {
		this.ticketUsers = ticketUsers;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}
	
	public Set<String> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Set<String> privilege) {
		this.privilege = privilege;
	}

	public int getNumberOfUsers() {
		int count = 0;
		for (TicketUserDTO tu: this.ticketUsers) {
			count = count + tu.getCount();
		}
		return count;
	}
	
	public void addDiscount(double percent) {
		this.bill = this.bill*(100-percent)/100;
	}
	
	public void increasePrice(double percent) {
		this.bill = this.bill*(100+percent)/100;
	}
	
	public int getUsersCount(UserType userType) {
		int retVal = 0;
		for(TicketUserDTO tu: this.ticketUsers) {
			if(tu.getUserType().equals(userType))
				retVal = tu.getCount();
		}
		return retVal;
	}
	
	public void addToBill(double price) {
		long days = Utility.getDays(this.getUsingStart(), this.getUsingEnd());
		this.bill = this.bill +days*price;
	}
	
	public void calculateBill() {
		double bill = 0;
		long days = Utility.getDays(this.getUsingStart(), this.getUsingEnd());
		for(TicketUserDTO tu: this.getTicketUsers()) {
			bill = bill + days*tu.getSingleTicketPrice()*tu.getCount();
		}
		this.bill = bill;
	}
	
	public void addPrivilege(String privilege) {
		this.privilege.add(privilege);
	}
	
	public void incrementUsingEnd() {
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(this.usingEnd); 
		cal.add(Calendar.DATE, 1);
		this.usingEnd = cal.getTime();
	}
	
	public boolean isRegularGuest() {
		if(this.privilege == null)
			return false;
		for (String privilege: this.privilege) {
			if(privilege.equals("RegularGuest"))
				return true;
		}
		return false;
	}

	public String getRegGuest() {
		return regGuest;
	}

	public void setRegGuest(String regGuest) {
		this.regGuest = regGuest;
	}

	public Set<PurchasedPolicyDTO> getPurchasedPolicies() {
		return purchasedPolicies;
	}



	public void setPurchasedPolicies(Set<PurchasedPolicyDTO> purchasedPolicies) {
		this.purchasedPolicies = purchasedPolicies;
	}



	@Override
	public String toString() {
		String retVal = "bill: " + this.bill + "Using start: " + this.usingStart + " Using end: " + this.usingEnd + " Type Ticket: " + this.typeTicket + " Ticket users: " + this.ticketUsers;
		return retVal;
	}
	
}
