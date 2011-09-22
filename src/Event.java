import java.util.Date;

public class Event {
	public String title;
	public Date startTime, endTime;

	public Event(String title, Date startsAt, Date endsAt) {
		this.title = title;
		this.startTime = startsAt;
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	// usw... for all variables getters.

	public String toString() {
		return "";
	}
}
