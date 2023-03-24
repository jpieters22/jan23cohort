package com.bankaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAccountsApplication {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("Am i working?");
		
		BankAccount account = new BankAccount();
		
		account.deposit("checking", 500);
		account.deposit("savings", 100);
		account.getBalances();
		
		account.withdraw("checking", 80);
		account.getBalances();
		
		
		
		
		
		SpringApplication.run(BankAccountsApplication.class, args);
	}

}
