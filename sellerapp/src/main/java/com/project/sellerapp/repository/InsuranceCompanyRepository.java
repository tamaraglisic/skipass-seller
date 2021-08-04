package com.project.sellerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sellerapp.model.InsuranceCompany;

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long> {

}
