package projects.onlineBookReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerManager {
	Scanner sc = new Scanner(System.in);
	private Map<String, Customer> customers; // userName ==> customer object

	public CustomerManager() {
		customers = new HashMap<>();
	}

	public void doLogin(BookManager bm) {
		System.out.print("Enter user name: ");
		String userName = sc.nextLine();
		System.out.println("Enter password: ");
		String password = sc.nextLine();
		if (!customers.containsKey(userName) || !customers.get(userName).getPassword().equals(password)) {
			System.out.println("Invalid User name or Password");
		} else {
			customers.get(userName).go(bm);
		}
	}

	public void signUp(BookManager bm) {
		// we might make sure that this data is valid or not but, keep things simple.
		System.out.print("Enter user name: ");
		String userName = sc.nextLine();
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter email (no spaces): ");
		String email = sc.next();
		Customer customer = new Customer(name, userName, password, email);
		addCustomer(userName, customer);
		customer.go(bm);
	}

	// add initial customer
	public void addCustomer(String userName, Customer customer) {
		customers.put(userName, customer);
	}

	public void listCustomers() {
		for (String userName : customers.keySet()) {
			customers.get(userName).viewProfile();
			System.out.println();
		}
	}

	public void removeCustomer() {
		System.out.print("Enter user name for the customer: ");
		String userName = sc.nextLine();
		if (!customers.containsKey(userName)) {
			System.out.println("There is no customer with this user name!");
		} else {
			customers.remove(userName);
			System.out.println("Removed Successfully");
		}
	}
}
