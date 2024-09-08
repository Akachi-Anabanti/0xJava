// a Book details class
//


public class Book {
	private String title;
	private String author;
	private int year;
	private static int nBooks = 0; // number of books created

	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
		nBooks += 1; 
	}

	public void showDetails() {
		System.out.printf("Title: %s - Author: %s - Year: %d\n",
				title, author, year);
	}

	public static int getTotalBooks() {
		return nBooks;
	}

	public static void main(String[] args) {
		Book book1 = new Book("Essential Mathematics",
				"Akachi Anabanti", 2025);
		book1.showDetails();

		System.out.printf("Current number of books = %d\n", Book.getTotalBooks());

		Book book2 = new Book("Essential Economics",
				"Ogochukwu Anabanti", 2028);
		book2.showDetails();
		
		System.out.printf("Current number of books = %d\n", Book.getTotalBooks());
	}
}
