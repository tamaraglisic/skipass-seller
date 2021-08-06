package com.project.sellerapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sellerapp.dto.InsuranceCompanyDTO;
import com.project.sellerapp.model.InsuranceCompany;
import com.project.sellerapp.service.InsuranceCompanyService;

@RestController
@RequestMapping(value = "/api/insurance-company", produces = MediaType.APPLICATION_JSON_VALUE)
public class InsuranceCompanyController {

	@Autowired
	private InsuranceCompanyService insuranceCompanyService;
	
	@RequestMapping(method = RequestMethod.GET)
	//@PreAuthorize("hasAnyRole('REGISTERED_USER', 'ROLE_ADMIN')")
	public ResponseEntity<List<InsuranceCompanyDTO>> getAll(){
		List<InsuranceCompanyDTO> companies = insuranceCompanyService.findAll();
		
		return new ResponseEntity<>(companies, HttpStatus.OK);
	}
}
