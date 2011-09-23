import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
		List<Event> testList = new LinkedList<Event>();
		testList.add(new Event("This Event should be found", new Date(),
				new Date(), false));
		try {
			calendar.addEvent(new Event("ESE Lecture", formatter
					.parse("28.09.2011, 13:00"), formatter
					.parse("28.09.2011, 16:00"), false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendar.addEvent(new Event("This Event should be found", new Date(),
				new Date(), false));

		assertFalse(calendar.getEventAtDate(new Date()).isEmpty());
		System.out.println(calendar.getEventAtDate(new Date()));
		System.out.println(new Event("This Event should be found", new Date(),
				new Date(), false).getEndTime().getTime());
		System.out.println(testList);
	}
}
