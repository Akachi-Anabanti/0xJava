// a Book details class
//


public class Book {
	static String title;
	static String author;
	static int year;

	static void showDetails() {
		System.out.printf("Title: %s - Author: %s - Year: %d\n",
				title, author, year);
	}

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.title = "Essential Mathematics";
		book1.author = "Akachi Anabanti";
		book1.year = 2025;
		book1.showDetails();

		Book book2 = new Book();
		book2.title = "Essential Economics";
		book2.author = "Ogochukwu Anabanti";
		book2.year = 2028;
		book2. showDetails();
	}
}
