package com.project.sellerapp.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tickets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ski_resort_id", nullable = true)
	private SkiResort skiResort;

	@Column(unique = false, nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeTicket typeTicket; // porodicna, grupna, pojedinacna
	
	@Column(unique = false, nullable = false)
	@Enumerated(EnumType.STRING)
	private UsingPeriod usingPeriod; // dnevna, poludnevna, nocna
	
	@Column(unique = false, nullable = true)
	@Enumerated(EnumType.STRING)
	private TransportType transportType; // zicara, gondola, zicara+gondola
	
	@Column(unique = false, nullable = true)
	private Date usingStart;
	
	@Column(unique = false, nullable = true)
	private Date usingEnd;
	
	@Column(unique = false, nullable = true)
	private double initialPrice;
	
	@Column(unique = false, nullable = true)
	private int numOfChildren;
	
	@Column(unique = false, nullable = true)
	private int numOfAdult;
	
	@Column(unique = false, nullable = true)
	private int numOfSenior;
	
	@Column(unique = false, nullable = false)
	private double bill;
	
	@Column(unique = false, nullable = true)
	private double insuranceBill;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "tickets")
	private Set<PurchasedPolicy> purchasedPolicies;

	
	
	public Tickets(Long id) {
		super();
		this.id = id;
	}

	public Tickets(Long id, SkiResort skiResort, TypeTicket typeTicket, UsingPeriod usingPeriod, TransportType transportType,
			Date usingStart, Date usingEnd, double initialPrice, int numOfChildren, int numOfAdult, int numOfSenior,
			double bill, double insuranceBill, Set<PurchasedPolicy> purchasedPolicies) {
		super();
		this.id = id;
		this.skiResort = skiResort;
		this.typeTicket = typeTicket;
		this.usingPeriod = usingPeriod;
		this.transportType = transportType;
		this.usingStart = usingStart;
		this.usingEnd = usingEnd;
		this.initialPrice = initialPrice;
		this.numOfChildren = numOfChildren;
		this.numOfAdult = numOfAdult;
		this.numOfSenior = numOfSenior;
		this.bill = bill;
		this.insuranceBill = insuranceBill;
		this.purchasedPolicies = purchasedPolicies;
	}

	public Tickets(Long id, SkiResort skiResort,  TypeTicket typeTicket, UsingPeriod usingPeriod, TransportType transportType,
			Date usingStart, Date usingEnd, double initialPrice, int numOfChildren, int numOfAdult, int numOfSenior,
			double bill) {
		super();
		this.id = id;
		this.skiResort = skiResort;
		this.typeTicket = typeTicket;
		this.usingPeriod = usingPeriod;
		this.transportType = transportType;
		this.usingStart = usingStart;
		this.usingEnd = usingEnd;
		this.initialPrice = initialPrice;
		this.numOfChildren = numOfChildren;
		this.numOfAdult = numOfAdult;
		this.numOfSenior = numOfSenior;
		this.bill = bill;
	}

	public Tickets() {
		super();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SkiResort getSkiResort() {
		return skiResort;
	}

	public void setSkiResort(SkiResort skiResort) {
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

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public int getNumOfChildren() {
		return numOfChildren;
	}

	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
	}

	public int getNumOfAdult() {
		return numOfAdult;
	}

	public void setNumOfAdult(int numOfAdult) {
		this.numOfAdult = numOfAdult;
	}

	public int getNumOfSenior() {
		return numOfSenior;
	}

	public void setNumOfSenior(int numOfSenior) {
		this.numOfSenior = numOfSenior;
	}

	public double getInsuranceBill() {
		return insuranceBill;
	}

	public void setInsuranceBill(double insuranceBill) {
		this.insuranceBill = insuranceBill;
	}

	public Set<PurchasedPolicy> getPurchasedPolicies() {
		return purchasedPolicies;
	}

	public void setPurchasedPolicies(Set<PurchasedPolicy> purchasedPolicies) {
		this.purchasedPolicies = purchasedPolicies;
	}
	
	

}
