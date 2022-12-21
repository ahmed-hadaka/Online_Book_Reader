package projects.onlineBookReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookManager {
	Scanner sc = new Scanner(System.in);
	private Map<Integer, Book> books; // ISBN ==> book object

	public BookManager() {
		books = new HashMap<>();
	}

	public void read_and_addBook() {
		System.out.println("Enter ISBN: ");
		int ISBN = sc.nextInt();
		System.out.print("Enter Title: ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("Enter Author Name: ");
		String authorName = sc.nextLine();
		System.out.println("Enter number of pages: ");
		int numOfPages = sc.nextInt();
		Book book = new Book(ISBN, title, authorName, numOfPages);
		books.put(book.getISBN(), book);
		fillPages(book);
	}

	private void fillPages(Book book) {
		String content = "";
		for (int i = 1; i <= book.getNumOfPages(); i++) {
			System.out.print("Enter page # " + i + " content: ");
			sc.nextLine();
			content = sc.nextLine();
			book.fillPages(content, i);
		}
		System.out.println("book added successfully.");
	}

	public void listBooks() {
		int i = 1;
		for (Integer isbn : books.keySet()) {
			System.out.println(i++ + ": " + books.get(isbn).toString());
		}
	}

	public Book getBook(int isbn) {
		if (!books.containsKey(isbn)) {
			System.out.println("This book doesn't availabel in book collections!");
			return null;
		}
		return books.get(isbn);
	}

	// load initial book
	public void addBook(Book book, String page1, String page2) {
		books.put(book.getISBN(), book);
		book.fillPages(page1, 1);
		book.fillPages(page2, 2);
	}

	public void removeBook() {
		System.out.println("Enter book's ISBN to remove: ");
		int isbn = sc.nextInt();
		if (!books.containsKey(isbn))
			System.out.println("Invalid ISBN.");
		else {
			books.remove(isbn);
			System.out.println("book removed successfully");
		}
	}
}
