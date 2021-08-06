package com.project.sellerapp.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.project.sellerapp.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository repository;
}
