import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
	public String eventName;
	public Date startTime, endTime;
	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
	public boolean isPublic;

	public Event(String title, String startsAt, String endsAt, boolean isPublic) {
		try {
			this.eventName = title;
			this.startTime = formatter.parse(startsAt);
			this.endTime = formatter.parse(endsAt);
			this.isPublic = isPublic;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected String getTitle() {
		return eventName;
	}

	protected Date getStartTime() {
		return startTime;
	}

	protected Date getEndTime() {
		return endTime;
	}

	protected boolean isPublic() {
		return isPublic;
	}

	public String toString() {
		return "Event: " + eventName + "\nStarts: " + startTime + "\nEnd: "
				+ endTime + "\n";
	}
}
