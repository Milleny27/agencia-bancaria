package entities;

import util.Utils;

public class Account {

	private static int accountCounter = 1;

	private int accountNumber;
	private Holder holder;
	private Double balance = 0.0;

	public Account() {
	}

	public Account(int accountNumber, Holder holder, Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.holder = holder;
		this.balance = balance;
	}

	public Account(Holder holder) {
		this.accountNumber = Account.accountCounter;
		this.holder = holder;
		this.updateBalance();
		Account.accountCounter += 1;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Holder getHolder() {
		return holder;
	}

	public void setHolder(Holder holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	private void updateBalance() {
		this.balance = this.getBalance();
	}

	@Override
	public String toString() {
		return "\nAccount Number: " + accountNumber + "\nHolder: " + holder.getName() + "\nCPF : " + holder.getCpf()
				+ "\nBalance : " + Utils.doubleToString(balance);
	}

	public void deposit(Double amont) {
		if (amont > 0) {
			this.balance += amont;
			System.out.println("Deposit successful");
		} else {
			System.out.println("Deposit failed");
		}
	}

	public void withdraw(Double amont) {
		if (amont > 0 && balance >= amont) {
			this.balance -= amont;
			System.out.println("Withdrawal successful");
		} else {
			System.out.println("Withdrawal failed");
		}
	}

	public void transferTo(Account conta, Double amont) {
		if (amont > 0 && balance >= amont) {
			withdraw(amont);
			conta.balance = conta.getBalance() + amont;
			System.out.println("Transfer successful");
		} else {
			System.out.println("Transfer failed");
		}
	}

}
