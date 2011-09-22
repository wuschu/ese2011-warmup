import java.util.LinkedList;
import java.util.List;

public class User {
	public String name;
	List<Calendar> calendarList;

	public User(String username) {
		this.name = username;
		calendarList = new LinkedList<Calendar>();
	}

	public String getName() {
		return name;
	}

	public void createCalendar(String name) {
		calendarList.add(new Calendar(name, this));
	}

	public List<Calendar> getCalendarList() {
		return calendarList;
	}
}
