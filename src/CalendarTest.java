import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
}
