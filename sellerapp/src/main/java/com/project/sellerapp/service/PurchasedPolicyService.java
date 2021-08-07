package com.project.sellerapp.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.project.sellerapp.repository.PurchasedPolicyRepository;

@Service
public class PurchasedPolicyService {

	@Autowired
	private PurchasedPolicyRepository repository;
}
