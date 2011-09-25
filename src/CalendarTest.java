import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class CalendarTest {
	Calendar calendar = new Calendar("testCal", new User("testOwner"));
	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");

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
		try {
			calendar.addEvent(new Event("ESE Lecture", formatter
					.parse("28.09.2011, 13:00"), formatter
					.parse("28.09.2011, 16:00"), false));
			assertFalse(calendar.isEmpty());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEventAtDate() {
		try {
			calendar.addEvent(new Event("ESE Lecture", formatter
					.parse("21.09.2011, 13:00"), formatter
					.parse("21.09.2011, 16:00"), false));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendar.addEvent(new Event("This Event should be found", new Date(),
				new Date(), false));

		assertFalse(calendar.getEventAtDate(new Date()).isEmpty());

		assertEquals(calendar.getEventAtDate(new Date()).get(0).getTitle(),
				"This Event should be found");

	}

	@Test
	public void testEventOverMultipleDays() {
		try {
			calendar.addEvent(new Event("ESE Lecture", formatter
					.parse("21.09.2011, 13:00"), formatter
					.parse("21.09.2011, 16:00"), false));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// event started in the past until today
		try {
			calendar.addEvent(new Event("the one from the past", formatter
					.parse("21.09.2011, 13:00"), new Date(), false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// event starting today and go on for like forever....
		try {
			calendar.addEvent(new Event("the one in the future", new Date(),
					formatter.parse("12.12.2025, 13:00"), false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertFalse(calendar.getEventAtDate(new Date()).isEmpty());

		assertEquals(calendar.getEventAtDate(new Date()).get(0).getTitle(),
				"the one from the past");
		assertEquals(calendar.getEventAtDate(new Date()).get(1).getTitle(),
				"the one in the future");

	}

	@Test
	public void testGetAllEventsGetCalendarNameAndToString() {
		try {
			calendar.addEvent(new Event("ESE Lecture", formatter
					.parse("21.09.2011, 13:00"), formatter
					.parse("21.09.2011, 16:00"), false));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// event started in the past until today
		try {
			calendar.addEvent(new Event("the one from the past", formatter
					.parse("21.09.2011, 13:00"), new Date(), false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(calendar.getAllEventsOfCalendar(), "In calendar "
				+ calendar.getCalendarName() + " are the following events: "
				+ calendar.toString());
	}
}
