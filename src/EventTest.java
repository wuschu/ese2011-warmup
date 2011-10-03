import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class EventTest {
	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");

	Event event = new Event("ESE Lecture", "28.09.2011, 13:00",
			"28.09.2011, 16:00", false);

	@Test
	public void testEventStartDate() {
		try {
			assertEquals(event.getStartTime(),
					formatter.parse("28.09.2011, 13:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testEventEndDate() {
		try {
			assertEquals(event.getEndTime(),
					formatter.parse("28.09.2011, 16:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEventName() {
		assertEquals(event.getTitle(), "ESE Lecture");
	}

	@Test
	public void testEventIsPublic() {
		assertEquals(event.isPublic(), false);
	}
}
