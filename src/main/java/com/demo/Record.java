package com.demo;

public class Record {
	 private Long transaction_reference; 
	 private String accountNumber;
	 private double startingBalanace;
	 private double endBalance;
	 private double mutation;
	 private String description;
	
	public Long getTransaction_reference() {
		return transaction_reference;
	}
	public void setTransaction_reference(Long transaction_reference) {
		this.transaction_reference = transaction_reference;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getStartingBalanace() {
		return startingBalanace;
	}
	public void setStartingBalanace(double startingBalanace) {
		this.startingBalanace = startingBalanace;
	}
	public double getEndBalance() {
		return endBalance;
	}
	public void setEndBalance(double endBalance) {
		this.endBalance = endBalance;
	}
	public double getMutation() {
		return mutation;
	}
	public void setMutation(double mutation) {
		this.mutation = mutation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
