import java.io.*;
import java.util.*;

public class MenuList
{
	Menu[] theMenus = new Menu[100]; //The size of the array is 100
	int nextFreeLocation=0;
	
	public void addMenu(Menu tempMenu) //Paramater for a new Menu
	{
		theMenus[nextFreeLocation] = tempMenu;
		nextFreeLocation++; //adds a Menu
	}
	
	public void displayMenu()
	{
		System.out.println(theMenus[0].toString());
	}
	
	public void writeToFile()
	{
		
		try
		{
			FileWriter fstream = new FileWriter("listofitems.txt"); //Name of text file to hold the full list of menu items
			BufferedWriter out = new BufferedWriter(fstream); //read first line from file
			
			for(int i=0;i<nextFreeLocation;i++)
			{
				out.write(theMenus[i].toString());
				out.write("\r\n"); //Writing the newly added menu items to the next line
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
			BufferedReader in = new BufferedReader(new FileReader("listofitems.txt")); //Name of text file to hold the full list of menu items
			String theNextMenu = in.readLine(); //read first line from file
			
			do
			{
				StringTokenizer sz = new StringTokenizer(theNextMenu, ","); //splits the text by comma
				Menu readMenu = new Menu();
				
				readMenu.itemnumber = sz.nextToken();
				readMenu.itemname = sz.nextToken();
				readMenu.itemextras = sz.nextToken();
				readMenu.priceString = sz.nextToken();
				
				addMenu(readMenu);
				theNextMenu = in.readLine(); //get next line from file
			} while (theNextMenu !=null);
		}
		
		catch (IOException e)
		{
			System.err.println("Unable to read from file"); //Unable to read from file error message
			System.exit(-1);
		}
	}
	
	public String[][] getBasicDetailsMenu() //getBasicDetailsMenu method to be used in the menu table
	{
		String[][] myDetails = new String[nextFreeLocation][4];
		
		for(int i=0;i<nextFreeLocation;i++)
		{
			myDetails[i][0]=theMenus[i].itemnumber;
			myDetails[i][1]=theMenus[i].itemname;
			myDetails[i][2]=theMenus[i].itemextras;
			myDetails[i][3]=theMenus[i].priceString;
		}
		
		return myDetails; //returning results
	}
	
	public Menu findMenu(int theLocation)
	{
		return theMenus[theLocation];
	}
	
	public int searchName(String itemnumber)
	{
		int theFound = -1;
		
		for(int i = 0;i < nextFreeLocation; i++)
		{
			if(theMenus[i].itemnumber.equals(itemnumber))
			{
				theFound = i;
			}
		}
		
		return theFound;
	}
	
	
	public void replaceMenu(int theLocation, Menu replacementMenu)
	{
		theMenus[theLocation] = replacementMenu;
	}
	
	
	
	public static void main(String[] args)
	{
		MenuList list = new MenuList();
		Menu mn = new Menu(); //made an instance of Menu
		
		mn.itemnumber = "1";
		mn.itemname = "Pepperoni Pizza";
		mn.itemextras = "Chilli and Garlic";
		mn.price = 8.00;
		
		
		list.addMenu(mn);
		list.displayMenu();
		list.writeToFile();
	}
}