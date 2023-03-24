package com.bankaccounts;

import java.text.DecimalFormat;

public class BankAccount {
	
	DecimalFormat df = new DecimalFormat("#.00");

	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int accountsCount = 0;
	private static double totalAmount = 0;
	
	public BankAccount() {
		accountsCount ++;
		this.accountNumber = getAccountNumber();
	}
	
	public String getAccountNumber() {
		String accountNumber = "";
		for(int i = 0; i < 10; i++) {
			int random = (int) (Math.random()*10);
			accountNumber += random;
		}
		return accountNumber;
	}
	
	private double getCheckingBalance() {
		return this.checkingBalance;
	}
	
	private double getSavingsBalance() {
		return this.savingsBalance;
	}
	
	public void deposit(String accountType, double amount) {
		if(accountType == "checking") {
			this.checkingBalance += amount;
		}else if (accountType == "savings") {
			this.savingsBalance += amount;
		}else {
			System.out.println("Incorrect account type.");
		}
		
		totalAmount += amount;
		System.out.println("Deposited $" + df.format(amount) + " into your " + accountType + " account.");
	}
	
	public void withdraw(String accountType, double amount) {
		if(accountType == "checking") {
			if(amount > this.checkingBalance) {
				System.out.println("Insufficient funds.");
			}else {
				this.checkingBalance -= amount;
				totalAmount -= amount;
				System.out.println("You withdrew $" + df.format(amount) + " from your checking account.");
			}
		}else if(accountType == "savings") {
			if(amount > this.savingsBalance) {
				System.out.println("Insufficient funds.");
			} else {
				this.savingsBalance -= amount;
				totalAmount -= amount;
				System.out.println("You withdrew $" + df.format(amount) + " from your checking account.");
			}
		}else {
			System.out.println("Incorrect account type");
		}
	}
	
	public void getBalances() {
		System.out.println("Checking account: $" + df.format(getCheckingBalance()));
		System.out.println("Savings account: $" + df.format(getSavingsBalance()));
	}
}
