package library;

import java.util.Date;

import library.Library.ReadingType;

/**
 * 
 */
public class Magazine extends ReadingMaterial {
	/**
	 * 
	 */
	public enum Category implements IGroup {
		SPORT, FASHION, TECH;
	}

	/**
	 * 
	 */
	private int issue = 0;

	/**
	 * 
	 */
	private Category genre = null;

	/**
	 * 
	 */
	private Date published = null;

	protected ReadingType type = null;

	/**
	 * 
	 * @param title
	 * @param publisher
	 * @param issue
	 * @param genre
	 * @param published
	 */
	public Magazine(String title, String publisher, int issue, Category genre, Date published) {
		super(genre, title, publisher, 0, 0);
		this.type = ReadingType.MAGAZINE;
		if (issue > 0) {
			this.issue = issue;
		}
		if (genre != null) {
			this.genre = genre;
		}
		if (published != null) {
			this.published = published;
		}
	}

	/**
	 * @return the issue
	 */
	public int getIssue() {
		return issue;
	}

	/**
	 * @param issue
	 *            the issue to set
	 */
	public void setIssue(int issue) {
		this.issue = issue;
	}

	/**
	 * @return the genre
	 */
	public Category getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(Category genre) {
		this.genre = genre;
	}

	/**
	 * @return the published
	 */
	public Date getPublished() {
		return published;
	}

	/**
	 * @param published
	 *            the published to set
	 */
	public void setPublished(Date published) {
		this.published = published;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Magazine [issue=" + issue + ", genre=" + genre + ", published=" + published + "]" + super.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Object object) {
		if (object instanceof Magazine == false) {
			throw new RuntimeException("Not a Magazine!");
		}

		Magazine magazine = (Magazine) object;

		if (this.genre == magazine.genre) {
			if (this.getTitle().equals(magazine.getTitle())) {
				if (this.issue == magazine.issue) {
					return 0;
				} else if (this.issue < magazine.issue) {
					return -1;
				} else if (this.issue > magazine.issue) {
					return +1;
				}
			} else if (this.getTitle().compareTo(magazine.getTitle()) < 0) {
				return -1;
			} else if (this.getTitle().compareTo(magazine.getTitle()) > 0) {
				return +1;
			}
		} else if (this.genre.ordinal() < magazine.genre.ordinal()) {
			return -1;
		} else if (this.genre.ordinal() > magazine.genre.ordinal()) {
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
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + issue;
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
		Magazine other = (Magazine) obj;
		if (genre != other.genre)
			return false;
		if (issue != other.issue)
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
