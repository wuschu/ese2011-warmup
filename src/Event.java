public class Event {
	public String eventTitle, startTime, endTime;
	public int startDay, startMonth, startYear, endDay, endMonth, endYear;

	public Event(String title, int startDay, int startMonth, int startYear,
			int endDay, int endMonth, int endYear, String startTime,
			String endTime) {
		this.eventTitle = title;
		this.startDay = startDay;
		this.startMonth = startMonth;
		this.startYear = startYear;
		this.endDay = endDay;
		this.endMonth = endMonth;
		this.endYear = endYear;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getTitle() {
		return eventTitle;
	}

	public int getStartDay() {
		return startDay;
	}

	public int getStartMonth() {
		return startMonth;
	}

	// usw... for all variables getters.

	public String toString() {
		return "Event Details: \nTitle: " + eventTitle + "\n Starting: "
				+ startDay + "." + startMonth + "." + startYear + " "
				+ startTime + "\n Ending: " + endDay + "." + endMonth + "."
				+ endYear + " " + endTime;
	}
}
