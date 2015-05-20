import java.io.*;
import java.util.*;

public class OrderList
{
	Order[] theOrders = new Order[100]; //The size of the array is 100
	int nextFreeLocation=0;
	
	public void addOrder(Order tempOrder) //Paramater for a new Order
	{
		theOrders[nextFreeLocation] = tempOrder;
		nextFreeLocation++; //adds an order
	}
	
	public void displayOrder()
	{
		System.out.println(theOrders[0].toString());
	}
	
	public void writeToFile()
	{
		
		try
		{
			FileWriter fstream = new FileWriter("listoforders.txt"); //Name of text file to hold the full list of orders
			BufferedWriter out = new BufferedWriter(fstream); //read first line from file
			
			for(int i=0;i<nextFreeLocation;i++)
			{
				out.write(theOrders[i].toString());
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
			BufferedReader in = new BufferedReader(new FileReader("listoforders.txt")); //Name of text file to hold the full list of menu items
			String theNextOrder = in.readLine(); //read first line from file
			
			do
			{
				StringTokenizer sz = new StringTokenizer(theNextOrder, ","); //splits the text by comma
				Order readOrder = new Order();
				
				readOrder.productone = sz.nextToken();
				readOrder.producttwo = sz.nextToken();
				readOrder.productthree = sz.nextToken();
				readOrder.productfour = sz.nextToken();
				readOrder.productfive = sz.nextToken();
				readOrder.productsix = sz.nextToken();
				readOrder.productseven = sz.nextToken();
				readOrder.producteight = sz.nextToken();
				
				
				addOrder(readOrder);
				theNextOrder = in.readLine(); //get next line from file
			} while (theNextOrder !=null);
		}
		
		catch (IOException e)
		{
			System.err.println("Unable to read from file"); //Unable to read from file method
			System.exit(-1);
		}
	}
	
	public String[][] getBasicDetailsOrder() //getBasiCDetailsOrder to be used in the order table
	{
		String[][] myDetails = new String[nextFreeLocation][10];
		
		for(int i=0;i<nextFreeLocation;i++)
		{
			myDetails[i][0]=theOrders[i].productone;
			myDetails[i][1]=theOrders[i].producttwo;
			myDetails[i][2]=theOrders[i].productthree;
			myDetails[i][3]=theOrders[i].productfour;
			myDetails[i][4]=theOrders[i].productfive;
			myDetails[i][5]=theOrders[i].productsix;
			myDetails[i][6]=theOrders[i].productseven;
			myDetails[i][7]=theOrders[i].producteight;
		}
		
		return myDetails; //returning results
	}
	
	public Order findOrder(int theLocation)
	{
		return theOrders[theLocation];
	}
	
	
	public void replaceOrder(int theLocation, Order replacementOrder)
	{
		theOrders[theLocation] = replacementOrder;
	}
	
	
	
	public static void main(String[] args)
	{
		OrderList list = new OrderList();
		Order or = new Order(); //made an instance of Order
		
		or.productone="Pepperoni Pizza";
		or.producttwo="Diablo Pizza";
		or.productthree="Diablo Pizza";
		or.productfour="Garlic Bread";
		or.productfive="Garlic Bread";
		or.productsix="Magherita Pizza";
		or.productseven="Vanilla Ice Cream";
		or.producteight="Chocolate Ice Cream";
		
		list.addOrder(or); //addOrder method
		list.displayOrder(); //displayOrder method
		list.writeToFile(); //writeToFile method
	}
}