package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import java.util.Map.Entry;

import library.Book.Genre;
import library.Magazine.Category;
import library.ReadingMaterial.IGroup;
import library.SchoolBook.Theme;

public class Library {

	public enum ReadingType {
		BOOK, MAGAZINE, SCHOOLBOOK;
	};

	/**
	 * 
	 */
	private class ArchiveRecord {
		ReadingMaterial item = null;
		LocalDate take = null;
		LocalDate back = null;

		public ArchiveRecord(ReadingMaterial item, LocalDate date) {
			if (item != null) {
				this.item = item;
			}
			if (date != null) {
				this.take = date;
			}
		}

		@Override
		public String toString() {
			return "ArchiveRecord [item=" + item + ", take=" + take + ", back=" + back + "]";
		};
	}

	private List<ArchiveRecord> archive;

	private HashMap<ReadingType, HashMap<IGroup, TreeSet<ReadingMaterial>>> catalogue;

	private List<LibraryReader> readers;

	public Library() {
		this.archive = new ArrayList<>();
		this.catalogue = new HashMap<ReadingType, HashMap<IGroup, TreeSet<ReadingMaterial>>>();
		this.readers = new ArrayList<>();

		catalogue.put(ReadingType.BOOK, new HashMap<IGroup, TreeSet<ReadingMaterial>>());
		catalogue.put(ReadingType.MAGAZINE, new HashMap<IGroup, TreeSet<ReadingMaterial>>());
		catalogue.put(ReadingType.SCHOOLBOOK, new HashMap<IGroup, TreeSet<ReadingMaterial>>());
		catalogue.get(ReadingType.BOOK).put(Genre.BIOGRAPHY, new TreeSet<ReadingMaterial>());
		catalogue.get(ReadingType.BOOK).put(Genre.NOVEL, new TreeSet<ReadingMaterial>());
		catalogue.get(ReadingType.BOOK).put(Genre.THRILLER, new TreeSet<ReadingMaterial>());
		catalogue.get(ReadingType.SCHOOLBOOK).put(Theme.BIOLOGY, new TreeSet<ReadingMaterial>());
		catalogue.get(ReadingType.SCHOOLBOOK).put(Theme.HISTORY, new TreeSet<ReadingMaterial>());
		catalogue.get(ReadingType.SCHOOLBOOK).put(Theme.MATH, new TreeSet<ReadingMaterial>());
		catalogue.get(ReadingType.MAGAZINE).put(Category.FASHION, new TreeSet<ReadingMaterial>());
		catalogue.get(ReadingType.MAGAZINE).put(Category.SPORT, new TreeSet<ReadingMaterial>());
		catalogue.get(ReadingType.MAGAZINE).put(Category.TECH, new TreeSet<ReadingMaterial>());
	}

	public List<ArchiveRecord> getArchive() {
		return archive;
	}

	public void add(LibraryReader reader) {
		readers.add(reader);
	}

	public boolean add(ReadingMaterial item) {
		if (item == null) {
			return false;
		}

		ReadingType type = item.getType();
		IGroup group = item.getGroup();

		catalogue.get(type).get(group).add(item);
		return true;
	}

	public int countingAvailableItems() {

		int counter = 0;

		for (Entry<ReadingType, HashMap<IGroup, TreeSet<ReadingMaterial>>> e : catalogue.entrySet()) {

			for (Entry<IGroup, TreeSet<ReadingMaterial>> e1 : e.getValue().entrySet()) {

				counter += e1.getValue().size();
			}
		}
		return counter;
	}

	// TODO
	public boolean lend(ReadingMaterial item, LocalDate date, LibraryReader reader) {
		if (item == null) {
			throw new NullPointerException();
		}
		if (date == null) {
			throw new NullPointerException();
		}
		if (archive.contains(item)) {
			System.out.println("The item is not available");
			return false;
		}
		if (item instanceof Magazine) {
			System.out.println("You cannot take a magazine home. Read it here.");
			return false;

		} else {
			archive.add(new ArchiveRecord(item, date));

			item.take(date);

			catalogue.get(item.getType()).get(item.getGroup()).remove(item);
			return true;
		}
	}

	// TODO
	public boolean collect(ReadingMaterial item, LocalDate date) {
		if (item == null) {
			throw new NullPointerException();
		} else {
			for (ArchiveRecord record : archive) {
				if (record.item == item) {
					record.back = date;
					archive.remove(record);
					break;
				}
			}

			ReadingType type = item.getType();
			IGroup group = item.getGroup();

			catalogue.get(type).get(group).add(item);

			item.back(date);
			return true;
		}
	}

	public void enlistTakenItems() {
		for (ArchiveRecord a : archive) {
			System.out.println("All taken items are " + a.toString());
		}
	}

	public void printCatalogue() {
		for (Entry<ReadingType, HashMap<IGroup, TreeSet<ReadingMaterial>>> e : catalogue.entrySet()) {
			System.out.println("Size Hashmap " + e.getValue().size());
			System.out.println(e.getKey() + "====== :");
			for (Entry<IGroup, TreeSet<ReadingMaterial>> e1 : e.getValue().entrySet()) {
				System.out.println("  " + e1.getKey());
				System.out.println("Size TreeSet " + e1.getValue().size());
				for (ReadingMaterial r : e1.getValue()) {
					System.out.println(r);
				}
			}
		}
	}
}
