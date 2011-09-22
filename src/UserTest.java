import static org.junit.Assert.*;

import org.junit.Test;



public class UserTest {
	
	@Test
	public void testIfUserHasName(){
		User testUser = new User("testuser");
		assertEquals(testUser.getName(), "testuser");
	}
	
}
