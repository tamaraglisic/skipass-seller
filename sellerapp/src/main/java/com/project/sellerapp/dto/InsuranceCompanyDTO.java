package com.project.sellerapp.dto;

public class InsuranceCompanyDTO {

	private Long id;
	private String name;
	private String description;
	private boolean active;
	
	
	public InsuranceCompanyDTO(Long id, String name, String description, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.active = active;
	}

	public InsuranceCompanyDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
