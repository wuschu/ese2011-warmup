import java.util.ArrayList;

public class CalendarApplication {

	// creat an array of strings containing the names of the months
	String months[] = { "", "January", "February", "March", "April", "May",
			"June", "July", "August", "Septembre", "Octobre", "Novembre",
			"Decembre" };

	public static void main(String args[]) {
		CalendarApplication ca = new CalendarApplication();
		ArrayList<Event> eventList = new ArrayList<Event>();
		Event event = new Event("ESE Lecture", 28, 9, 2011, 28, 9, 2011,
				"12pm", "15pm");
		eventList.add(event);
		ca.addEvent(event);
		for (int i = 0; i >= eventList.size(); i++)
			eventList.get(i).toString();
		// initialize a new calendar with default location and time settings.
		// Calendar calendar = Calendar.getInstance();

	}

	public CalendarApplication() {

	}

	public void addEvent(Event event) {

	}
}
