package com.project.sellerapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sellerapp.dto.PurchasedPolicyDTO;
import com.project.sellerapp.dto.QuestionnaireData;
import com.project.sellerapp.dto.SkiResortDTO;
import com.project.sellerapp.helpers.SkiResortMapper;
import com.project.sellerapp.model.SkiResort;
import com.project.sellerapp.service.PurchasedPolicyService;


@RestController
@RequestMapping(value = "/api/purchased-policy", produces = MediaType.APPLICATION_JSON_VALUE)
public class PurchasedPolicyController {

	@Autowired
	private PurchasedPolicyService purchasedPolicyService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('REGISTERED_USER', 'ROLE_ADMIN')")
	public ResponseEntity<PurchasedPolicyDTO> getPolicy(@PathVariable Long id){
		PurchasedPolicyDTO policy = purchasedPolicyService.findById(id);
		if(policy == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(policy, HttpStatus.OK);
	}
}
