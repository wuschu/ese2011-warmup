import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class UserTest {

	User userOne = new User("userOne");
	User userTwo = new User("userTwo");

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
	public void testGetCalendarByName() {
		userOne.createCalendar("testCreation");
		assertTrue(userOne.getCalendarByName("testCreation").isEmpty());
		userOne.getCalendarByName("testCreation").addEvent(
				new Event("title", new Date(), new Date(), true));

		assertFalse(userOne.getCalendarByName("testCreation").isEmpty());
		assertEquals(userOne.getCalendarByName("testCreation")
				.getAllEventsOfCalendar(), "In calendar "
				+ userOne.getCalendarByName("testCreation").getCalendarName()
				+ " are the following events: "
				+ userOne.getCalendarByName("testCreation").toString());
	}

	@Test
	public void testIterator() {
		userOne.createCalendar("userOneCalendar");
		userTwo.createCalendar("userTwoCalendar");
		userOne.getCalendarByName("userOneCalendar").addEvent(
				new Event("user1event1", new Date(), new Date(), true));
		userOne.getCalendarByName("userOneCalendar").addEvent(
				new Event("user1event2", new Date(), new Date(), false));

		userTwo.getCalendarByName("userTwoCalendar").addEvent(
				new Event("user2event", new Date(), new Date(), false));

		assertTrue(userOne.getEventsAllowedToSee(
				userTwo.getCalendarByName("userTwoCalendar")).isEmpty());

		assertFalse(userTwo.getEventsAllowedToSee(
				userOne.getCalendarByName("userOneCalendar")).isEmpty());

		assertEquals(userTwo.getEventsAllowedToSee(
				userOne.getCalendarByName("userOneCalendar")).size(), 1);

		assertTrue(userTwo.getEventsAllowedToSee(
				userOne.getCalendarByName("userOneCalendar")).get(0).equals(
				userOne.getCalendarByName("userOneCalendar").getEventsAsList()
						.get(0)));

		assertFalse(userOne.getEventsAllowedToSee(
				userOne.getCalendarByName("userOneCalendar")).isEmpty());

		assertEquals(userOne.getEventsAllowedToSee(userOne
				.getCalendarByName("userOneCalendar")), userOne
				.getCalendarByName("userOneCalendar").getEventsAsList());

	}
}
