package main;

import java.util.Scanner;

import service.UserService;
import entity.User;

public class Main {
		
	private static Scanner sc = new Scanner(System.in);
	static Main main = new Main();
	static UserService userService = new UserService();
		
	public static void main(String[] args) {
		
		
		while (true) {
		
			System.out.println("Enter your Username");
			String username = sc.next();
			
			System.out.println("Enter your password");
			String password = sc.next();
			
			User user = userService.login(username, password);
			if (user != null && user.getRole().equals("admin") ) {
				main.initAdmin();
	
			} else if (user != null && user.getRole().equals("user")) {
				main.initCustomer(user);
				
			} else {
				System.out.println("Login Failed, try again.");
			}	
		}
	}
	
	private void initAdmin() {
		System.out.println("Welcome Admin.");
		
		boolean flag = true;
		while (flag) {
			System.out.println("1. Exit/Logout");
			System.out.println("2. Create a new user account");
			
			int selectedOption = sc.nextInt();
			
			switch(selectedOption) {
				case 1:
					System.out.println("You have logged out.\n");
					flag = false;
					break;
				case 2:
					main.addNewCustomer();
					break;
				default:
					System.out.println("Please pick one of the choices.");		
			}
		}
	}
	
	private void addNewCustomer() {
		System.out.println("Please enter the new user's information.");
		System.out.println("Username: ");
		String username = sc.next();
		
		System.out.println("Password: ");
		String password = sc.next();
		
		System.out.println("Contact Number: ");
		String contactNumber = sc.next();
		
		boolean result = userService.addNewCustomer(username, password, contactNumber);
		
		if (result) {
			System.out.println("Customer account successfully created.");
			
		} else {
			System.out.println("Creation failed, try again.");
		}
	}
	
	private void initCustomer(User user) {
		boolean flag = true;
		
		System.out.println("Welcome Customer.\n");

		
		while(flag) {
			System.out.println("Please select an action.\n");
			System.out.println("1. Exit/Logout.");
			System.out.println("2. Check your balance.");
			System.out.println("3. Transfer funds.");
			System.out.println("4. View Transaction History.");
			
			int selectedOption = sc.nextInt();
			
			switch(selectedOption) {
			case 1:
				System.out.println("You have logged out.\n");
				flag = false;
				break;
			case 2:
				Double balance = main.checkBalance(user.getUsername());
				if(balance != null) {
					System.out.println("Balance: " + balance + "\n");
					
				} else {
					System.out.println("Error. Please try again.\n");
				}
				break;
			case 3:
				main.fundTransfer(user);
				break;
			case 4:
				main.printTransactions(user.getUsername());
				break;
			default:
				System.out.println("Error, please pick one of the choices.");		
			}
			
		}
		
	}
	
	private void printTransactions(String userID) {
		userService.printTransactions(userID);
	}
	
	private void fundTransfer(User userDetails) {
		System.out.println("Enter a User to recive the transfer.");
		String payAccount = sc.next();
		
		User user = getUser(payAccount);
		
		if(user != null) {
			System.out.println("Enter an amount to transfer:");
			Double amount = sc.nextDouble();
			
			Double userAccountBalance = checkBalance(userDetails.getUsername());
			
			if(userAccountBalance >= amount) {
				boolean result = userService.transferAmmount(userDetails.getUsername(), payAccount, amount);
				
				if (result) {
					System.out.println("Amount transferred successfully. \n");
				} else {
					System.out.println("Transfer failed, please try again.");
				}
			} else {
				System.out.println("Your balance is insufficient for this transfer.");
				System.out.println("Your current balance is " + userAccountBalance + "\n");
				
			}
			
		} else {
			System.out.println("Please enter a valid username.");
		}
		
		
	}
	
	private User getUser(String userID) {
		return userService.getUser(userID);
	}
	
	private Double checkBalance(String userID) {
		return userService.checkBalance(userID);
	}
}

