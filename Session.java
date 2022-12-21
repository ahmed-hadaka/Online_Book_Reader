package projects.onlineBookReader;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Session {
	Scanner sc = new Scanner(System.in);

	private final Book CurBook;
	private int LastPage;
	private LocalDateTime LastVisiData;
	private final int Id;
	private static int temp = 0;

	public Session(Book curBook) {
		CurBook = curBook;
		LastPage = 1;
		LastVisiData = LocalDateTime.now();
		Id = ++temp;
	}

	public int getId() {
		return this.Id;
	}

	public String toString() {
		String s = "Id: " + Id + ", " + CurBook.getTitle() + ", " + "Page: " + LastPage + "/" + CurBook.getNumOfPages()
				+ ", " + LastVisiData;
		return s;
	}

	public void startReading() {
		while (true) {
			printPage(LastPage);
			int choice = menu();
			if (choice == 1) {
				if (isValid(LastPage + 1))
					LastPage = LastPage + 1;
				else
					System.out.println("Error: out of boundaries ");
			} else if (choice == 2) {
				if (isValid(LastPage - 1))
					LastPage = LastPage - 1;
				else
					System.out.println("Error: out of boundaries ");
			} else if (choice == 3) {
				LastVisiData = LocalDateTime.now(); // update
				break;
			} else
				System.out.println("Invalid choice. try agian.");
		}
	}

	private boolean isValid(int pageNum) {
		if ((pageNum <= CurBook.getNumOfPages()) && (pageNum > 0))
			return true;
		return false;
	}

	private int menu() {
		System.out.println("Menu: ");
		System.out.println("\t 1: Next Page");
		System.out.println("\t 2: Previous Page");
		System.out.println("\t 3: Stop Reading");
		int choice = sc.nextInt();
		return choice;
	}

	private void printPage(int pageNum) {
		System.out.println("Current Page: " + pageNum + "/" + CurBook.getNumOfPages());
		System.out.println(CurBook.listPageContent(pageNum) + "\n");
	}
}
