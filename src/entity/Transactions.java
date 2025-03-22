package entity;

import java.time.LocalDate;

public class Transactions {

	private LocalDate transactionDate;
	private String transactionUserID;
	private Double transactionAmount;
	private String transactionType; 
	private Double intitalBalance;
	private Double finalBalance;
	private String transactionPerformedBy;
	
	
	public Transactions(LocalDate transactionDate, String transactionUserID, Double transactionAmount,
			String transactionType, Double intitalBalance, Double finalBalance, String transactionPerformedBy) {
		super();
		this.transactionDate = transactionDate;
		this.transactionUserID = transactionUserID;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.intitalBalance = intitalBalance;
		this.finalBalance = finalBalance;
		this.transactionPerformedBy = transactionPerformedBy;
	}


	public LocalDate getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getTransactionUserID() {
		return transactionUserID;
	}


	public void setTransactionUserID(String transactionUserID) {
		this.transactionUserID = transactionUserID;
	}


	public Double getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public Double getIntitalBalance() {
		return intitalBalance;
	}


	public void setIntitalBalance(Double intitalBalance) {
		this.intitalBalance = intitalBalance;
	}


	public Double getFinalBalance() {
		return finalBalance;
	}


	public void setFinalBalance(Double finalBalance) {
		this.finalBalance = finalBalance;
	}


	public String getTransactionPerformedBy() {
		return transactionPerformedBy;
	}


	public void setTransactionPerformedBy(String transactionPerformedBy) {
		this.transactionPerformedBy = transactionPerformedBy;
	}


	@Override
	public String toString() {
		return "Transactions [transactionDate=" + transactionDate + ", transactionUserID=" + transactionUserID
				+ ", transactionAmount=" + transactionAmount + ", transactionType=" + transactionType
				+ ", intitalBalance=" + intitalBalance + ", finalBalance=" + finalBalance + ", transactionPerformedBy="
				+ transactionPerformedBy + "]";
	} 
	
	
	
	
	
}
