package projects.onlineBookReader;

import java.util.Scanner;

public class AdminManager extends User {
	Scanner sc = new Scanner(System.in);

	private CustomerManager customerManager;
	private BookManager bookManager;

	public AdminManager(String name, String userName, String passWord, String email) {
		super(name, userName, passWord, email);
		customerManager = new CustomerManager();
		bookManager = new BookManager(); // default values
	}

	public void doLogin(CustomerManager cm, BookManager bm) {
		this.customerManager = cm;
		this.bookManager = bm;
		System.out.print("Enter user name: ");
		String tempUserName = sc.nextLine();
		System.out.print("Enter password: ");
		String tempPassword = sc.nextLine();
		if (!this.getUserName().equals(tempUserName) || !this.getPassword().equals(tempPassword)) {
			System.out.println("Invalid username or password.");
			return;
		}
		go();
	}

	private void go() {
		System.out.println("Hello " + getName() + " | Admin Veiw");
		while (true) {
			int choice = menu();
			if (choice == 1)
				viewProfile();
			else if (choice == 2) {
				bookManager.read_and_addBook();
			} else if (choice == 3) {
				bookManager.listBooks();
				bookManager.removeBook();
			} else if (choice == 4) {
				bookManager.listBooks();
			} else if (choice == 5) {
				customerManager.listCustomers();
			} else if (choice == 6) {
				customerManager.listCustomers();
				customerManager.removeCustomer();
			} else if (choice == 7) {
				System.out.println("Goodbye :)\n");
				break;
			} else {
				System.out.println("Invalid choice. try again");
			}
		}
	}

	private int menu() {
		System.out.println("Menu: ");
		System.out.println("\t 1: View Profile");
		System.out.println("\t 2: Add Book");
		System.out.println("\t 3: Remove Book");
		System.out.println("\t 4: List All Books");
		System.out.println("\t 5: List System Customers");
		System.out.println("\t 6: Remove Customer");
		System.out.println("\t 7: Logout");
		int choice = sc.nextInt();
		return choice;
	}
}
