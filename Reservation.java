public class Reservation
{	
	String reservationid="1"; //reservation id
	String forename="Lewis"; //reservation forename
	String surname="Newsham"; //reservation surname
	String table="4"; //reservation table number
	String date="28/04/2013"; //reservation date
	String details="Family Meal"; //reservation details
	String phone="01772 123456"; //reservation phone
	
	
	public String toString()
	{
		return reservationid+","+forename+","+surname+","+table+","+date+","+details+","+phone; //Returns the reservation details
	}
}