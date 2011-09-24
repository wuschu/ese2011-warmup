import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Calendar {
	User owner;
	String calName;
	List<Event> eventList;

	public Calendar(String name, User owner) {
		this.owner = owner;
		this.calName = name;
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

	public boolean isEmpty() {
		return eventList.isEmpty();
	}

	public String getAllEventsOfCalendar() {
		return "In calendar " + calName + " are the following events: "
				+ eventList.toString();

	}

}
