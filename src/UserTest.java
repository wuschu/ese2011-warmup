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
		// this test doesn't really make sense. but I could not figure out how
		// to give the calendars different variables on creating them... compare
		// comment in User.java (Line 17)
		assertFalse(testUser.getCalendarByName("testCreation").isEmpty());
	}

	@Test
	public void testIterator() {
		testUser.createCalendar("allowedToSeeAll");
		anotherTestUser.createCalendar("allowedToSeeOnlyPublicEvents");
		testUser.getCalendarByName("allowedToSeeAll").addEvent(
				new Event("user1event", new Date(), new Date(), true));
		anotherTestUser.getCalendarByName("allowedToSeeOnlyPublicEvents")
				.addEvent(
						new Event("user2event", new Date(), new Date(), false));

		System.out.println(testUser.getEventsAllowedToSee());
		System.out.println(anotherTestUser.getEventsAllowedToSee());
		// System.out.println(testUser.getGlobarCalendarList());
	}
}
