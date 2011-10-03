import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Calendar {
	public String calName;
	User owner;
	List<Event> eventList;

	public Calendar(String name, User owner) {
		this.calName = name;
		this.owner = owner;
		eventList = new LinkedList<Event>();
	}

	public void addEvent(Event event) {
		eventList.add(event);
	}

	public List<Event> getEventAtDate(Date date) {
		List<Event> eventsAtDateList = new LinkedList<Event>();
		for (Event event : eventList) {
			if (((event.getStartTime().getTime() / 1000 / 60 / 60 / 24) <= (date
					.getTime() / 1000 / 60 / 60 / 24))
					&& ((date.getTime() / 1000 / 60 / 60 / 24) <= (event
							.getEndTime().getTime() / 1000 / 60 / 60 / 24))) {
				eventsAtDateList.add(event);
			}

		}
		return eventsAtDateList;
	}

	public User getOwner() {
		return owner;
	}

	public String getCalendarName() {
		return calName;
	}

	public boolean isEmtpy() {
		return eventList.isEmpty();
	}

	public List<Event> getEventsAsList() {
		return eventList;
	}

	public String getAllEventsOfCalendar() {
		return "In calendar " + calName + " are the following events: "
				+ eventList.toString();
	}

	public String toString() {
		return eventList.toString();
	}
}
