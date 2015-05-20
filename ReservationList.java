import java.io.*;
import java.util.*;

public class ReservationList
{
	Reservation[] theReservations = new Reservation[100]; //The size of the array is 100
	int nextFreeLocation=0;
	
	public void addReservation(Reservation tempReservation) //Paramater for a new Reservation
	{
		theReservations[nextFreeLocation] = tempReservation;
		nextFreeLocation++; //adds a reservation
	}
	
	public void displayReservation()
	{
		System.out.println(theReservations[0].toString());
	}
	
	public void writeToFile()
	{
		
		try
		{
			FileWriter fstream = new FileWriter("listofreservations.txt"); //Name of text file to hold the full list of reservations
			BufferedWriter out = new BufferedWriter(fstream); //read first line from file
			
			for(int i=0;i<nextFreeLocation;i++)
			{
				out.write(theReservations[i].toString());
				out.write("\r\n"); //Writing the newly added orders to the next line
			}
			
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: " +e.getMessage()); //Error message
		}
	}
	
	public void readFile()
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader("listofreservations.txt")); //Name of text file to hold the full list of menu items
			String theNextReservation = in.readLine(); //read first line from file
			
			do
			{
				StringTokenizer sz = new StringTokenizer(theNextReservation, ","); //splits the text by comma
				Reservation readReservation = new Reservation();
				
				readReservation.reservationid = sz.nextToken();
				readReservation.forename = sz.nextToken();
				readReservation.surname = sz.nextToken();
				readReservation.table = sz.nextToken();
				readReservation.date = sz.nextToken();
				readReservation.details = sz.nextToken();
				readReservation.phone = sz.nextToken();
				
				addReservation(readReservation);
				theNextReservation = in.readLine(); //get next line from file
			} while (theNextReservation !=null);
		}
		
		catch (IOException e)
		{
			System.err.println("Unable to read from file"); //Unable to read from file error message
			System.exit(-1);
		}
	}
	
	public String[][] getBasicDetailsReservation() //getBasicDetailsReservation to be used for the reservation table
	{
		String[][] myDetails = new String[nextFreeLocation][10];
		
		for(int i=0;i<nextFreeLocation;i++)
		{
			myDetails[i][0]=theReservations[i].reservationid;
			myDetails[i][1]=theReservations[i].forename;
			myDetails[i][2]=theReservations[i].surname;
		}
		
		return myDetails; //returning results
	}
	
	public String[][] getBasicDetailsReservationTable()
	{
		String[][] myDetails = new String[nextFreeLocation][10];
		
		for(int i=0;i<nextFreeLocation;i++)
		{
			myDetails[i][0]=theReservations[i].reservationid;
			myDetails[i][1]=theReservations[i].surname;
			myDetails[i][2]=theReservations[i].date;
			myDetails[i][3]=theReservations[i].table;
		}
		
		return myDetails; //returning results
	}
	
	public Reservation findReservation(int theLocation)
	{
		return theReservations[theLocation];
	}
	
	public int searchName(String reservationid)
	{
		int theFound = -1;
		
		for(int i = 0;i < nextFreeLocation; i++)
		{
			if(theReservations[i].reservationid.equals(reservationid))
			{
				theFound = i;
			}
		}
		
		return theFound;
	}
	
	
	public void replaceReservation(int theLocation, Reservation replacementReservation)
	{
		theReservations[theLocation] = replacementReservation;
	}
	
	
	
	public static void main(String[] args)
	{
		ReservationList list = new ReservationList();
		Reservation ab = new Reservation(); //made an instance of reservation
		
		ab.reservationid = "1";
		ab.forename = "Lewis";
		ab.surname = "Newsham";
		ab.table = "4";
		ab.date = "28/04/2013";
		ab.details = "Family Meal";
		ab.phone = "01772123456";
		
		
		list.addReservation(ab); //addReservation method
		list.displayReservation(); //displayReservation method
		list.writeToFile(); //writeToFile method
	}
}