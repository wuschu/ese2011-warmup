import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class CalendarTest {

	
	@Test
	public void testIfCalendarHasName(){
		Calendar calendar = new Calendar("testCal", new User("testOwner"));
		assertEquals(calendar.getCalendarName(), "testCal");
	}
	
	@Test
	public void testIfCalendarHasOwner(){
		Calendar calendar = new Calendar("testCal", new User("testOwner"));
		assertEquals(calendar.getOwner().getName(), "testOwner");
	}
	
	@Test
	public void testIfCalendarHasEvent(){
		
	}
}
