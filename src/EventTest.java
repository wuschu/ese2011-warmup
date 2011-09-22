import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class EventTest {
	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");

	@Test
	public void testEventStartAndEndDate() {
		try {
			Event event = new Event("ESE Lecture",
					formatter.parse("28.09.2011, 13:00"),
					formatter.parse("28.09.2011, 16:00"), false);
			assertEquals(event.getStartTime(),
					formatter.parse("28.09.2011, 13:00"));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEventEndDate() {
		try {
			Event event = new Event("ESE Lecture",
					formatter.parse("28.09.2011, 13:00"),
					formatter.parse("28.09.2011, 16:00"), false);
			assertEquals(event.getEndTime(),
					formatter.parse("28.09.2011, 16:00"));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEventName() {

	}

	@Test
	public void testEventIsPublic() {
		try {
			Event event = new Event("ESE Lecture",
					formatter.parse("28.09.2011, 13:00"),
					formatter.parse("28.09.2011, 16:00"), false);
			assertEquals(event.isPublic(), false);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
