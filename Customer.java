package projects.onlineBookReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// opening multiple sessions from the same book (supported)
public class Customer extends User {
	Scanner sc = new Scanner(System.in);
	private Map<Integer, Session> sessions; // session id ==> session object
	private BookManager bookManager;

	public Customer(String name, String userName, String passWord, String email) {
		super(name, userName, passWord, email);
		sessions = new HashMap<>();
		bookManager = new BookManager(); // initial value
	}

	public void go(BookManager bm) {
		bookManager = bm;
		System.out.println("Hello " + getName() + " | User Veiw");
		while (true) {
			int choice = menu();
			if (choice == 1) {
				viewProfile();
			} else if (choice == 2) {
				list_and_select_from_readingHistory();
			} else if (choice == 3) {
				list_and_select_from_availableBooks();
			} else if (choice == 4) {
				list_and_remove_from_sessions();
			} else if (choice == 5) {
				clearSessions();
			} else if (choice == 6) {
				System.out.println("Goodbye :)");
				break;
			} else {
				System.out.println("Invalid choice. try again");
			}
		}
	}

	private void list_and_remove_from_sessions() {
		listReadingHistory();
		System.out.println("Enter session id to remove: ");
		int id = sc.nextInt();
		if (!sessions.containsKey(id))
			System.out.println("book's id doesn't exist. try again");
		else {
			sessions.remove(id);
			System.out.println("Session Removed Successfully");
		}
	}

	private void list_and_select_from_availableBooks() {
		bookManager.listBooks();
		System.out.println("Enter book ISBN to open: ");
		int ISBN = sc.nextInt();
		Book book = bookManager.getBook(ISBN);
		if (book != null) {
			Session session = new Session(book);
			sessions.put(session.getId(), session);
			session.startReading();
		}
	}

	private void list_and_select_from_readingHistory() {
		listReadingHistory();
		System.out.println("Enter session id to open: ");
		int id = sc.nextInt();
		if (!sessions.containsKey(id))
			System.out.println("Invalid choice. try again");
		else {
			sessions.get(id).startReading();
		}
	}

	private int menu() {
		System.out.println("Menu: ");
		System.out.println("\t 1: View Profile");
		System.out.println("\t 2: list & select from reading history");
		System.out.println("\t 3: list & select from available books");
		System.out.println("\t 4: lsit & remove from reading history");
		System.out.println("\t 5: clear all sessions");
		System.out.println("\t 6: logout");
		System.out.println("Enter number from 1 - 6: ");
		int choice = sc.nextInt();
		return choice;
	}

	private void listReadingHistory() {
		int i = 1;
		for (Integer key : sessions.keySet()) {
			System.out.println(i++ + ": " + sessions.get(key).toString());
		}
	}

	private void clearSessions() {
		sessions.clear();
		System.out.println("All Sessions Removed");
	}

}
