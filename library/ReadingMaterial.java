package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import library.Library.ReadingType;

/**
 * 
 */
public abstract class ReadingMaterial implements Comparable {
	/**
	 * 
	 */
	private class HistoryRecord {
		LocalDate take = null;
		LocalDate back = null;

		public HistoryRecord(LocalDate date) {
			if (date == null) {
				throw new NullPointerException();
			} else {
				this.take = date;

			}
		};
	}

	public interface IGroup {
	}

	/**
	 * 
	 */
	private String title = "";

	/**
	 * 
	 */
	private String publisher = "";

	/**
	 * 
	 */
	private int period = 0;

	/**
	 * 
	 */
	private double fee = 0;

	/**
	 * 
	 */
	private List<HistoryRecord> history = new ArrayList<>();

	/**
	 * 
	 * @param title
	 * @param publisher
	 */

	protected IGroup group;

	protected ReadingType type;

	public ReadingMaterial(IGroup group, String title, String publisher, int period, double fee) {
		super();
		this.group = group;

		if (title != null) {
			this.title = title;
		}
		if (publisher != null) {
			this.publisher = publisher;
		}
		if (period > 0) {
			this.period = period;
		}
		this.fee = fee;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher
	 *            the publisher to set
	 */

	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @return the fee
	 */
	public double getFee() {
		return fee;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReadingMaterial [title=" + title + ", publisher=" + publisher + "]";
	}

	/**
	 * 
	 * @param date
	 * @return
	 */

	public boolean take(LocalDate date) {

		if (history.size() == 0) {
			history.add(new HistoryRecord(date));
			return true;
		}
		HistoryRecord last = history.get(history.size() - 1);
		if (last.back == null) {
			return false;

		} else {
			history.add(new HistoryRecord(date));
			return true;
		}
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	// TODO
	public boolean back(LocalDate date) {
		if (history.size() == 0) {
			return false;
		}
		HistoryRecord last = history.get(history.size() - 1);

		if (last.take == null) {
			return false;
		} else {
			last.back = date;
			return true;
		}
	}

	/**
	 * 
	 * @return
	 */
	// TODO

	public ReadingType getType() {
		return type;
	}

	public IGroup getGroup() {
		return group;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((history == null) ? 0 : history.hashCode());
		result = prime * result + period;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReadingMaterial other = (ReadingMaterial) obj;
		if (Double.doubleToLongBits(fee) != Double.doubleToLongBits(other.fee))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (period != other.period)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
