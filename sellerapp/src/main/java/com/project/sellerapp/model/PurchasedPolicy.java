package com.project.sellerapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PurchasedPolicy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "policy_id", nullable = true)
	private Policy policy;
	
	@ManyToOne
	@JoinColumn(name = "tickets_id", nullable = true)
	private Tickets tickets;
	
	@Column(unique = false, nullable = true)
	private boolean used;
	
	@Column(unique = false, nullable = true)
	private String description;
	
	@Column(unique = false, nullable = true)
	private Date usingStart;
	
	@Column(unique = false, nullable = true)
	private Date usingEnd;

	public PurchasedPolicy(Long id, Policy policy, Tickets tickets, boolean used, String description, Date usingStart,
			Date usingEnd) {
		super();
		this.id = id;
		this.policy = policy;
		this.tickets = tickets;
		this.used = used;
		this.description = description;
		this.usingStart = usingStart;
		this.usingEnd = usingEnd;
	}

	public PurchasedPolicy() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Tickets getTickets() {
		return tickets;
	}

	public void setTickets(Tickets tickets) {
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
