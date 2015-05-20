import java.io.*;
import java.util.*;

public class AdminList
{
	Admin[] theAdmins = new Admin[100]; //The size of the array is 100
	int nextFreeLocation=0;
	
	public void addAdmin(Admin tempAdmin) //Paramater for a new Admin
	{
		theAdmins[nextFreeLocation] = tempAdmin;
		nextFreeLocation++; //adds 1 Admin
	}
	
	public void displayAdmin()
	{
		System.out.println(theAdmins[0].toString());
	}
	
	public void writeToFile()
	{
		
		try
		{
			FileWriter fstream = new FileWriter("listofadmin.txt"); //Name of text file to hold the full list of administrators
			BufferedWriter out = new BufferedWriter(fstream);
			
			for(int i=0;i<nextFreeLocation;i++)
			{
				out.write(theAdmins[i].toString());
				out.write("\r\n"); //Writing the newly added administrator to the next line
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
			BufferedReader in = new BufferedReader(new FileReader("listofadmin.txt")); //Name of text file to hold the full list of administrators
			String theNextAdmin = in.readLine(); //read first line from file
			
			do
			{
				StringTokenizer sz = new StringTokenizer(theNextAdmin, ","); //splits the text by comma
				Admin readAdmin = new Admin();
				
				readAdmin.forename = sz.nextToken();
				readAdmin.surname = sz.nextToken();
				readAdmin.middlename = sz.nextToken();
				readAdmin.adminid = sz.nextToken();
				readAdmin.dateofbirth = sz.nextToken();
				readAdmin.password = sz.nextToken();
				
				addAdmin(readAdmin);
				theNextAdmin = in.readLine(); //get next line from file
			} while (theNextAdmin !=null);
		}
		
		catch (IOException e)
		{
			System.err.println("Unable to read from file"); //Unable to read from file error message
			System.exit(-1);
		}
	}
	
	public String[][] getBasicDetailsAdmin()
	{
		String[][] myDetails = new String[nextFreeLocation][3];
		
		for(int i=0;i<nextFreeLocation;i++)
		{
			myDetails[i][0]=theAdmins[i].adminid;
			myDetails[i][1]=theAdmins[i].forename;
			myDetails[i][2]=theAdmins[i].surname;
		}
		
		return myDetails; //returning results
	}
	
	public Admin findAdmin(int theLocation)
	{
		return theAdmins[theLocation];
	}
	
	public int searchName(String adminid)
	{
		int theFound = -1;
		
		for(int i = 0;i < nextFreeLocation; i++)
		{
			if(theAdmins[i].adminid.equals(adminid))
			{
				theFound = i;
			}
		}
		
		return theFound;
	}
	
	public void replaceAdmin(int theLocation, Admin replacementAdmin)
	{
		theAdmins[theLocation] = replacementAdmin;
	}
	
	public static void main(String[] args)
	{
		AdminList list = new AdminList();
		Admin ad = new Admin(); //made an instance of Admin
		
		ad.forename = "Lewis";
		ad.surname = "Newsham";
		ad.middlename = "James";
		ad.adminid = "abc11115555";
		ad.dateofbirth = "30/05/1995";
		ad.password = "qwerty";

		
		list.addAdmin(ad); //addAdmin method
		list.displayAdmin(); //displayAdmin method
		list.writeToFile(); //writeToFile method
	}
}