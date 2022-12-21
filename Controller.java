package projects.onlineBookReader;

import java.util.Scanner;

public class Controller {
	private Scanner sc = new Scanner(System.in);
	private static CustomerManager customerManager;
	private static AdminManager adminManager;
	private static BookManager bookManager;

	// load initial values(one admin, one customer, one book)
	public Controller() {
		adminManager = new AdminManager("Ahmed Hadaka", "Ahmed", "111", "ahmed@gmial.com");
		customerManager = new CustomerManager();
		customerManager.addCustomer("Kamal", new Customer("Kamal sayed", "Kamal", "333", "kamal@gmail.com"));
		bookManager = new BookManager();
		Book book = new Book(40, "java how to program", "Harvey Deitel", 2);
		bookManager.addBook(book, "page1 content", "page2 content");
	}

	public void go() {

		while (true) {
			int choice = menu();
			if (choice == 1) { // admin login
				adminManager.doLogin(customerManager, bookManager);
			} else if (choice == 2) { // customer login
				customerManager.doLogin(bookManager);
			} else if (choice == 3) { // customer signUp
				customerManager.signUp(bookManager);
			} else if (choice == 4) {
				System.out.println("Goodbye :)");
				break;
			} else
				System.out.println("Invalid choice. try again");
		}
	}

	private int menu() {
		int choice;
		System.out.println("Menu:");
		System.out.println("\t 1- login as admin");
		System.out.println("\t 2- login as customer");
		System.out.println("\t 3- signUp:");
		System.out.println("\t 4- exit:");
		System.out.println("Enter number from 1-4");
		choice = sc.nextInt();
		return choice;
	}
}
