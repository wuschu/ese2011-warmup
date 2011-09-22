import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class UserTest {

	User testUser = new User("testuser");

	@Test
	public void testIfUserHasName() {

		assertEquals(testUser.getName(), "testuser");
	}

	@Test
	public void testCreateCalendar() {
		testUser.createCalendar("testCreation");
		assertFalse(testUser.getCalendarList().isEmpty());
	}
}
