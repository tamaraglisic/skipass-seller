package com.project.sellerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sellerapp.dto.QuestionnaireData;
import com.project.sellerapp.service.PolicyService;

@RestController
@RequestMapping(value = "/api/policy", produces = MediaType.APPLICATION_JSON_VALUE)
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	

	@RequestMapping(value = "/questionnaire", method = RequestMethod.PUT)
	//@PreAuthorize("hasRole('REGISTERED_USER')")
    public ResponseEntity<Void> proceedQuestionnaire(@RequestBody QuestionnaireData questionnaireData) {
		
		
		return new ResponseEntity<> (HttpStatus.OK);
		
    }
	
}
