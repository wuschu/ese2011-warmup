import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
	public String title;
	public Date startTime, endTime;
	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
	public boolean isPublic;

	public Event(String title, Date startsAt, Date endsAt, boolean isPublic) {
		this.title = title;
		this.startTime = startsAt;
		this.endTime = endsAt;
		this.isPublic = isPublic;
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

	public boolean isPublic() {
		return isPublic;
	}

	// usw... for all variables getters.

	public String toString() {
		return "Event: " + title + "\nStart: " + startTime + "\nEnd: "
				+ endTime + "\n";
	}
}
