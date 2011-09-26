import java.util.LinkedList;
import java.util.List;

public class User {
	public String name;
	List<Calendar> privateCalendarList;

	// List<Calendar> globalCalendarList = new LinkedList<Calendar>();

	public User(String username) {
		this.name = username;
		privateCalendarList = new LinkedList<Calendar>();

	}

	public String getName() {
		return name;
	}

	public void createCalendar(String name) {
		Calendar calendar = new Calendar(name, this);
		privateCalendarList.add(calendar);

	}

	public Calendar getCalendarByName(String calendarname) {
		for (Calendar calendar : privateCalendarList) {
			if (calendar.getCalendarName().equalsIgnoreCase(calendarname)) {
				return calendar;
			}
		}
		return null;
	}

	public List<Calendar> getPrivateCalendarList() {
		return privateCalendarList;
	}

	// iterator
	public List<Event> getEventsAllowedToSee(Calendar calendar) {
		List<Event> eventsAllowedToSee = new LinkedList<Event>();

		if (calendar.getOwner().equals(this))
			eventsAllowedToSee = calendar.getEventsAsList();
		else
			for (Event event : calendar.getEventsAsList()) {
				if (event.isPublic == true) {
					eventsAllowedToSee.add(event);
				}
			}
		return eventsAllowedToSee;
	}
}
