import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class UserTest {

	User userOne = new User("userOne");
	User userTwo = new User("userTwo");
	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
	Date date = new Date();

	@Test
	public void testIfUserHasName() {
		assertEquals(userOne.getName(), "userOne");
	}

	@Test
	public void testCreateCalendar() {
		userOne.createCalendar("testCreation");
		assertFalse(userOne.getPrivateCalendarList().isEmpty());
	}

	@Test
	public void testGetCalendar() {
		userOne.createCalendar("testCreation");
		assertTrue(userOne.getCalendarByName("testCreation").isEmtpy());
		userOne.getCalendarByName("testCreation").addEvent(
				new Event("title", formatter.format(date), formatter
						.format(date), true));
		assertFalse(userOne.getCalendarByName("testCreation").isEmtpy());
		assertEquals(userOne.getCalendarByName("testCreation")
				.getAllEventsOfCalendar(),
				"In calendar "
						+ userOne.getCalendarByName("testCreation")
								.getCalendarName()
						+ " are the following events: "
						+ userOne.getCalendarByName("testCreation").toString());
	}

	@Test
	public void testIterator() {
		userOne.createCalendar("userOneCalendar");
		userTwo.createCalendar("userTwoCalendar");
		userOne.getCalendarByName("userOneCalendar").addEvent(
				new Event("user1event1", formatter.format(date), formatter
						.format(date), true));
		userOne.getCalendarByName("userOneCalendar").addEvent(
				new Event("user1event2", formatter.format(date), formatter
						.format(date), false));

		userTwo.getCalendarByName("userTwoCalendar").addEvent(
				new Event("user2event", formatter.format(date), formatter
						.format(date), false));

		assertTrue(userOne.getEventsAllowedToSee(
				userTwo.getCalendarByName("userTwoCalendar"), date).isEmpty());

		assertFalse(userTwo.getEventsAllowedToSee(
				userOne.getCalendarByName("userOneCalendar"), new Date(0))
				.isEmpty());

		assertEquals(
				userTwo.getEventsAllowedToSee(
						userOne.getCalendarByName("userOneCalendar"),
						new Date(0)).size(), 1);

		assertTrue(userTwo
				.getEventsAllowedToSee(
						userOne.getCalendarByName("userOneCalendar"),
						new Date(0))
				.get(0)
				.equals(userOne.getCalendarByName("userOneCalendar")
						.getEventsAsList().get(0)));

		assertFalse(userOne.getEventsAllowedToSee(
				userOne.getCalendarByName("userOneCalendar"), new Date(0))
				.isEmpty());

		assertEquals(userOne.getEventsAllowedToSee(
				userOne.getCalendarByName("userOneCalendar"), new Date(0)),
				userOne.getCalendarByName("userOneCalendar").getEventsAsList());

	}

}
