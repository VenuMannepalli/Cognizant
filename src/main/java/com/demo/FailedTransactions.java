package com.demo;

public class FailedTransactions {
	
	private Long transaction_reference; 
	private String description;
	
	
	public FailedTransactions(Long transaction_reference, String description) {
		super();
		this.transaction_reference = transaction_reference;
		this.description = description;
	}
	public Long getTransaction_reference() {
		return transaction_reference;
	}
	public void setTransaction_reference(Long transaction_reference) {
		this.transaction_reference = transaction_reference;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
