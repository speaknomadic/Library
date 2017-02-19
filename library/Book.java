package library;

import java.util.Date;

import library.Library.ReadingType;

/**
 * 
 */
public class Book extends ReadingMaterial {
	/**
	 * 
	 */
	public enum Genre implements IGroup {
		NOVEL, THRILLER, BIOGRAPHY;
	}

	/**
	 * 
	 */
	private String author = "";

	/**
	 * 
	 */
	private Date published = null;

	/**
	 * 
	 */
	private Genre genre = null;

	protected ReadingType type = null;

	public Book(String title, String publisher, String author, Date published, Genre genre) {
		super(genre, title, publisher, 300, 2);
		this.type = ReadingType.BOOK;
		if (author != null) {
			this.author = author;
		}
		if (published != null) {
			this.published = published;
		}
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
	 * @return the published
	 */
	public Date getPublished() {
		return published;
	}


	/**
	 * @return the genre
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [author=" + author + ", published=" + published + ", genre=" + genre + "] " + super.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Object object) {
		if (object instanceof Book == false) {
			throw new RuntimeException("Not a book instance!");
		}

		Book book = (Book) object;

		if (this.genre == book.genre) {
			return published.compareTo(book.published);
		} else if (this.genre.ordinal() < book.genre.ordinal()) {
			return -1;
		} else if (this.genre.ordinal() > book.genre.ordinal()) {
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
		result = prime * result + ((published == null) ? 0 : published.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre != other.genre)
			return false;
		if (published == null) {
			if (other.published != null)
				return false;
		} else if (!published.equals(other.published))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
