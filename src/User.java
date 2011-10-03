import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class User {
	public String name;
	List<Calendar> privateCalendarList;

	// List<User> userList = new LinkedList<User>();

	public User(String username) {
		this.name = username;
		privateCalendarList = new LinkedList<Calendar>();
		// userList.add(this);
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
	public List<Event> getEventsAllowedToSee(Calendar calendar, Date date) {
		List<Event> eventsAllowedToSee = new LinkedList<Event>();

		if (calendar.getOwner().equals(this))
			for (Event event : calendar.getEventsAsList()) {
				if (event.getEndTime().after(date)) {
					eventsAllowedToSee.add(event);
				}
			}
		else
			for (Event event : calendar.getEventsAsList()) {
				if (event.isPublic == true && event.getEndTime().after(date)) {
					eventsAllowedToSee.add(event);
				}
			}
		return eventsAllowedToSee;
	}

}
