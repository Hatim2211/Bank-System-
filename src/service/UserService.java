package service;

import repository.UserRepository;
import entity.User;

public class UserService {

	private UserRepository userRepository = new UserRepository();
	
	public void  printUsers() {
		userRepository.printUser();
	}
	
	public User login(String username, String password) {
		return userRepository.login(username, password);
		
	}
	
	public boolean addNewCustomer(String username, String password, String contact) {
		return userRepository.addNewCustomer(username, password, contact);
	}
	
	public Double checkBalance(String userID) {
		return userRepository.checkBalance(userID);
	}
	
	public User getUser(String userID) {
		return userRepository.getUser(userID);
	}
	
	public boolean transferAmmount(String userID, String payUserID, Double amount) {
		return userRepository.transferAmmount(userID, payUserID, amount);
	}
	
	public void printTransactions(String userID) {
		userRepository.printTransactions(userID);
	}
	
}
