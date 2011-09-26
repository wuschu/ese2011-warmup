import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class UserTest {

	User testUser = new User("testuser");
	User anotherTestUser = new User("otherTestuser");

	@Test
	public void testIfUserHasName() {
		assertEquals(testUser.getName(), "testuser");
	}

	@Test
	public void testCreateCalendar() {
		testUser.createCalendar("testCreation");
		assertFalse(testUser.getPrivateCalendarList().isEmpty());
	}

	@Test
	public void testGetCalendarByName() {
		testUser.createCalendar("testCreation");
		assertTrue(testUser.getCalendarByName("testCreation").isEmpty());
		testUser.getCalendarByName("testCreation").addEvent(
				new Event("title", new Date(), new Date(), true));

		assertFalse(testUser.getCalendarByName("testCreation").isEmpty());
		assertEquals(testUser.getCalendarByName("testCreation")
				.getAllEventsOfCalendar(), "In calendar "
				+ testUser.getCalendarByName("testCreation").getCalendarName()
				+ " are the following events: "
				+ testUser.getCalendarByName("testCreation").toString());
	}

	@Test
	public void testIterator() {
		testUser.createCalendar("allowedToSeeAll");
		anotherTestUser.createCalendar("allowedToSeeOnlyPublicEvents");
		testUser.getCalendarByName("allowedToSeeAll").addEvent(
				new Event("user1event1", new Date(), new Date(), true));
		testUser.getCalendarByName("allowedToSeeAll").addEvent(
				new Event("user1event2", new Date(), new Date(), false));

		anotherTestUser.getCalendarByName("allowedToSeeOnlyPublicEvents")
				.addEvent(
						new Event("user2event", new Date(), new Date(), false));

		assertTrue(testUser.getEventsAllowedToSee(
				anotherTestUser
						.getCalendarByName("allowedToseeonlypublicevents"))
				.isEmpty());

		System.out.println(anotherTestUser.getEventsAllowedToSee(testUser
				.getCalendarByName("allowedToSeeAll")));
		System.out.println(testUser.getEventsAllowedToSee(anotherTestUser
				.getCalendarByName("allowedToseeonlypublicevents")));
		System.out.println(testUser.getEventsAllowedToSee(testUser
				.getCalendarByName("allowedtoseeall")));

	}
}
