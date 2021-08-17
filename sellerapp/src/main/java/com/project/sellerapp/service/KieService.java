package com.project.sellerapp.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KieService {
	private static Logger log = LoggerFactory.getLogger(TicketsService.class);
	private final KieContainer kieContainer;
	
	private KieSession ruleSession;
	private KieSession cepSession;
	private KieSession insuranceRuleSession;
	
	@Autowired
	public KieService(KieContainer kieContainer) {
		super();
		this.kieContainer = kieContainer;
	}
	
	public KieSession getRuleSession() {
		if(this.ruleSession == null) {
			this.ruleSession = kieContainer.newKieSession("test-session");
		}
		return this.ruleSession;
	}
	
	public KieSession getInsuranceRuleSession() {
		if(this.insuranceRuleSession == null) {
			this.insuranceRuleSession = kieContainer.newKieSession("insurance-session");
		}
		return this.insuranceRuleSession;
	}
	
	public KieSession getCepSession()
	{
		if(this.cepSession == null) {
			this.cepSession = kieContainer.newKieSession("cepSession");
		}
		return this.cepSession;
	}
	public void disposeRuleSession() {
		this.ruleSession.dispose();
        this.ruleSession = null;
	}
	
	public void disposeInsuranceRuleSession() {
		this.insuranceRuleSession.dispose();
        this.insuranceRuleSession = null;
	}
	
	public void disposeCepSession() {
		this.cepSession.dispose();
        this.cepSession = null;
	}
}
