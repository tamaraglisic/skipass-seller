package com.project.sellerapp.dto;
import java.io.Serializable;
import java.util.Date;


import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;



@Role(Role.Type.EVENT)
@Timestamp("executionTime")
public class PolicyEvent implements Serializable {

	private static final long serialVersionUID = 1L;
    private Date executionTime;
    private String skiResort;

    public PolicyEvent(String skiResort){
        super();
        this.executionTime = new Date();
        this.skiResort= skiResort;
    }

	public PolicyEvent() {
		super();
	}

	public PolicyEvent(Date executionTime, String skiResort) {
		super();
		this.executionTime = executionTime;
		this.skiResort = skiResort;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}
	
	public String getSkiResort() {
		return skiResort;
	}

	public void setSkiResort(String skiResort) {
		this.skiResort = skiResort;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
