public class Menu
{
	String itemnumber="1"; //menu itemnumber
	String itemname="Pepperoni Pizza"; //menu itemname
	String itemextras="Chilli and Garlic"; //menu itemextras
	Double price=8.00; //menu price
	String priceString = String.valueOf(price);
	
	
	
	public String toString()
	{
		return itemnumber+","+itemname+","+itemextras+","+price; //Returns the item menu details
	}
}