package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryReader {

	private String name = "";
	private List<ReadingMaterial> items = new ArrayList<>();
	private int money = 0;

	public LibraryReader(String name, int money) {
		if (name != null) {
			this.name = name;
		}
		if (money > 0) {
			this.money = money;
		}
	}

	// TODO
	public boolean borrow (ReadingMaterial item, Library library, LocalDate date) {
		if (library.lend(item, date, this)) {
			items.add(item);
			money -= item.getFee();
			return true;
		} else {
			return false;
		}
	}

	public void giveBack (ReadingMaterial item, Library library, LocalDate date) {
		if (item == null) {
			throw new NullPointerException();
		}
		if (library == null) {
			throw new NullPointerException();
		}
		if (date == null) {
			throw new NullPointerException();
		}
		if (items.contains(item)) {
			items.remove(item);
			library.collect(item, date);
			
		} else {
			System.out.println("This book is not from our library");

		}
	}
}
