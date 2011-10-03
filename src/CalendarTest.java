import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class CalendarTest {
	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
	Calendar calendar = new Calendar("testCal", new User("testOwner"));

	@Test
	public void testIfCalendarHasName() {
		assertEquals(calendar.getCalendarName(), "testCal");
	}

	@Test
	public void testIfCalendarHasOwner() {
		assertEquals(calendar.getOwner().getName(), "testOwner");
	}

	@Test
	public void testIfCalendarHasEvent() {
		calendar.addEvent(new Event("ESE Lecture", "28.09.2011, 13:00",
				"28.09.2011, 16:00", false));
		assertFalse(calendar.isEmtpy());
	}

	@Test
	public void testEventAtDate() {
		calendar.addEvent(new Event("ESE Lecture", "28.09.2011, 13:00",
				"28.09.2011, 16:00", false));

		calendar.addEvent(new Event("This event should be found",
				"26.09.2011, 10:00", "26.09.2011, 11:00", false));

		assertFalse(calendar.getEventAtDate(new Date()).isEmpty());

		assertEquals(calendar.getEventAtDate(new Date()).get(0).getTitle(),
				"This event should be found");
	}

	@Test
	public void testEventOverMultipleDays() {
		Date date = new Date();

		calendar.addEvent(new Event("ESE Lecture", "28.09.2011, 13:00",
				"28.09.2011, 16:00", false));

		// event started in the past until today
		calendar.addEvent(new Event("the one from the past",
				"21.09.2011, 13:00", formatter.format(date), false));

		// event starting today and go on for like forever....
		calendar.addEvent(new Event("the one in the future", formatter
				.format(date), "12.12.2025, 13:00", false));

		assertFalse(calendar.getEventAtDate(new Date()).isEmpty());
		assertEquals(calendar.getEventAtDate(new Date()).get(0).getTitle(),
				"the one from the past");
		assertEquals(calendar.getEventAtDate(new Date()).get(1).getTitle(),
				"the one in the future");
	}

	@Test
	public void testGetAllEventsGetCalendarNameAndToString() {
		Date date = new Date();

		calendar.addEvent(new Event("ESE Lecture", "21.09.2011, 13:00",
				"21.09.2011, 16:00", false));

		calendar.addEvent(new Event("the one from the past",
				"21.09.2011, 13:00", formatter.format(date), false));

		assertEquals(calendar.getAllEventsOfCalendar(), "In calendar "
				+ calendar.getCalendarName() + " are the following events: "
				+ calendar.toString());

	}

}
