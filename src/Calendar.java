import java.util.ArrayList;

public class Calendar {
	User owner = new User("Dominik");
	String calName;
	// creat an array of strings containing the names of the months
	String months[] = { "", "January", "February", "March", "April", "May",
			"June", "July", "August", "Septembre", "Octobre", "Novembre",
			"Decembre" };

	public Calendar(String name, User user) {
		this.owner = user;
		this.calName = name;
	}

	public void addEvent(Event event) {

	}
	
	public User getOwner(){
		return owner;
	}
	
	public String getCalendarName(){
		return calName;
	}
}
