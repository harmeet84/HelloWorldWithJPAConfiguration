package com.springboot.model;

public class ApprovalDetails {
	
	private String customerNumber;
	private String applicationRef;
	private String decision;
	
	/**
	 * @return the customerNumber
	 */
	public final String getCustomerNumber() {
		return customerNumber;
	}
	/**
	 * @param customerNumber the customerNumber to set
	 */
	public final void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	/**
	 * @return the applicationRef
	 */
	public final String getApplicationRef() {
		return applicationRef;
	}
	/**
	 * @param applicationRef the applicationRef to set
	 */
	public final void setApplicationRef(String applicationRef) {
		this.applicationRef = applicationRef;
	}
	/**
	 * @return the decision
	 */
	public final String getDecision() {
		return decision;
	}
	/**
	 * @param decision the decision to set
	 */
	public final void setDecision(String decision) {
		this.decision = decision;
	}
	
}