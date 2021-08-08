package com.project.sellerapp.dto;

import java.util.Date;

public class PurchasedPolicyDTO {
	
	private Long id;
	private PolicyDTO policy;
	private TicketsDTO tickets;
	private boolean used;
	private String description;
	private Date usingStart;
	private Date usingEnd;
	
	public PurchasedPolicyDTO(Long id, PolicyDTO policy, 
			TicketsDTO tickets, boolean used, String description,
			Date usingStart, Date usingEnd) {
		super();
		this.id = id;
		this.policy = policy;
		this.tickets = tickets;
		this.used = used;
		this.description = description;
		this.usingStart = usingStart;
		this.usingEnd = usingEnd;
	}

	public PurchasedPolicyDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PolicyDTO getPolicy() {
		return policy;
	}
	public void setPolicy(PolicyDTO policy) {
		this.policy = policy;
	}
	public TicketsDTO getTickets() {
		return tickets;
	}
	public void setTickets(TicketsDTO tickets) {
		this.tickets = tickets;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	

}
