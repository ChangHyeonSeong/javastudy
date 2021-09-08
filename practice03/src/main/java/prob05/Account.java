package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String number) {
		
		this.accountNo = number;
		this.balance = 0;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void save(int i) {
		this.balance += i;
	}
	public void deposit(int i) {
		this.balance -= i;
		
	}
	
}
