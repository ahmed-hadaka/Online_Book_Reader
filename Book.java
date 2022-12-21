package projects.onlineBookReader;

public class Book {
	private final int ISBN;
	private final String Title;
	private final String AuthorName;
	private final int numOfPages;
	private String[] Pages;

	public Book(int iSBN, String title, String authorName, int numOfPages) {
		ISBN = iSBN;
		Title = title;
		AuthorName = authorName;
		this.numOfPages = numOfPages;
		Pages = new String[numOfPages];
	}

	public int getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return Title;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void fillPages(String content, int index) {
		// zero index
		Pages[--index] = content;
	}

	public String listPageContent(int index) {
		// zero index
		return Pages[--index];
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", Title=" + Title + ", AuthorName=" + AuthorName + "]";
	}

}
