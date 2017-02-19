import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import library.Book;
import library.Library;
import library.LibraryReader;
import library.Magazine;
import library.SchoolBook;

public class Demo {

	public static void main(String[] args) {

		Library library = new Library();

		Book book1 = new Book("Book 1", "Publisher 1", "Author 1", new Date(), Book.Genre.BIOGRAPHY);
		Book book2 = new Book("Book 2", "Publisher 2", "Author 2", new Date(), Book.Genre.NOVEL);
		Book book3 = new Book("Book 3", "Publisher 3", "Author 3", new Date(), Book.Genre.THRILLER);
		Book book4 = new Book("Book 4", "Publisher 4", "Author 4", new Date(), Book.Genre.THRILLER);
		Magazine magazine1 = new Magazine("Magazine 4", "Publisher 4", 4, Magazine.Category.FASHION, new Date());
		Magazine magazine2 = new Magazine("Magazine 1", "Publisher 1", 1, Magazine.Category.FASHION, new Date());
		Magazine magazine3 = new Magazine("Magazine 2", "Publisher 2", 2, Magazine.Category.SPORT, new Date());
		Magazine magazine4 = new Magazine("Magazine 3", "Publisher 3", 3, Magazine.Category.TECH, new Date());
		SchoolBook schoolBook1 = new SchoolBook("SchoolBook1", "Publisher 1", "Author 1", SchoolBook.Theme.BIOLOGY);
		SchoolBook schoolBook2 = new SchoolBook("SchoolBook2", "Publisher 2", "Author 2", SchoolBook.Theme.HISTORY);
		SchoolBook schoolBook3 = new SchoolBook("SchoolBook3", "Publisher 3", "Author 3", SchoolBook.Theme.MATH);

		library.add(schoolBook3);
		library.add(schoolBook2);
		library.add(schoolBook1);
		library.add(magazine4);
		library.add(magazine3);
		library.add(magazine2);
		library.add(magazine1);
		library.add(book4);
		library.add(book3);
		library.add(book2);
		library.add(book1);

		LibraryReader reader1 = new LibraryReader("Ivan", 300);
		LibraryReader reader2 = new LibraryReader("Mariya", 2000);
		library.add(reader1);
		library.add(reader2);

		LocalDate today = LocalDate.now();

		reader1.borrow(book1, library, today);
		reader2.borrow(book2, library, today);
		// System.out.println(reader2.borrow(book2, library, today)); - >returns
		// false
		reader2.borrow(book3, library, today);
		reader2.borrow(book4, library, today);
		reader2.borrow(schoolBook1, library, today);
		reader2.borrow(schoolBook2, library, today);
		// System.out.println(reader2.borrow(schoolBook2, library, today)); - >
		// returns false
		library.enlistTakenItems();
		// library.printCatalogue();

		System.out.println("All taken items in: ");
		library.enlistTakenItems();

		Period oneMonth = Period.ofMonths(1);
		LocalDate returnBook = today.plus(oneMonth);

		System.out.println("Available items are " + library.countingAvailableItems());

		reader2.giveBack(book2, library, returnBook);
		reader2.giveBack(book4, library, returnBook);
		reader2.giveBack(book3, library, returnBook);
		library.enlistTakenItems();
		// System.out.println("Available items are " +
		// library.countingAvailableItems());

	}

}
