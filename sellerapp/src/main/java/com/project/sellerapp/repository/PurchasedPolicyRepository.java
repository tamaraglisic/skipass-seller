package com.project.sellerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sellerapp.model.PurchasedPolicy;

@Repository
public interface PurchasedPolicyRepository extends JpaRepository<PurchasedPolicy, Long>  {

}
