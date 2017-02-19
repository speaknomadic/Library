package library;

import library.Library.ReadingType;

/**
 * 
 */
public class SchoolBook extends ReadingMaterial {

	/**
	 * 
	 */
	public enum Theme implements IGroup {
		MATH, BIOLOGY, HISTORY;
	}

	/**
	 * 
	 */
	private String author = "";

	/**
	 * 
	 */
	private Theme genre = null;

	private ReadingType type = null;

	/**
	 * 
	 * @param title
	 * @param publisher
	 * @param author
	 * @param genre
	 */
	public SchoolBook(String title, String publisher, String author, Theme genre) {
		super(genre, title, publisher, 150, 3);
		this.type = ReadingType.SCHOOLBOOK;
		this.author = author;
		this.genre = genre;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the genre
	 */
	public Theme getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(Theme genre) {
		this.genre = genre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SchoolBook [author=" + author + ", genre=" + genre + ", " + super.toString() + "]";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Object object) {
		if (object instanceof SchoolBook == false) {
			throw new RuntimeException("Not a Magazine!");
		}

		SchoolBook schoolBook = (SchoolBook) object;

		if (this.genre == schoolBook.genre) {
			if (this.getTitle().equals(schoolBook.getTitle())) {
				return 0;
			} else if (this.getTitle().compareTo(schoolBook.getTitle()) < 0) {
				return -1;
			} else if (this.getTitle().compareTo(schoolBook.getTitle()) > 0) {
				return +1;
			}
		} else if (this.genre.ordinal() < schoolBook.genre.ordinal()) {
			return -1;
		} else if (this.genre.ordinal() > schoolBook.genre.ordinal()) {
			return +1;
		}

		throw new RuntimeException("Something went wrong!");
	}

	@Override
	public ReadingType getType() {
		return type;
	}

	@Override
	public IGroup getGroup() {
		return genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolBook other = (SchoolBook) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre != other.genre)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
