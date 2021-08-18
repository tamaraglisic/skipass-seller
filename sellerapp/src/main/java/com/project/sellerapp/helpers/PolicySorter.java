package com.project.sellerapp.helpers;

import java.util.Comparator;

import com.project.sellerapp.dto.PolicyDTO;

public class PolicySorter implements Comparator<PolicyDTO> {

	@Override
	public int compare(PolicyDTO o1, PolicyDTO o2) {
		// TODO Auto-generated method stub
		return o1.getPoints() - o2.getPoints();
	}

	
	
	

}
