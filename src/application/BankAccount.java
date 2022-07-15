package application;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Account;
import entities.Holder;

public class BankAccount {

	static ArrayList<Account> accounts;

	public static void main(String[] args) {
		accounts = new ArrayList<Account>();
		operations();
	}

	public static void operations() {

		int option = Integer.parseInt(JOptionPane.showInputDialog(
				"\nSelect an option: " + 
						"\nOpção 1 - Create an account" + 
						"\nOpção 2 - Deposit"+ 
						"\nOpção 3 - To withdraw" + 
						"\nOpção 4 - Transfer" +
						"\nOpção 5 - List" + 
						"\nOpção 6 - Exit"));

		switch (option) {
		case 1:
			createAccount();
			break;

		case 2:
			deposit();
			break;

		case 3:
			withdraw();
			break;

		case 4:
			transferTo();
			break;

		case 5:
			listAccounts();
			break;

		case 6:
			// JOptionPane.showMessageDialog(null, "Going out");
			System.exit(0);

		default:
			JOptionPane.showMessageDialog(null, "Invalid option!");
			operations();
			break;
		}

	}

	public static void createAccount() {

		Holder holder = new Holder();

		holder.setName(JOptionPane.showInputDialog("Name: "));
		holder.setCpf(JOptionPane.showInputDialog("CPF: "));
		holder.setEmail(JOptionPane.showInputDialog("Email: "));

		Account account = new Account(holder);

		accounts.add(account);
		JOptionPane.showMessageDialog(null, "Account create successfully");
		operations();

	}

	private static Account findAccount(int accountNumber) {
		Account account = null;
		if (accounts.size() > 0) {
			for (Account a : accounts) {
				if (a.getAccountNumber() == accountNumber) {
					account = a;
				}
			}
		}
		return account;
	}

	public static void deposit() {
		int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Account number: "));
		Account account = findAccount(accountNumber);

		if (account != null) {
			Double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Amount: "));

			account.deposit(depositAmount);
		} else {
			JOptionPane.showMessageDialog(null, "Account not found");
		}

		operations();

	}

	public static void withdraw() {
		int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Account number: "));

		Account account = findAccount(accountNumber);

		if (account != null) {
			Double withdrawalAmount = Double.parseDouble(JOptionPane.showInputDialog("Amount?: "));

			account.withdraw(withdrawalAmount);
			JOptionPane.showMessageDialog(null, "Withdrawal successful");
		} else {
			JOptionPane.showMessageDialog(null, "Account not found");
		}

		operations();

	}

	public static void transferTo() {
		int senderAccountNumber = Integer.parseInt(JOptionPane.showInputDialog("Sender account number: "));

		Account senderAccount = findAccount(senderAccountNumber);

		if (senderAccount != null) {
			int receiverAccountNumber = Integer.parseInt(JOptionPane.showInputDialog("Receiver account number: "));

			Account receiverAccount = findAccount(receiverAccountNumber);

			if (receiverAccount != null) {
				Double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Amount: "));

				senderAccount.transferTo(receiverAccount, depositAmount);

			} else {
				JOptionPane.showMessageDialog(null, "Account not found");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Account not found");
		}
		operations();
	}

	public static void listAccounts() {
		if (accounts.size() > 0) {
			for (Account account : accounts) {
				JOptionPane.showMessageDialog(null, account);
			}
		} else {
			JOptionPane.showMessageDialog(null, "There are no registered accounts");
		}

		operations();
	}

}
