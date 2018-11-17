package atm;

import java.math.BigDecimal;


public class Account {
	private BigDecimal balance;
	private int accountNumber;
	private String pin;
	private User accountHolder;
	
	public Account(BigDecimal balance, int accountNumber, String pin, User accountHolder) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.accountHolder = accountHolder;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public User getAccountHolder() {
		return accountHolder;
	}
	
	public String getPin() {
		return pin;
	}
	
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setAccountHolder(User accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public void withdraw(BigDecimal amount) {
		BigDecimal big100 = new BigDecimal(100);
		
		this.balance = (BigDecimal) ((balance.subtract(amount).multiply(big100)).divide(big100));
	}
	
	public void deposit(BigDecimal amount) {
		BigDecimal big100 = new BigDecimal(100);
		this.balance = (BigDecimal) ((balance.add(amount).multiply(big100)).divide(big100));
	}
}
