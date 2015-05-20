import java.io.*;
import java.util.*;

public class StaffList //Name of class
{
	Staff[] theStaffs = new Staff[100]; //The size of the array is 100
	int nextFreeLocation=0;
	
	public void addStaff(Staff tempStaff) //Paramater for a new Staff
	{
		theStaffs[nextFreeLocation] = tempStaff;
		nextFreeLocation++; //adds 1 Staff
	}
	
	public void displayStaff()
	{
		System.out.println(theStaffs[0].toString());
	}
	
	public void writeToFile() //Takes information from text fields on the program and writes it to the database
	{
		
		try
		{
			FileWriter fstream = new FileWriter("listofstaff.txt"); //Name of text file to hold the full list of staff members
			BufferedWriter out = new BufferedWriter(fstream);
			
			for(int i=0;i<nextFreeLocation;i++)
			{
				out.write(theStaffs[i].toString());
				out.write("\r\n"); //Writing the newly added members to the next line
			}
			
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: " +e.getMessage()); //Error message
		}
	}

	public void readFile() //Takes information from the database and writes it to the text fields on the program
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader("listofstaff.txt")); //Name of text file to hold the full list of staff members
			String theNextStaff = in.readLine(); //read first line from file
			
			do
			{
				StringTokenizer sz = new StringTokenizer(theNextStaff, ","); //splits the text by comma
				Staff readStaff = new Staff(); //readStaff
				
				readStaff.forename = sz.nextToken();
				readStaff.surname = sz.nextToken();
				readStaff.middlename = sz.nextToken();
				readStaff.staffid = sz.nextToken();
				readStaff.dateofbirth = sz.nextToken();
				readStaff.password = sz.nextToken();
				
				addStaff(readStaff);
				theNextStaff = in.readLine(); //get next line from file
			} while (theNextStaff !=null);
		}
		
		catch (IOException e)
		{
			System.err.println("Unable to read from file"); //Unable to read from file error message
			System.exit(-1);
		}
	}
	
	public String[][] getBasicDetailsStaff() //Gathers basic details about a staff member such as their staff ID, forname, surname etc. from the database
	{
		String[][] myDetails = new String[nextFreeLocation][3];
		
		for(int i=0;i<nextFreeLocation;i++)
		{
			myDetails[i][0]=theStaffs[i].staffid;
			myDetails[i][1]=theStaffs[i].forename;
			myDetails[i][2]=theStaffs[i].surname;
		}
		
		return myDetails; //returning results
	}
	
	public Staff findStaff(int theLocation) //Returns the location a staff member is currently in, in the database
	{
		return theStaffs[theLocation];
	}
	
	public int searchName(String staffid) //Used for search functions in the program where a staff member can be searched for using their staff ID
	{
		int theFound = -1;
		
		for(int i = 0;i < nextFreeLocation; i++)
		{
			if(theStaffs[i].staffid.equals(staffid))
			{
				theFound = i;
			}
		}
		
		return theFound;
	}
	
	public void replaceStaff(int theLocation, Staff replacementStaff) //Used for when a staff member is to be edited and replaced
	{
		theStaffs[theLocation] = replacementStaff;
	}
	
	public static void main(String[] args)
	{
		StaffList list = new StaffList();
		Staff sf = new Staff(); //made an instance of Staff
		
		sf.forename = "Lewis"; //Forename example
		sf.surname = "Newsham"; //Surname example
		sf.middlename = "James"; //Middle Name (Optional) example
		sf.staffid = "abc11115555"; //Staff ID example
		sf.dateofbirth = "30/05/1995"; //Date of Birth example
		sf.password = "qwerty"; //Password example
		
		list.addStaff(sf); //addStaff method
		list.displayStaff(); //displayStaff method
		list.writeToFile(); //writeToFile method
	}
}