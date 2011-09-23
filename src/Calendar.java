import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Calendar {
	User owner = new User("Dominik");
	String calName;
	List<Event> eventList;
	// creat an array of strings containing the names of the months
	String months[] = { "", "January", "February", "March", "April", "May",
			"June", "July", "August", "Septembre", "Octobre", "Novembre",
			"Decembre" };

	public Calendar(String name, User user) {
		this.owner = user;
		this.calName = name;
		eventList = new LinkedList<Event>();
	}

	public void addEvent(Event event) {
		eventList.add(event);
	}

	public List<Event> getEventAtDate(Date date) {
		float factor = 1 / 1000 / 60 / 60 / 24;
		List<Event> eventsAtDateList = new LinkedList<Event>();
		for (Event event : eventList) {
			if (((event.getStartTime().getTime() * factor) <= (date.getTime() * factor))
					&& ((date.getTime() * factor) <= (event.getEndTime()
							.getTime() * factor))) {
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
