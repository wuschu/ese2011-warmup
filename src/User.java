import java.util.LinkedList;
import java.util.List;

public class User {
	public String name;
	List<Calendar> privateCalendarList;
	// List<Calendar> globalCalendarList = new LinkedList<Calendar>();
	List<User> userList = new LinkedList<User>();

	public User(String username) {
		this.name = username;
		privateCalendarList = new LinkedList<Calendar>();
		userList.add(this);
	}

	public String getName() {
		return name;
	}

	// i would like to give the events different variables. but i don't know how
	// to initiate them automatically. MyCalendar1, MyCalendar2...
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

	// public List<Calendar> getGlobarCalendarList() {
	// for(User user : userList){
	// user.
	// }
	// return globalCalendarList;
	// }

	// Iterator
	public List<Event> getEventsAllowedToSee() {
		List<Event> eventsAllowedToSee = new LinkedList<Event>();
		for (Calendar calendar : privateCalendarList) { // has to be changed to
														// globalList... see
														// UserTest SysOut.
			if (calendar.getOwner().equals(this))
				eventsAllowedToSee = calendar.getEventsAsList();
			else
				for (Event event : calendar.getEventsAsList()) {
					if (event.isPublic == true) {
						eventsAllowedToSee.add(event);
					}
				}

		}
		return eventsAllowedToSee;
	}
}
