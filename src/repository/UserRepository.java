package repository;

import entity.Transactions;
import entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRepository {
	
	private static Set<User> users = new HashSet<>();
	
	private static List<Transactions> transactions = new ArrayList<>();
	
	static {
		
		User user1 = new User("admin", "admin", "12345", "admin", 0.0);
		User user2 = new User("user2", "user2", "456", "user", 1000.0);
		User user3 = new User("user3", "user3", "4999", "user", 2000.0);
		User user4 = new User("user4", "user4", "4399", "user", 2000.0);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		
		
	}
	
	public boolean transferAmmount(String userID, String payUserID, Double amount) {
		
		boolean isDebit = debit(userID, amount, payUserID);
		boolean isCredit = credit(payUserID, amount, userID);
		
		return isDebit && isCredit;
		
		
	}
	
	private boolean debit(String userID, Double amount, String payUserID) {
		User user = getUser(userID);
		
		Double accountBalance = user.getAccountBalance();
		
		users.remove(user);
		
		Double finalBalance = accountBalance - amount;
		user.setAccountBalance(finalBalance);
		
		Transactions transaction = new Transactions(
				LocalDate.now(),
				payUserID,
				amount,
				"Debit",
				accountBalance,
				finalBalance,
				userID);
		

		transactions.add(transaction);
		return users.add(user);
		
		
	}
	
	private boolean credit(String payUserID, Double amount, String userID) {
		User user = getUser(payUserID);
		
		Double accountBalance = user.getAccountBalance();
		
		users.remove(user);
		
		Double finalBalance = accountBalance + amount;
		user.setAccountBalance(finalBalance);
		
		Transactions transaction = new Transactions(
				LocalDate.now(),
				userID,
				amount,
				"Credit",
				accountBalance,
				finalBalance,
				payUserID);
		

		transactions.add(transaction);
		return users.add(user);
		
		
		
	}
	
	public void printTransactions(String userID) {
		List<Transactions> filteredTransaction = transactions.stream().filter(transaction -> transaction.getTransactionPerformedBy().equals(userID)).collect(Collectors.toList());
		
		
		System.out.println("Date \t\tUser ID\t Amount\t Type\t Inital Balance\t Final Balance");
		System.out.println("---------------------------------------------------------------------------------");
		for(Transactions t: filteredTransaction) {
			System.out.println(t.getTransactionDate()
					+"\t" + t.getTransactionUserID()
					+"\t" + t.getTransactionAmount()
					+"\t" + t.getTransactionType()
					+"\t\t" + t.getIntitalBalance()
					+"\t\t" + t.getFinalBalance());
		}
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	public Double checkBalance(String userID) {
		List<User> result = users.stream().filter(user -> user.getUsername().equals(userID)).collect(Collectors.toList());
		
		if(!result.isEmpty()) {
			return result.get(0).getAccountBalance();
			
		} else {
			return (Double) null;
		}
		
	}
	
	public void printUser() {
		System.out.print(users);
	}
	
	public User login(String username, String password) {
		List<User> finalList = users.stream()
				.filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
				.collect(Collectors.toList());
		
		if(!finalList.isEmpty()) {
			return finalList.get(0);
		} else {
			return null;
		}
		
	}
	
	public boolean addNewCustomer(String username, String password, String contact) {
		User user = new User(username, password, contact, "user", 500.0);
		return users.add(user);
	}
	
	public User getUser(String userID) {
		List<User> result = users.stream().filter(user -> user.getUsername().equals(userID)).collect(Collectors.toList());
		if(! result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

}
