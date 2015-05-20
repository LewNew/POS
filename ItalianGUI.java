import javax.swing.*;  //components needed for GUI
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date; //compnent needed for the date
import java.text.DateFormat; //component needed for the date format
import java.text.SimpleDateFormat; //component needed for the date format (simple)
import java.util.Calendar; //component needed for the calendar

//class shows how to setup up a tabbed window

public class ItalianGUI implements ActionListener
{
	//a panel for each tab
	
	JPanel displayLoginPanel = new JPanel(); //login page
	
	JPanel displayHomePanel = new JPanel(); //home page
	
	JPanel displayMenuAndOrderPanel = new JPanel(); //menu and order page
	
	JPanel displayReservationPanel = new JPanel(); //reservation page
	
	JPanel displayCreationPanel = new JPanel(); //creation page
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	//Setting up tables
	
	JTable staffTable; //staff list table (creation page)
	
	JTable adminTable; //admin list table (creation page)
	
	JTable menuTable; //menu list table (order page)
	
	JTable orderTable; //order list table (order page)
	
	JTable reservationTable; //reservation list table (reservation page)
	
	JTable blankTable; //blank table (creaton page)
	
	JScrollPane staffScroll; //staff list table scrollpane
	
	JScrollPane adminScroll; //admin list table scrollpane
	
	JScrollPane menuScroll; //menu list table scrollpane
	
	JScrollPane orderScroll; //order list table scrollpane
	
	JScrollPane reservationScroll; //reservation list table scrollpane
	
	String[] blankHeadings = {" "," "," "}; //Blank table for when no table is to be shown on the creation page
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	JOptionPane frame = new JOptionPane();
	
	StaffList allStaff = new StaffList(); //Declaring allStaff from StaffList
	
	Staff oneStaff = new Staff(); //Declaring oneStaff
	
	Staff currentStaff = new Staff(); //Declaring currentStaff
	
	AdminList allAdmins = new AdminList(); //Declaring allAdmins from Adminlist
	
	Admin oneAdmin = new Admin(); //Declaring oneAdmin
	
	Admin currentAdmin = new Admin(); //Declaring currentAdmin
	
	OrderList allOrders = new OrderList(); //Declaring allOrder from OrderList
	
	Order oneOrder = new Order(); //Declaring oneOrder
	
	Order currentOrder = new Order(); //Declaring currentOrder
	
	MenuList allMenus = new MenuList(); //Declaring allMenus from MenuList
	
	Menu oneMenu = new Menu(); //Declaring oneMenu
	
	Menu currentMenu = new Menu(); //Declaring currentMenu
	
	ReservationList allReservations = new ReservationList(); //Declaring allReservations from ReservationList
	
	Reservation oneReservation = new Reservation(); //Declaring oneReservation
	
	Reservation currentReservation = new Reservation(); //Declaring currentReservation
	
	String[] staffHeadings = {"Staff ID","Forename","Surname"}; //Staff Table headings
	
	String[] adminHeadings = {"Admin ID","Forename","Surname"}; //Admin Table headings
	
	String[] menuHeadings = {"Item Number","Item Name","Item Extras","Price"}; //Menu Table headings
	
	String[] orderHeadings = {"Item Number","Item Name","Item Extras","Price"}; //Order Table headings
	
	String[] reservationHeadings = {"ID","Surname","Date","Table No."}; //Reservation Table headings
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	//backgrounds
	
	ImageIcon loginpic = new ImageIcon("loginbackground.jpg"); //login background picture
	
	JLabel theLoginBackground = new JLabel(loginpic); //login background picture
	
	ImageIcon homepic = new ImageIcon("homebackground.jpg"); //home background picture
	
	JLabel theHomeBackground = new JLabel(homepic); //home background image
	
	ImageIcon MenuAndOrderpic = new ImageIcon("menuandorderbackground.jpg"); //menu and reservation background picture
	
	JLabel theMenuAndOrderBackground = new JLabel(MenuAndOrderpic); //menu and reservation background picture
	
	ImageIcon Reservationpic = new ImageIcon("reservationbackground.jpg"); //reservation background picture
	
	JLabel theReservationBackground = new JLabel(Reservationpic); //reservation background picture
	
	ImageIcon creationpic = new ImageIcon("creationbackground.jpg"); //creation background picture
	
	JLabel theCreationBackground = new JLabel(creationpic); //creation background image
	
	//images
	
	ImageIcon italianpic = new ImageIcon("italianorchard.jpg"); //italian orchard image
	
	JLabel theItalianOrchardPic = new JLabel(italianpic); //italian orchard image
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

	static JFrame aWindow = new JFrame("Italian Orchard's Café"); //name of program
	
	JTabbedPane myTabs = new JTabbedPane();
	
	//home page buttons
	
	JButton HomeButtonReservation = new JButton("Home Page"); //button which will take the user to the home page from the reservation page
	
	JButton HomeButtonMenuAndOrder = new JButton("Home Page"); //button which will take the user to the home page from the menu and order page page
	
	JButton HomeButtonCreation = new JButton("Home Page"); //button which will take the user to the home page from the creation page
	
	//panel components for home page
	
	JLabel HomeItalianOrchardLabel = new JLabel("Italian Orchard: Home"); //Italian Orchard: Home label
	
	JButton LogoutButton = new JButton("Logout"); //allows the user to log out of the program when clicked
	
	JButton GoToReservationButton = new JButton("Reservation Page"); //takes the user to the reservation page when clicked
	
	JButton GoToMenuAndOrderButton = new JButton("Menu and Order Page"); //takes the user to the menu and order page when clicked
	
	JButton GoToCreationButton = new JButton("Creation Page"); //takes the user to the points page when clicked
	
	//panel components for login page (general)
	
	ImageIcon staffpic = new ImageIcon("staff.jpg"); //staff login picture
	
	JLabel StaffLoginPic = new JLabel(staffpic); //staff login picture
	
	ImageIcon adminpic = new ImageIcon("admin.jpg"); //admin login picture
	
	JLabel AdminLoginPic = new JLabel(adminpic); //admin login picture
	
	JLabel ItalianOrchardLabel = new JLabel("Italian Orchard"); //Italian Orchard label
	
	JButton ExitButton = new JButton("Exit Program"); //button that will exit the program when clicked
	
	JButton ForgotPassButton = new JButton("Forgot your Password?"); //forgot your password? button
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	//panel components for login page
	
	JButton EnableStaffPasswordButton = new JButton("Change Password?"); //button that enables the staff member to change their password
	
	JButton EnableAdminPasswordButton = new JButton("Change Password?"); //button that enables the administrator to change their password
	
	JButton ChangeStaffPasswordButton = new JButton("Change Password"); //button that changes the staff member's password if passwords entered are correct
	
	JButton ChangeAdminPasswordButton = new JButton("Change Password"); //button that changes the administrator's password if passwords entered are correct
	
	JPasswordField ExistingPasswordField = new JPasswordField(); //field which the user inputs their existing password used to log in
	
	JLabel ExistingPasswordLabel = new JLabel("Current Password:"); //existing password field label
	
	JPasswordField NewPasswordField = new JPasswordField(); //field which the user inputs their new desired password which they will use to log in
	
	JLabel NewPasswordLabel = new JLabel("New Password:"); //new password field label
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	//panel components for login page (staff)
	
	JLabel StaffUserLabel = new JLabel("Username:"); //staff Username: label
	
	JLabel StaffPassLabel = new JLabel("Password:"); //staff Password: label
	
	JLabel StaffLabel = new JLabel("Staff"); //Staff label
	
	JTextField StaffTextField = new JTextField(); //staff username textfield
	
	JPasswordField StaffPassField = new JPasswordField(); //staff password field
	
	JButton StaffLoginButton = new JButton("Login Here"); //staff login button
	
	JButton StaffForgotPassButton = new JButton("Forgot your Password?"); //staff forgot your password? button
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	//panel components for login page (admin)
	
	JLabel AdminUserLabel = new JLabel("Username:"); //admin Username: label
	
	JLabel AdminPassLabel = new JLabel("Password:"); //admin Password: label
	
	JLabel AdminLabel = new JLabel("Admin"); //Admin label

	JTextField AdminTextField = new JTextField(); //admin username textfield
	
	JPasswordField AdminPassField = new JPasswordField(); //admin password field
	
	JButton AdminLoginButton = new JButton("Login Here"); //admin login button
	
	JButton AdminForgotPassButton = new JButton("Forgot your Password?"); //admin forgot your password? button
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	//panel components for menu and order page (creating menu items)
	
	JLabel OrderItalianOrchardLabel = new JLabel("Italian Orchard: Menu and Order"); //Italian Orchard: Menu and Order label
	
	JButton CreateItemButton = new JButton("Create Item"); //button to activate the item creation text fields
	
	JButton FinishItemButton = new JButton("Finish Creation"); //button to save the information in item creation textfields to file
	
	JLabel ItemNumberLabel = new JLabel("Item Number:"); //Item Number: label
	
	JLabel ItemNameLabel = new JLabel("Item Name:"); //Item Name: label
	
	JLabel ItemExtrasLabel = new JLabel("Item Extras:"); //Item Extras: label
	
	JLabel PriceLabel = new JLabel("Price:"); //Price: label
	
	JTextField ItemNumberField = new JTextField(); //Item Number textfield
	
	JTextField ItemNameField = new JTextField(); //Item Name textfield
	
	JTextField ItemExtrasField = new JTextField(); //Item Extras textfield
	
	JTextField PriceField = new JTextField(); //Price textfield
	
	//panel components for menu and order page (adding menu items)
	
	JLabel ProductOneLabel = new JLabel("#1"); //#1 label
	
	JTextField ProductOneTextField = new JTextField(); //Product one textfield
	
	JLabel ProductTwoLabel = new JLabel("#2"); //#2 label
	
	JTextField ProductTwoTextField = new JTextField(); //Product two textfield
	
	JLabel ProductThreeLabel = new JLabel("#3"); //#3 label
	
	JTextField ProductThreeTextField = new JTextField(); //Product three textfield
	
	JLabel ProductFourLabel = new JLabel("#4"); //#4 label
	
	JTextField ProductFourTextField = new JTextField(); //Product four textfield
	
	JLabel ProductFiveLabel = new JLabel("#5"); //#5 label
	
	JTextField ProductFiveTextField = new JTextField(); //Product five textfield
	
	JLabel ProductSixLabel = new JLabel("#6"); //#6 label
	
	JTextField ProductSixTextField = new JTextField(); //Product six textfield
	
	JLabel ProductSevenLabel = new JLabel("#7"); //#7 label
	
	JTextField ProductSevenTextField = new JTextField(); //Product seven textfield
	
	JLabel ProductEightLabel = new JLabel("#8"); //#8 label
	
	JTextField ProductEightTextField = new JTextField(); //Product eight textfield
	
	JButton CreateOrderButton = new JButton("Create Order"); //button to activate the order creation textfields
	
	JButton FinishOrderButton = new JButton("Finish Order"); //button to save the information in the order creation textfields to file
	
	//general panel components for menu and order page
	
	JButton ClearMenuAndOrderButton = new JButton("Clear Fields"); //button to clear all fields and disable them on menu and order page
	
	JLabel OrderCreateItemLabel = new JLabel("Create a Menu Item"); //Create a Menu Item label
	
	JLabel OrderCreateOrderLabel = new JLabel("Create an Order"); //Create an Order label
	
	JPanel CreateItemPanel = new JPanel(); //item panel for order page
	
	JPanel CreateOrderPanel = new JPanel(); //order panel for order page
	
	JLabel MenuAndOrderItalianOrchardLabel = new JLabel("Italian Orchard: Menu and Order"); //Italian Orchard: Menu and Order label

//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

	//panel components for reservation page
	
	JLabel ReservationItalianOrchardLabel = new JLabel("Italian Orchard: Reservation"); //Italian Orchard: Reservation label
	
	JButton ReservationCreateButton = new JButton("Create Reservation"); //when clicked, it enables the Reservation fields for when a staff member or administrator is to be added
	
	JButton ReservationSearchButton = new JButton("Search"); //when clicked, it enables the Reservation fields
	
	JButton ReservationEnableSearchButton = new JButton("Search Reservation");
	
	JLabel ReservationSearchLabel = new JLabel("Search Reservation ID:"); //Search ID: label
	
	JTextField ReservationSearchField = new JTextField(); //Search ID textfield
	
	JLabel ReservationIDLabel = new JLabel("Reservation ID:"); //Reservation ID: label
	
	JTextField ReservationIDTextField = new JTextField(); //Reservation ID textfield
	
	JLabel ReservationSearchIDLabel = new JLabel("Reservation ID:"); //Reservation ID: label (search)
	
	JTextField ReservationSearchIDTextField = new JTextField(); //Reservation ID textfield (search)
	
	JLabel ReservationForeLabel = new JLabel("Forename:"); //Forename: label
	
	JTextField ReservationForeTextField = new JTextField(); //Forename textfield
	
	JLabel ReservationSearchForeLabel = new JLabel("Forename:"); //Forename: label (search)
	
	JTextField ReservationSearchForeTextField = new JTextField(); //Forename textfield (search)
	
	JLabel ReservationSurLabel = new JLabel("Surname:"); //Surname: label
	
	JTextField ReservationSurTextField = new JTextField(); //Surname textfield
	
	JLabel ReservationSearchSurLabel = new JLabel("Surname:"); //Surname: label (search)
	
	JTextField ReservationSearchSurTextField = new JTextField(); //Surname textfield
	
	JLabel ReservationTableLabel = new JLabel("Table Number:"); //Table Number: label
	
	JTextField ReservationTableTextField = new JTextField(); //Table Number textfield
	
	JLabel ReservationSearchTableLabel = new JLabel("Table Number:"); //Table Number: label (search)
	
	JTextField ReservationSearchTableTextField = new JTextField(); //Table Number textfield (search)
	
	JLabel ReservationDateLabel = new JLabel("Reservation Date:"); //Reservation Date: label
	
	JTextField ReservationDateTextField = new JTextField(); //Reservation Date textfield
	
	JLabel ReservationSearchDateLabel = new JLabel("Reservation Date:"); //Reservation Date: label (search)
	
	JTextField ReservationSearchDateTextField = new JTextField(); //Reservation Date textfield (search)
	
	JLabel ReservationDetailsLabel = new JLabel("Reservation Details:"); //Reservation Details: label
	
	JTextField ReservationDetailsTextField = new JTextField(); //Reservation Details textfield
	
	JLabel ReservationSearchDetailsLabel = new JLabel("Reservation Details:"); //Reservation Details: label (search)
	
	JTextField ReservationSearchDetailsTextField = new JTextField(); //Reservation Details textfield (search)
	
	JLabel ReservationPhoneLabel = new JLabel("Phone Number:"); //Reservation Phone Number: label
	
	JTextField ReservationPhoneTextField = new JTextField(); //Reservation Phone Number textfield
	
	JLabel ReservationSearchPhoneLabel = new JLabel("Phone Number:"); //Reservation Phone Number: label (search)
	
	JTextField ReservationSearchPhoneTextField = new JTextField(); //Reservation Phone Number textfield (search)
	
	JButton ReservationAddButton = new JButton("Add Reservation"); //add reservation button

	JButton ReservationEditButton = new JButton("Edit Reservation"); //edit reservation button
	
	JButton ReservationClearFieldsButton = new JButton("Clear Details"); //clears all the fields
	
	JButton ReservationHomeButton = new JButton("Home Page"); //directs the user back to the home page
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	//panel components for creation page
	
	JButton StaffIDButton = new JButton("Staff ID List"); //button which will show the table with a list of staff members when clicked
	
	JButton AdminIDButton = new JButton("Admin ID List"); //button which will show the table with a list of administrators when clicked
	
	JLabel CreationItalianOrchardLabel = new JLabel("Italian Orchard: Creation"); //Italian Orchard: Creation label
	
	JButton CreationSearchAndEditButton = new JButton("Search and Edit a Staff or Admin"); //when clicked, it enables the search fields when searching for a staff member or an administrator
	
	JButton CreationCreateButton = new JButton("Create a new Staff or Admin"); //when clicked, it enables the creation fields for when a staff member or administrator is to be added
	
	JLabel CreationStaffSearchLabel = new JLabel("Search Staff ID:"); //Search ID: label
	
	JTextField CreationStaffSearchField = new JTextField(); //Search ID textfield
	
	JButton CreationStaffSearchButton = new JButton("Search"); //Search: label
	
	JLabel CreationAdminSearchLabel = new JLabel("Search Admin ID:"); //Search ID: label
	
	JTextField CreationAdminSearchField = new JTextField(); //Search ID textfield
	
	JButton CreationAdminSearchButton = new JButton("Search"); //Search: label

	JLabel CreationStaffForeLabel = new JLabel("Staff Forename:"); //Staff Forename: label

	JTextField StaffForeTextField = new JTextField(); //staff forename textfield
	
	JLabel CreationAdminForeLabel = new JLabel("Admin Forename:"); //Admin Forename: label
	
	JTextField AdminForeTextField = new JTextField(); //admin forename textfield

	JLabel CreationStaffSurLabel = new JLabel("Staff Surname:"); //Staff Surname: label
	
	JLabel CreationAdminSurLabel = new JLabel("Admin Surname:"); //Admin Surname: label

	JTextField StaffSurTextField = new JTextField(); //staff surname textfield
	
	JTextField AdminSurTextField = new JTextField(); //admin surname textfield

	JLabel CreationStaffMiddleLabel = new JLabel("Middle name (optional):"); //Staff Middle name (optional): label
	
	JLabel CreationAdminMiddleLabel = new JLabel("Middle name (optional):"); //Admin Middle name (optional): label

	JTextField StaffMiddleTextField = new JTextField(); //staff middle name textfield
	
	JTextField AdminMiddleTextField = new JTextField(); //admin middle name textfield

	JLabel CreationStaffIDLabel = new JLabel("Staff ID:"); //Staff ID: label
	
	JLabel CreationAdminIDLabel = new JLabel("Admin ID:"); //Admin ID: label

	JTextField StaffIDTextField = new JTextField(); //staff id textfield
	
	JTextField AdminIDTextField = new JTextField(); //admin id textfield

	JLabel CreationStaffBirthLabel = new JLabel("Staff Date of Birth:"); //Staff Date of Birth: label
	
	JLabel CreationAdminBirthLabel = new JLabel("Admin Date of Birth:"); //Admin Date of Birth: label
	
	JTextField StaffBirthTextField = new JTextField(); //staff date of birth textfield
	
	JTextField AdminBirthTextField = new JTextField(); //admin date of birth textfield
	
	JLabel CreationStaffPasswordLabel = new JLabel("Staff Password:"); //Staff Password: label
	
	JLabel CreationAdminPasswordLabel = new JLabel("Admin Password:"); //Admin Password: label
	
	JTextField StaffPasswordTextField = new JTextField(); //staff password textfield
	
	JTextField AdminPasswordTextField = new JTextField(); //admin password textfield
	
	JButton CreationCreateStaffButton = new JButton("Create Staff"); //enables all the fields which are used for inputting information about a staff member
	
	JButton CreationCreateAdminButton = new JButton("Create Admin"); //enables all the fields which are used for inputting information about an administrator
	
	JButton CreationAddStaffButton = new JButton("Add Staff"); //add staff button
	
	JButton CreationAddAdminButton = new JButton("Add Admin"); //add admin button

	JButton CreationEditStaffButton = new JButton("Edit Staff"); //edit staff button
	
	JButton CreationEditAdminButton = new JButton("Edit Admin"); //edit admin button
	
	JButton CreationClearFieldsButton = new JButton("Clear Details"); //clears all the fields
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

	//declaring the date
	
	JTextField TheDate = new JTextField(); //date textfield to be displayed on the home page

//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	public void runGUI()
	{
		allStaff.readFile(); //StaffList readFile method
		allAdmins.readFile(); //AdminList readFile method
		allMenus.readFile(); //MenuList readFile method
		allOrders.readFile(); //OrderList readFile method
		allReservations.readFile();//ReservationList readFile method
	
		//start of generic GUI code
		Toolkit theKit = aWindow.getToolkit();
		Dimension wndSize=theKit.getScreenSize();
		
		aWindow.setBounds(wndSize.width/4, wndSize.height/4, wndSize.width/2, wndSize.height/2); //set position, then dimensions
		aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		GridLayout grid = new GridLayout(1,1); //layout of grid
		Container content = aWindow.getContentPane();
		content.setLayout(grid);
		
		//end of generic GUI code
		
		//date code
		
		Calendar javaCalendar = null; //declaring Calendar
		
		String currentDate = "";
		
		javaCalendar = Calendar.getInstance(); //Calendar getInstance
		
		currentDate = javaCalendar.get(Calendar.DATE) + "/" + (javaCalendar.get (Calendar.MONTH) + 1) + "/" + javaCalendar.get(Calendar.YEAR); //calendar format
		
		TheDate.setText("Welcome! Today's date is "+currentDate); //calendar message
		TheDate.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //borderless calendar
		TheDate.setEditable(false); //set calendar
		
		//call individual methods to create panels
		
		createLoginPanel(); //declaring the login page
		
		createHomePanel(); //declaring the home page
		
		CreateOrderPanel(); //declaring the menu and order page
		
		createReservationPanel(); //declaring the reservation page
		
		createCreationPanel(); //declaring the creation page
	
		//can now add individual panels
		
		myTabs.addTab("Login Page", displayLoginPanel); //giving the login page a name
		
		myTabs.addTab("Home Page", displayHomePanel); //giving the home page a name
		
		myTabs.addTab("Menu and Order Page", displayMenuAndOrderPanel); //giving the order page a name
		
		myTabs.addTab("Reservation Page", displayReservationPanel); //giving the menu and reservation page a name
		
		myTabs.addTab("Creation Page", displayCreationPanel); //giving the creation page a name
		
		myTabs.setEnabledAt(0, true); //sets the login page to be active when the program starts up
		myTabs.setEnabledAt(1, false); //sets the home page to be inactive when the program starts up
		myTabs.setEnabledAt(2, false); //sets the menu and order page to be inactive when the program starts up
		myTabs.setEnabledAt(3, false); //sets the reservation page to be inactive when the program starts up
		myTabs.setEnabledAt(4, false); //sets the creation page to be inactive when the program starts up
		
		//adds all the tabs to the GUI
		content.add(myTabs);
		
		//make the GUI appear
		aWindow.setVisible(true); //Sets the component to be visible //sets the GUI to be visible
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public void createReservationPanel()
	{
		displayReservationPanel.setLayout(null);
		
		displayReservationPanel.add(ReservationItalianOrchardLabel);
		ReservationItalianOrchardLabel.setBounds(25, 10, 750, 100);
		ReservationItalianOrchardLabel.setFont(new Font("Blackadder ITC", Font.PLAIN, 72));
		ReservationItalianOrchardLabel.setForeground(Color.BLACK);
		//Italian Orchard: Reservation label
		
		displayReservationPanel.add(ReservationCreateButton);
		ReservationCreateButton.setBounds(60, 170, 150, 30);
		ReservationCreateButton.addActionListener(this); //Adds an action listener to the component
		//Reservation create button
		
		displayReservationPanel.add(ReservationSearchButton);
		ReservationSearchButton.setBounds(570, 170, 150, 30);
		ReservationSearchButton.addActionListener(this); //Adds an action listener to the component
		ReservationSearchButton.setEnabled(false); //Disables the component
		//Reservation search button
		
		displayReservationPanel.add(ReservationEnableSearchButton);
		ReservationEnableSearchButton.setBounds(60, 120, 660, 30);
		ReservationEnableSearchButton.addActionListener(this); //Adds an action listener to the component
		//Reservation enable search button (enables fields for reservation searching)
		
		displayReservationPanel.add(ReservationSearchLabel);
		ReservationSearchLabel.setBounds(240, 170, 140, 30);
		ReservationSearchLabel.setEnabled(false); //Disables the component
		//Reservation ID: label
		
		displayReservationPanel.add(ReservationSearchField);
		ReservationSearchField.setBounds(400, 170, 140, 30);
		ReservationSearchField.setEnabled(false); //Disables the component
		//Reservation search textfield
		
		displayReservationPanel.add(ReservationIDLabel);
		ReservationIDLabel.setBounds(60, 230, 140, 30);
		ReservationIDLabel.setEnabled(false); //Disables the component
		//Reservation ID: label
		
		displayReservationPanel.add(ReservationIDTextField);
		ReservationIDTextField.setBounds(200, 230, 140, 30);
		ReservationIDTextField.setEnabled(false); //Disables the component
		//Reservation ID textfield
		
		displayReservationPanel.add(ReservationSearchIDLabel);
		ReservationSearchIDLabel.setBounds(410, 230, 140, 30);
		ReservationSearchIDLabel.setEnabled(false); //Disables the component
		//Reservation ID: label (search)
		
		displayReservationPanel.add(ReservationSearchIDTextField);
		ReservationSearchIDTextField.setBounds(570, 230, 140, 30);
		ReservationSearchIDTextField.setEnabled(false); //Disables the component
		//Reservation ID textfield (search)
		
		displayReservationPanel.add(ReservationForeLabel);
		ReservationForeLabel.setBounds(60, 280, 140, 30);
		ReservationForeLabel.setEnabled(false); //Disables the component
		//Forename: label
		
		displayReservationPanel.add(ReservationForeTextField);
		ReservationForeTextField.setBounds(200, 280, 140, 30);
		ReservationForeTextField.setEnabled(false); //Disables the component
		//Reservation forename textfield
		
		displayReservationPanel.add(ReservationSearchForeLabel);
		ReservationSearchForeLabel.setBounds(410, 280, 140, 30);
		ReservationSearchForeLabel.setEnabled(false); //Disables the component
		//Forename: label (search)
		
		displayReservationPanel.add(ReservationSearchForeTextField);
		ReservationSearchForeTextField.setBounds(570, 280, 140, 30);
		ReservationSearchForeTextField.setEnabled(false); //Disables the component
		//Reservation forename textfield (search)
		
		displayReservationPanel.add(ReservationSurLabel);
		ReservationSurLabel.setBounds(60, 330, 140, 30);
		ReservationSurLabel.setEnabled(false); //Disables the component
		//Surname: label
		
		displayReservationPanel.add(ReservationSurTextField);
		ReservationSurTextField.setBounds(200, 330, 140, 30);
		ReservationSurTextField.setEnabled(false); //Disables the component
		//Reservation surname textfield
		
		displayReservationPanel.add(ReservationSearchSurLabel);
		ReservationSearchSurLabel.setBounds(410, 330, 140, 30);
		ReservationSearchSurLabel.setEnabled(false); //Disables the component
		//Surname: label (search)
		
		displayReservationPanel.add(ReservationSearchSurTextField);
		ReservationSearchSurTextField.setBounds(570, 330, 140, 30);
		ReservationSearchSurTextField.setEnabled(false); //Disables the component
		//Reservation surname textfield (search)
		
		displayReservationPanel.add(ReservationTableLabel);
		ReservationTableLabel.setBounds(60, 380, 140, 30);
		ReservationTableLabel.setEnabled(false); //Disables the component
		//Table Number: label
		
		displayReservationPanel.add(ReservationTableTextField);
		ReservationTableTextField.setBounds(200, 380, 140, 30);
		ReservationTableTextField.setEnabled(false); //Disables the component
		//Reservation table number textfield
		
		displayReservationPanel.add(ReservationSearchTableLabel);
		ReservationSearchTableLabel.setBounds(410, 380, 140, 30);
		ReservationSearchTableLabel.setEnabled(false); //Disables the component
		//Table Number: label (search)
		
		displayReservationPanel.add(ReservationSearchTableTextField);
		ReservationSearchTableTextField.setBounds(570, 380, 140, 30);
		ReservationSearchTableTextField.setEnabled(false); //Disables the component
		//Reservation table number textfield (search)
		
		displayReservationPanel.add(ReservationDateLabel);
		ReservationDateLabel.setBounds(60, 430, 140, 30);
		ReservationDateLabel.setEnabled(false); //Disables the component
		//Reservation Date: label
		
		displayReservationPanel.add(ReservationDateTextField);
		ReservationDateTextField.setBounds(200, 430, 140, 30);
		ReservationDateTextField.setEnabled(false); //Disables the component
		//Reservation Date textfield
		
		displayReservationPanel.add(ReservationSearchDateLabel);
		ReservationSearchDateLabel.setBounds(410, 430, 140, 30);
		ReservationSearchDateLabel.setEnabled(false); //Disables the component
		//Reservation Date: label (search)
		
		displayReservationPanel.add(ReservationSearchDateTextField);
		ReservationSearchDateTextField.setBounds(570, 430, 140, 30);
		ReservationSearchDateTextField.setEnabled(false); //Disables the component
		//Reservation Date textfield (search)
		
		displayReservationPanel.add(ReservationDetailsLabel);
		ReservationDetailsLabel.setBounds(60, 480, 140, 30);
		ReservationDetailsLabel.setEnabled(false); //Disables the component
		//Reservation Details: label
		
		displayReservationPanel.add(ReservationDetailsTextField);
		ReservationDetailsTextField.setBounds(200, 480, 140, 30);
		ReservationDetailsTextField.setEnabled(false); //Disables the component
		//Reservation Details textfield
		
		displayReservationPanel.add(ReservationSearchDetailsLabel);
		ReservationSearchDetailsLabel.setBounds(410, 480, 140, 30);
		ReservationSearchDetailsLabel.setEnabled(false); //Disables the component
		//Reservation Details: label (search)
		
		displayReservationPanel.add(ReservationSearchDetailsTextField);
		ReservationSearchDetailsTextField.setBounds(570, 480, 140, 30);
		ReservationSearchDetailsTextField.setEnabled(false); //Disables the component
		//Reservation Details textfield (search)
		
		displayReservationPanel.add(ReservationPhoneLabel);
		ReservationPhoneLabel.setBounds(60, 530, 140, 30);
		ReservationPhoneLabel.setEnabled(false); //Disables the component
		//Phone Number: label
		
		displayReservationPanel.add(ReservationPhoneTextField);
		ReservationPhoneTextField.setBounds(200, 530, 140, 30);
		ReservationPhoneTextField.setEnabled(false); //Disables the component
		//Reservation Phone Number textfield
		
		displayReservationPanel.add(ReservationSearchPhoneLabel);
		ReservationSearchPhoneLabel.setBounds(410, 530, 140, 30);
		ReservationSearchPhoneLabel.setEnabled(false); //Disables the component
		//Phone Number: label (search)
		
		displayReservationPanel.add(ReservationSearchPhoneTextField);
		ReservationSearchPhoneTextField.setBounds(570, 530, 140, 30);
		ReservationSearchPhoneTextField.setEnabled(false); //Disables the component
		//Reservation Phone Number textfield (search)
		
		displayReservationPanel.add(ReservationAddButton);
		ReservationAddButton.setBounds(200, 580, 140, 30);
		ReservationAddButton.addActionListener(this); //Adds an action listener to the component
		ReservationAddButton.setEnabled(false); //Disables the component
		//button to save all information in the reservation fields to the file
		
		displayReservationPanel.add(ReservationEditButton);
		ReservationEditButton.setBounds(570, 580, 140, 30);
		ReservationEditButton.addActionListener(this); //Adds an action listener to the component
		ReservationEditButton.setEnabled(false); //Disables the component
		//button to edit the current record of the reservation in the fields to file
		
		displayReservationPanel.add(ReservationClearFieldsButton);
		ReservationClearFieldsButton.setBounds(60, 650, 350, 30);
		ReservationClearFieldsButton.addActionListener(this); //Adds an action listener to the component
		//button to clear all fields on the reservation page
		
		displayReservationPanel.add(ReservationHomeButton);
		ReservationHomeButton.setBounds(60, 690, 350, 30);
		ReservationHomeButton.addActionListener(this); //Adds an action listener to the component
		//button to direct the user back to the home page
		
		String[][] tempReservationData = allReservations.getBasicDetailsReservationTable(); //getBasicDetailsReservationTable from ReservationList
	
		reservationTable = new JTable(tempReservationData,reservationHeadings);
		reservationScroll = new JScrollPane(reservationTable);
		reservationScroll.setBounds(775, 20, 325, 350);
		//Reservation ScrollPane
	
		displayReservationPanel.add(reservationScroll);
		reservationTable.setEnabled(false); //Disables the component
		reservationTable.getTableHeader().setReorderingAllowed(false);
		//Reservation Table
	
		theReservationBackground.setBounds(0,0,1920,1080);
		displayReservationPanel.add(theReservationBackground);
		//reservation page background
	
	}	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

	public void createHomePanel()
	{
		displayHomePanel.setLayout(null); 
		//null layout for the home page
		
		displayHomePanel.add(TheDate);
		TheDate.setBounds(170, 100, 250, 25);
		TheDate.setBackground(Color.WHITE);
		TheDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		//Date Code
		
		displayHomePanel.add(EnableStaffPasswordButton);
		EnableStaffPasswordButton.setBounds(170, 340, 220, 30);
		EnableStaffPasswordButton.addActionListener(this); //Adds an action listener to the component
		EnableStaffPasswordButton.setVisible(false); //Sets the component to not visible
		//add EnableStaffPasswordButton
		
		displayHomePanel.add(EnableAdminPasswordButton);
		EnableAdminPasswordButton.setBounds(170, 340, 220, 30);
		EnableAdminPasswordButton.addActionListener(this); //Adds an action listener to the component
		EnableAdminPasswordButton.setVisible(false); //Sets the component to not visible
		//add EnableAdminPasswordButton
		
		displayHomePanel.add(ChangeStaffPasswordButton);
		ChangeStaffPasswordButton.setBounds(360, 400, 150, 70);
		ChangeStaffPasswordButton.addActionListener(this); //Adds an action listener to the component
		ChangeStaffPasswordButton.setVisible(false); //Sets the component to not visible
		ChangeStaffPasswordButton.setEnabled(false); //Disables the component
		//add ChangeStaffPasswordButton
		
		displayHomePanel.add(ChangeAdminPasswordButton);
		ChangeAdminPasswordButton.setBounds(360, 400, 150, 70);
		ChangeAdminPasswordButton.addActionListener(this); //Adds an action listener to the component
		ChangeAdminPasswordButton.setVisible(false); //Sets the component to not visible
		ChangeAdminPasswordButton.setEnabled(false); //Disables the component
		//add ChangeAdminPasswordButton
		
		displayHomePanel.add(ExistingPasswordLabel);
		ExistingPasswordLabel.setBounds(80, 400, 150, 30);
		ExistingPasswordLabel.setEnabled(false); //Disables the component
		//add Current Password: label
		
		displayHomePanel.add(ExistingPasswordField);
		ExistingPasswordField.setBounds(200, 400, 150, 30);
		ExistingPasswordField.setEnabled(false); //Disables the component
		//add ExistingPassword field
		
		displayHomePanel.add(NewPasswordLabel);
		NewPasswordLabel.setBounds(80, 440, 150, 30);
		NewPasswordLabel.setEnabled(false); //Disables the component
		//add New Password: label
		
		displayHomePanel.add(NewPasswordField);
		NewPasswordField.setBounds(200, 440, 150, 30);
		NewPasswordField.setEnabled(false); //Disables the component
		//add NewPassword field
		
		displayHomePanel.add(LogoutButton);
		LogoutButton.setBounds(180, 120, 200, 20);
		LogoutButton.addActionListener(this); //Adds an action listener to the component
		//add Logout Button
		
		displayHomePanel.add(GoToReservationButton);
		GoToReservationButton.setBounds(180, 150, 200, 20);
		GoToReservationButton.addActionListener(this); //Adds an action listener to the component
		//add GoToReservationButton Button
		
		displayHomePanel.add(GoToMenuAndOrderButton);
		GoToMenuAndOrderButton.setBounds(180, 180, 200, 20);
		GoToMenuAndOrderButton.addActionListener(this); //Adds an action listener to the component
		//add GoToMenuAndOrder Button
		
		displayHomePanel.add(GoToCreationButton);
		GoToCreationButton.setBounds(180, 180, 200, 20);
		GoToCreationButton.addActionListener(this); //Adds an action listener to the component
		//add GoToCreation Button
		
		displayHomePanel.add(HomeItalianOrchardLabel);
		HomeItalianOrchardLabel.setBounds(25, 10, 650, 100);
		HomeItalianOrchardLabel.setFont(new Font("Blackadder ITC", Font.PLAIN, 72));
		HomeItalianOrchardLabel.setForeground(Color.BLACK);
		//Italian Orchard: Home label
		
		theItalianOrchardPic.setBounds(625, 30, 300, 300);
		displayHomePanel.add(theItalianOrchardPic);
		//home page italian orchard image
		
		theHomeBackground.setBounds(0,0,1920,1080);
		displayHomePanel.add(theHomeBackground);
		//home page background
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	public void createLoginPanel()
	{
		displayLoginPanel.setLayout(null);
		
		///////////STAFF COMPONENTS///////////
		
		displayLoginPanel.add(StaffLoginButton);
		StaffLoginButton.setBounds(110, 380, 140, 30);
		StaffLoginButton.addActionListener(this); //Adds an action listener to the component
		//add staff login button
		
		displayLoginPanel.add(StaffLabel);
		StaffLabel.setBounds(150, 220, 150, 50);
		StaffLabel.setFont(new Font("Gabriola", Font.PLAIN, 32));
		StaffLabel.setForeground(Color.WHITE);
		//Staff: label to be displayed on the login page
		
		displayLoginPanel.add(StaffUserLabel);
		StaffUserLabel.setBounds(30, 280, 140, 30);
		StaffUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		StaffUserLabel.setForeground(Color.WHITE);
		//add Staff Username: label
		
		displayLoginPanel.add(StaffPassLabel);
		StaffPassLabel.setBounds(30, 330, 140, 30);
		StaffPassLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		StaffPassLabel.setForeground(Color.WHITE);
		//add Staff Password: label
		
		displayLoginPanel.add(StaffTextField);
		StaffTextField.setBounds(110, 280, 140, 30);
		//add staff username text field
		
		displayLoginPanel.add(StaffPassField);
		StaffPassField.setBounds(110, 330, 140, 30);
		//add staff password field
		
		///////////ADMIN COMPONENTS///////////
		
		displayLoginPanel.add(AdminLoginButton);
		AdminLoginButton.setBounds(380, 380, 140, 30);
		AdminLoginButton.addActionListener(this); //Adds an action listener to the component
		//add admin login button
		
		displayLoginPanel.add(AdminLabel);
		AdminLabel.setBounds(410, 220, 150, 50);
		AdminLabel.setFont(new Font("Gabriola", Font.PLAIN, 32));
		AdminLabel.setForeground(Color.WHITE);
		//Admin: label to be displayed on the login page
		
		displayLoginPanel.add(AdminUserLabel);
		AdminUserLabel.setBounds(300, 280, 140, 30);
		AdminUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		AdminUserLabel.setForeground(Color.WHITE);
		//add Admin Username: label
		
		displayLoginPanel.add(AdminPassLabel);
		AdminPassLabel.setBounds(300, 330, 140, 30);
		AdminPassLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		AdminPassLabel.setForeground(Color.WHITE);
		//add Admin Password: label
		
		displayLoginPanel.add(AdminTextField);
		AdminTextField.setBounds(380, 280, 140, 30);
		//add admin username text field
		
		displayLoginPanel.add(AdminPassField);
		AdminPassField.setBounds(380, 330, 140, 30);
		//add admin password field
	
		///////////GENERAL COMPONENTS///////////
		
		displayLoginPanel.add(ItalianOrchardLabel);
		ItalianOrchardLabel.setBounds(100, 130, 450, 100);
		ItalianOrchardLabel.setFont(new Font("Blackadder ITC", Font.PLAIN, 72));
		ItalianOrchardLabel.setForeground(Color.WHITE);
		//Italian Orchard label
		
		displayLoginPanel.add(ForgotPassButton);
		ForgotPassButton.setBounds(110, 430, 410, 20);
		ForgotPassButton.addActionListener(this); //Adds an action listener to the component
		//forgot your password? button
		
		theLoginBackground.setBounds(0,0,1920,1080);
		displayLoginPanel.add(theLoginBackground);
		//login page background
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	public void CreateOrderPanel()
	{
		displayMenuAndOrderPanel.setLayout(null);
		
		//components for creating menu items
		
		displayMenuAndOrderPanel.add(OrderCreateItemLabel);
		OrderCreateItemLabel.setBounds(170, 120, 150, 30);
		//Create Item: label
		
		displayMenuAndOrderPanel.add(OrderCreateOrderLabel);
		OrderCreateOrderLabel.setBounds(480, 120, 150, 30);
		//Create Order: label
		
		displayMenuAndOrderPanel.add(CreateItemButton);
		CreateItemButton.setBounds(150, 160, 150, 30);
		CreateItemButton.addActionListener(this); //Adds an action listener to the component
		//button to activate menu item creation fields
		
		displayMenuAndOrderPanel.add(FinishItemButton);
		FinishItemButton.setBounds(150, 410, 150, 30);
		FinishItemButton.addActionListener(this); //Adds an action listener to the component
		FinishItemButton.setEnabled(false); //Disables the component
		//button to save information in menu item creation fields to file
		
		displayMenuAndOrderPanel.add(ItemNumberLabel);
		ItemNumberLabel.setBounds(50, 210, 150, 30);
		ItemNumberLabel.setEnabled(false); //Disables the component
		//Item Number: label
		
		displayMenuAndOrderPanel.add(ItemNameLabel);
		ItemNameLabel.setBounds(50, 260, 150, 30);
		ItemNameLabel.setEnabled(false); //Disables the component
		//Item Name: label
		
		displayMenuAndOrderPanel.add(ItemExtrasLabel);
		ItemExtrasLabel.setBounds(50, 310, 150, 30);
		ItemExtrasLabel.setEnabled(false); //Disables the component
		//Item Extras: label
		
		displayMenuAndOrderPanel.add(PriceLabel);
		PriceLabel.setBounds(50, 360, 150, 30);
		PriceLabel.setEnabled(false); //Disables the component
		//Price: label
		
		displayMenuAndOrderPanel.add(ItemNumberField);
		ItemNumberField.setBounds(150, 210, 150, 30);
		ItemNumberField.setEnabled(false); //Disables the component
		//Item Number text field
		
		displayMenuAndOrderPanel.add(ItemNameField);
		ItemNameField.setBounds(150, 260, 150, 30);
		ItemNameField.setEnabled(false); //Disables the component
		//Item Name text field
		
		displayMenuAndOrderPanel.add(ItemExtrasField);
		ItemExtrasField.setBounds(150, 310, 150, 30);
		ItemExtrasField.setEnabled(false); //Disables the component
		//Item Extras text field
		
		displayMenuAndOrderPanel.add(PriceField);
		PriceField.setBounds(150, 360, 150, 30);
		PriceField.setEnabled(false); //Disables the component
		//Price text field
		
		//components for creating orders
		
		displayMenuAndOrderPanel.add(ProductOneLabel);
		ProductOneLabel.setBounds(400, 210, 150, 30);
		ProductOneLabel.setEnabled(false); //Disables the component
		//#1: label
		
		displayMenuAndOrderPanel.add(ProductOneTextField);
		ProductOneTextField.setBounds(450, 210, 150, 30);
		ProductOneTextField.setEnabled(false); //Disables the component
		//Product One text field
		
		displayMenuAndOrderPanel.add(ProductTwoLabel);
		ProductTwoLabel.setBounds(400, 260, 150, 30);
		ProductTwoLabel.setEnabled(false); //Disables the component
		//#2: label
		
		displayMenuAndOrderPanel.add(ProductTwoTextField);
		ProductTwoTextField.setBounds(450, 260, 150, 30);
		ProductTwoTextField.setEnabled(false); //Disables the component
		//Product Two text field
		
		displayMenuAndOrderPanel.add(ProductThreeLabel);
		ProductThreeLabel.setBounds(400, 310, 150, 30);
		ProductThreeLabel.setEnabled(false); //Disables the component
		//#3: label
		
		displayMenuAndOrderPanel.add(ProductThreeTextField);
		ProductThreeTextField.setBounds(450, 310, 150, 30);
		ProductThreeTextField.setEnabled(false); //Disables the component
		//Product Three text field
		
		displayMenuAndOrderPanel.add(ProductFourLabel);
		ProductFourLabel.setBounds(400, 360, 150, 30);
		ProductFourLabel.setEnabled(false); //Disables the component
		//#4: label
		
		displayMenuAndOrderPanel.add(ProductFourTextField);
		ProductFourTextField.setBounds(450, 360, 150, 30);
		ProductFourTextField.setEnabled(false); //Disables the component
		//Product Four text field
		
		displayMenuAndOrderPanel.add(ProductFiveLabel);
		ProductFiveLabel.setBounds(650, 210, 150, 30);
		ProductFiveLabel.setEnabled(false); //Disables the component
		//#5: label
		
		displayMenuAndOrderPanel.add(ProductFiveTextField);
		ProductFiveTextField.setBounds(700, 210, 150, 30);
		ProductFiveTextField.setEnabled(false); //Disables the component
		//Product Five text field
		
		displayMenuAndOrderPanel.add(ProductSixLabel);
		ProductSixLabel.setBounds(650, 260, 150, 30);
		ProductSixLabel.setEnabled(false); //Disables the component
		//#6: label
		
		displayMenuAndOrderPanel.add(ProductSixTextField);
		ProductSixTextField.setBounds(700, 260, 150, 30);
		ProductSixTextField.setEnabled(false); //Disables the component
		//Product Six text field
		
		displayMenuAndOrderPanel.add(ProductSevenLabel);
		ProductSevenLabel.setBounds(650, 310, 150, 30);
		ProductSevenLabel.setEnabled(false); //Disables the component
		//#7: label
		
		displayMenuAndOrderPanel.add(ProductSevenTextField);
		ProductSevenTextField.setBounds(700, 310, 150, 30);
		ProductSevenTextField.setEnabled(false); //Disables the component
		//Product Seven text field
		
		displayMenuAndOrderPanel.add(ProductEightLabel);
		ProductEightLabel.setBounds(650, 360, 150, 30);
		ProductEightLabel.setEnabled(false); //Disables the component
		//#8: label
		
		displayMenuAndOrderPanel.add(ProductEightTextField);
		ProductEightTextField.setBounds(700, 360, 150, 30);
		ProductEightTextField.setEnabled(false); //Disables the component
		//Product Eight text field
		
		displayMenuAndOrderPanel.add(CreateOrderButton);
		CreateOrderButton.setBounds(450, 160, 150, 30);
		CreateOrderButton.addActionListener(this); //Adds an action listener to the component
		//Create Order button
		
		displayMenuAndOrderPanel.add(FinishOrderButton);
		FinishOrderButton.setBounds(700, 160, 150, 30);
		FinishOrderButton.addActionListener(this); //Adds an action listener to the component
		FinishOrderButton.setEnabled(false); //Disables the component
		//Finish Order button
		
		displayMenuAndOrderPanel.add(ClearMenuAndOrderButton);
		ClearMenuAndOrderButton.setBounds(600, 500, 150, 30);
		ClearMenuAndOrderButton.addActionListener(this); //Adds an action listener to the component
		//Clear Menu and Order fields button
		
		displayMenuAndOrderPanel.add(HomeButtonReservation);
		HomeButtonReservation.setBounds(600, 550, 150, 30);
		HomeButtonReservation.addActionListener(this); //Adds an action listener to the component
		//add HomeButtonReservation Button
		
		//order page jpanels and jlabels
		
		displayMenuAndOrderPanel.add(CreateItemPanel);
		CreateItemPanel.setBounds(30, 110, 300, 350);
		
		displayMenuAndOrderPanel.add(CreateOrderPanel);
		CreateOrderPanel.setBounds(370, 110, 525, 325);
		
		String[][] tempMenuData = allMenus.getBasicDetailsMenu(); //getBasicDetailsMenu from MenuList
	
		menuTable = new JTable(tempMenuData,menuHeadings);
		menuScroll = new JScrollPane(menuTable);
		menuScroll.setBounds(30, 500, 500, 150);
	
		displayMenuAndOrderPanel.add(menuScroll);
		menuScroll.setEnabled(false); //Disables the component
		menuTable.getTableHeader().setReorderingAllowed(false);
		
		//Menu Table for the Menu and Order Page
		//Displays a full list of all the menu items in the restaurant
		
		displayMenuAndOrderPanel.add(OrderItalianOrchardLabel);
		OrderItalianOrchardLabel.setBounds(25, 10, 1000, 100);
		OrderItalianOrchardLabel.setFont(new Font("Blackadder ITC", Font.PLAIN, 72));
		OrderItalianOrchardLabel.setForeground(Color.BLACK);
		//Italian Orchard: Menu and Order label
		
		theMenuAndOrderBackground.setBounds(0,0,1920,1080);
		displayMenuAndOrderPanel.add(theMenuAndOrderBackground);
		//rewards page background
	}
		
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
		
	public void createCreationPanel()
	{
		displayCreationPanel.setLayout(null);
		
		displayCreationPanel.add(StaffIDButton);
		StaffIDButton.setBounds(725, 25, 300, 20);
		StaffIDButton.addActionListener(this); //Adds an action listener to the component
		
		displayCreationPanel.add(AdminIDButton);
		AdminIDButton.setBounds(725, 50, 300, 20);
		AdminIDButton.addActionListener(this); //Adds an action listener to the component
		
		String[][] tempStaffData = allStaff.getBasicDetailsStaff(); //getBasicDetailsStaff from StaffList
	
		staffTable = new JTable(tempStaffData,staffHeadings);
		staffScroll = new JScrollPane(staffTable);
		staffScroll.setBounds(725, 80, 300, 200);
		staffScroll.setVisible(false); //Sets the component to not visible
	
		displayCreationPanel.add(staffScroll);
		staffTable.setEnabled(false); //Disables the component
		staffTable.getTableHeader().setReorderingAllowed(false);
		
		//Staff Table for the Creation page
		//Displays a full list of all the staff members for the restaurant
		
		String[][] tempAdminData = allAdmins.getBasicDetailsAdmin(); //getBasicDetailsAdmin from AdminList
	
		adminTable = new JTable(tempAdminData,adminHeadings);
		adminScroll = new JScrollPane(adminTable);
		adminScroll.setBounds(725, 80, 300, 200);
		adminScroll.setVisible(false); //Sets the component to not visible
		
		displayCreationPanel.add(adminScroll);
		adminTable.setEnabled(false); //Disables the component
		adminTable.getTableHeader().setReorderingAllowed(false);
		
		//Admin Table for the Creation page
		//Displays a full list of all the admin members for the restaurant
		
		blankTable = new JTable();
		blankTable.setBounds(725, 80, 300, 200);
		
		displayCreationPanel.add(blankTable);
		
		displayCreationPanel.add(HomeButtonCreation);
		HomeButtonCreation.setBounds(60, 100, 580, 30);
		HomeButtonCreation.addActionListener(this); //Adds an action listener to the component
		
		displayCreationPanel.add(CreationStaffForeLabel);
		CreationStaffForeLabel.setBounds(60, 330, 140, 30);
		CreationStaffForeLabel.setEnabled(false); //Disables the component
		//add Staff Forename: label
		
		displayCreationPanel.add(CreationAdminForeLabel);
		CreationAdminForeLabel.setBounds(360, 330, 140, 30);
		CreationAdminForeLabel.setEnabled(false); //Disables the component
		//add Admin Forename: label
		
		displayCreationPanel.add(StaffForeTextField);
		StaffForeTextField.setBounds(200, 330, 140, 30);
		StaffForeTextField.setEnabled(false); //Disables the component
		//staff forename textfield
		
		displayCreationPanel.add(AdminForeTextField);
		AdminForeTextField.setBounds(500, 330, 140, 30);
		AdminForeTextField.setEnabled(false); //Disables the component
		//admin forename textfield
		
		displayCreationPanel.add(CreationStaffSurLabel);
		CreationStaffSurLabel.setBounds(60, 380, 140, 30);
		CreationStaffSurLabel.setEnabled(false); //Disables the component
		//add Staff Surname: label
		
		displayCreationPanel.add(CreationAdminSurLabel);
		CreationAdminSurLabel.setBounds(360, 380, 140, 30);
		CreationAdminSurLabel.setEnabled(false); //Disables the component
		//add Admin Surname: label
		
		displayCreationPanel.add(StaffSurTextField);
		StaffSurTextField.setBounds(200, 380, 140, 30);
		StaffSurTextField.setEnabled(false); //Disables the component
		//staff surname textfield
		
		displayCreationPanel.add(AdminSurTextField);
		AdminSurTextField.setBounds(500, 380, 140, 30);
		AdminSurTextField.setEnabled(false); //Disables the component
		//admin surname textfield
		
		displayCreationPanel.add(CreationStaffMiddleLabel);
		CreationStaffMiddleLabel.setBounds(60, 430, 140, 30);
		CreationStaffMiddleLabel.setEnabled(false); //Disables the component
		//add Staff Middle name (optional): label
		
		displayCreationPanel.add(CreationAdminMiddleLabel);
		CreationAdminMiddleLabel.setBounds(360, 430, 140, 30);
		CreationAdminMiddleLabel.setEnabled(false); //Disables the component
		//add Admin Middle name (optional): label
		
		displayCreationPanel.add(StaffMiddleTextField);
		StaffMiddleTextField.setBounds(200, 430, 140, 30);
		StaffMiddleTextField.setEnabled(false); //Disables the component
		//staff middle name (optional) textfield
		
		displayCreationPanel.add(AdminMiddleTextField);
		AdminMiddleTextField.setBounds(500, 430, 140, 30);
		AdminMiddleTextField.setEnabled(false); //Disables the component
		//admin middle name (optional) textfield
		
		displayCreationPanel.add(CreationStaffIDLabel);
		CreationStaffIDLabel.setBounds(60, 480, 140, 30);
		CreationStaffIDLabel.setEnabled(false); //Disables the component
		//add Staff ID: label
		
		displayCreationPanel.add(CreationAdminIDLabel);
		CreationAdminIDLabel.setBounds(360, 480, 140, 30);
		CreationAdminIDLabel.setEnabled(false); //Disables the component
		//add Admin ID: label
		
		displayCreationPanel.add(StaffIDTextField);
		StaffIDTextField.setBounds(200, 480, 140, 30);
		StaffIDTextField.setEnabled(false); //Disables the component
		//staff id textfield
		
		displayCreationPanel.add(AdminIDTextField);
		AdminIDTextField.setBounds(500, 480, 140, 30);
		AdminIDTextField.setEnabled(false); //Disables the component
		//admin id textfield
		
		displayCreationPanel.add(CreationStaffBirthLabel);
		CreationStaffBirthLabel.setBounds(60, 530, 140, 30);
		CreationStaffBirthLabel.setEnabled(false); //Disables the component
		//add Staff Date of Birth: label
		
		displayCreationPanel.add(CreationAdminBirthLabel);
		CreationAdminBirthLabel.setBounds(360, 530, 140, 30);
		CreationAdminBirthLabel.setEnabled(false); //Disables the component
		//add Admin Date of Birth: label
		
		displayCreationPanel.add(StaffBirthTextField);
		StaffBirthTextField.setBounds(200, 530, 140, 30);
		StaffBirthTextField.setEnabled(false); //Disables the component
		//staff birth date textfield
		
		displayCreationPanel.add(AdminBirthTextField);
		AdminBirthTextField.setBounds(500, 530, 140, 30);
		AdminBirthTextField.setEnabled(false); //Disables the component
		//admin birth date textfield
		
		displayCreationPanel.add(CreationStaffPasswordLabel);
		CreationStaffPasswordLabel.setBounds(60, 580, 140, 30);
		CreationStaffPasswordLabel.setEnabled(false); //Disables the component
		//add Staff Password: label
		
		displayCreationPanel.add(CreationAdminPasswordLabel);
		CreationAdminPasswordLabel.setBounds(360, 580, 140, 30);
		CreationAdminPasswordLabel.setEnabled(false); //Disables the component
		//add Admin Password: label
		
		displayCreationPanel.add(StaffPasswordTextField);
		StaffPasswordTextField.setBounds(200, 580, 140, 30);
		StaffPasswordTextField.setEnabled(false); //Disables the component
		//add staff password textfield
		
		displayCreationPanel.add(AdminPasswordTextField);
		AdminPasswordTextField.setBounds(500, 580, 140, 30);
		AdminPasswordTextField.setEnabled(false); //Disables the component
		//add admin password textfield
		
		displayCreationPanel.add(CreationCreateStaffButton);
		CreationCreateStaffButton.setBounds(200, 200, 140, 30);
		CreationCreateStaffButton.addActionListener(this); //Adds an action listener to the component
		//create staff button
		
		displayCreationPanel.add(CreationCreateAdminButton);
		CreationCreateAdminButton.setBounds(500, 200, 140, 30);
		CreationCreateAdminButton.addActionListener(this); //Adds an action listener to the component
		//create admin button
		
		displayCreationPanel.add(CreationAddStaffButton);
		CreationAddStaffButton.setBounds(200, 650, 140, 30);
		CreationAddStaffButton.addActionListener(this); //Adds an action listener to the component
		CreationAddStaffButton.setEnabled(false); //Disables the component
		//add staff button
		
		displayCreationPanel.add(CreationAddAdminButton);
		CreationAddAdminButton.setBounds(500, 650, 140, 30);
		CreationAddAdminButton.addActionListener(this); //Adds an action listener to the component
		CreationAddAdminButton.setEnabled(false); //Disables the component
		//add admin button
		
		displayCreationPanel.add(CreationEditStaffButton);
		CreationEditStaffButton.setBounds(200, 700, 140, 30);
		CreationEditStaffButton.addActionListener(this); //Adds an action listener to the component
		CreationEditStaffButton.setEnabled(false); //Disables the component
		//edit staff button
		
		displayCreationPanel.add(CreationEditAdminButton);
		CreationEditAdminButton.setBounds(500, 700, 140, 30);
		CreationEditAdminButton.addActionListener(this); //Adds an action listener to the component
		CreationEditAdminButton.setEnabled(false); //Disables the component
		//edit admin button
		
		displayCreationPanel.add(CreationClearFieldsButton);
		CreationClearFieldsButton.setBounds(60, 750, 580, 30);
		CreationClearFieldsButton.addActionListener(this); //Adds an action listener to the component
		//clear fields button
		
		displayCreationPanel.add(CreationSearchAndEditButton);
		CreationSearchAndEditButton.setBounds(60, 140, 580, 30);
		CreationSearchAndEditButton.addActionListener(this); //Adds an action listener to the component
		//add search and edit button
		
		displayCreationPanel.add(CreationStaffSearchLabel);
		CreationStaffSearchLabel.setBounds(60, 240, 140, 30);
		CreationStaffSearchLabel.setEnabled(false); //Disables the component
		//add Search: label
		
		displayCreationPanel.add(CreationStaffSearchField);
		CreationStaffSearchField.setBounds(200, 240, 140, 30);
		CreationStaffSearchField.setEnabled(false); //Disables the component
		//add search ID textfield
		
		displayCreationPanel.add(CreationStaffSearchButton);
		CreationStaffSearchButton.setBounds(200, 280, 140, 30);
		CreationStaffSearchButton.addActionListener(this); //Adds an action listener to the component
		CreationStaffSearchButton.setEnabled(false); //Disables the component
		//add search ID button
		
		displayCreationPanel.add(CreationAdminSearchLabel);
		CreationAdminSearchLabel.setBounds(360, 240, 140, 30);
		CreationAdminSearchLabel.setEnabled(false); //Disables the component
		//add Search: label
		
		displayCreationPanel.add(CreationAdminSearchField);
		CreationAdminSearchField.setBounds(500, 240, 140, 30);
		CreationAdminSearchField.setEnabled(false); //Disables the component
		//add search ID textfield
		
		displayCreationPanel.add(CreationAdminSearchButton);
		CreationAdminSearchButton.setBounds(500, 280, 140, 30);
		CreationAdminSearchButton.addActionListener(this); //Adds an action listener to the component
		CreationAdminSearchButton.setEnabled(false); //Disables the component
		//add search ID button
		
		displayCreationPanel.add(CreationItalianOrchardLabel);
		CreationItalianOrchardLabel.setBounds(25, 10, 650, 100);
		CreationItalianOrchardLabel.setFont(new Font("Blackadder ITC", Font.PLAIN, 72));
		CreationItalianOrchardLabel.setForeground(Color.BLACK);
		
		theCreationBackground.setBounds(0,0,1920,1080);
		displayCreationPanel.add(theCreationBackground);
		//creation page background
	}

//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == ForgotPassButton)
		{
			JOptionPane.showMessageDialog(frame, "Cannot successfully edit the Reservation!\r\nIs a field empty?"); //Message Dialog to tell the user what to do if they have forgotten their password
		}
		
		if(e.getSource() == ExitButton) //Exits the program
		{
			System.exit(0);
		}
		
		if(e.getSource() == GoToMenuAndOrderButton) //Takes the user to the menu and order page when clicked
		{
			myTabs.setSelectedIndex(2);
		}
		
		if(e.getSource() == GoToReservationButton) //Takes the user to the reservation page when clicked
		{
			myTabs.setSelectedIndex(3);
		}
		
		if(e.getSource() == GoToCreationButton) //Takes the user to the creation page when clicked
		{
			myTabs.setSelectedIndex(4);
		}
		
		if(e.getSource() == HomeButtonMenuAndOrder) //Takes the user to the home page when clicked
		{
			myTabs.setSelectedIndex(1);
		}
		
		if(e.getSource() == HomeButtonCreation) //Takes the user to the home page when clicked
		{
			myTabs.setSelectedIndex(1);
			blankTable.setVisible(true); //Sets the component to be visible
			staffScroll.setVisible(false); //Sets the component to not visible
			adminScroll.setVisible(false); //Sets the component to not visible
			StaffIDTextField.setEnabled(false); //Disables the component
			AdminIDTextField.setEnabled(false); //Disables the component
			CreationStaffIDLabel.setEnabled(false); //Disables the component
			CreationAdminIDLabel.setEnabled(false); //Disables the component
			StaffForeTextField.setText(null); //Clears the text in the field
			AdminForeTextField.setText(null); //Clears the text in the field
			StaffSurTextField.setText(null); //Clears the text in the field
			AdminSurTextField.setText(null); //Clears the text in the field
			StaffMiddleTextField.setText(null); //Clears the text in the field
			AdminMiddleTextField.setText(null); //Clears the text in the field
			StaffIDTextField.setText(null); //Clears the text in the field
			AdminIDTextField.setText(null); //Clears the text in the field
			StaffBirthTextField.setText(null); //Clears the text in the field
			AdminBirthTextField.setText(null); //Clears the text in the field
			StaffPasswordTextField.setText(null); //Clears the text in the field
			AdminPasswordTextField.setText(null); //Clears the text in the field
			CreationStaffSearchField.setText(null); //Clears the text in the field
			CreationAdminSearchField.setText(null); //Clears the text in the field
			StaffForeTextField.setEnabled(false); //Disables the component
			CreationStaffForeLabel.setEnabled(false); //Disables the component
			StaffSurTextField.setEnabled(false); //Disables the component
			CreationStaffSurLabel.setEnabled(false); //Disables the component
			StaffMiddleTextField.setEnabled(false); //Disables the component
			CreationStaffMiddleLabel.setEnabled(false); //Disables the component
			StaffBirthTextField.setEnabled(false); //Disables the component
			CreationStaffBirthLabel.setEnabled(false); //Disables the component
			StaffPasswordTextField.setEnabled(false); //Disables the component
			CreationStaffPasswordLabel.setEnabled(false); //Disables the component
			CreationAddStaffButton.setEnabled(false); //Disables the component
			CreationEditStaffButton.setEnabled(false); //Disables the component
			AdminForeTextField.setEnabled(false); //Disables the component
			CreationAdminForeLabel.setEnabled(false); //Disables the component
			AdminSurTextField.setEnabled(false); //Disables the component
			CreationAdminSurLabel.setEnabled(false); //Disables the component
			AdminMiddleTextField.setEnabled(false); //Disables the component
			CreationAdminMiddleLabel.setEnabled(false); //Disables the component
			AdminBirthTextField.setEnabled(false); //Disables the component
			CreationAdminBirthLabel.setEnabled(false); //Disables the component
			AdminPasswordTextField.setEnabled(false); //Disables the component
			CreationAdminPasswordLabel.setEnabled(false); //Disables the component
			CreationAddAdminButton.setEnabled(false); //Disables the component
			CreationEditAdminButton.setEnabled(false); //Disables the component
			CreationStaffSearchLabel.setEnabled(false); //Disables the component
			CreationStaffSearchField.setEnabled(false); //Disables the component
			CreationStaffSearchButton.setEnabled(false); //Disables the component
			CreationAdminSearchLabel.setEnabled(false); //Disables the component
			CreationAdminSearchField.setEnabled(false); //Disables the component
			CreationAdminSearchButton.setEnabled(false); //Disables the component
		}
		
		if(e.getSource() == HomeButtonReservation) //Takes the user to the home page when clicked
		{
			myTabs.setSelectedIndex(1);
			
			ItemNumberLabel.setEnabled(false); //Disables the component
			ItemNumberField.setEnabled(false); //Disables the component
			ItemNameLabel.setEnabled(false); //Disables the component
			ItemNameField.setEnabled(false); //Disables the component
			ItemExtrasLabel.setEnabled(false); //Disables the component
			ItemExtrasField.setEnabled(false); //Disables the component
			PriceLabel.setEnabled(false); //Disables the component
			PriceField.setEnabled(false); //Disables the component
			FinishItemButton.setEnabled(false); //Disables the component
			
			ItemNumberField.setText(null); //Clears the text in the field
			ItemNameField.setText(null); //Clears the text in the field
			ItemExtrasField.setText(null); //Clears the text in the field
			PriceField.setText(null); //Clears the text in the field
			
			ProductOneLabel.setEnabled(false); //Disables the component
			ProductOneTextField.setEnabled(false); //Disables the component
			ProductTwoLabel.setEnabled(false); //Disables the component
			ProductTwoTextField.setEnabled(false); //Disables the component
			ProductThreeLabel.setEnabled(false); //Disables the component
			ProductThreeTextField.setEnabled(false); //Disables the component
			ProductFourLabel.setEnabled(false); //Disables the component
			ProductFourTextField.setEnabled(false); //Disables the component
			ProductFiveLabel.setEnabled(false); //Disables the component
			ProductFiveTextField.setEnabled(false); //Disables the component
			ProductSixLabel.setEnabled(false); //Disables the component
			ProductSixTextField.setEnabled(false); //Disables the component
			ProductSevenLabel.setEnabled(false); //Disables the component
			ProductSevenTextField.setEnabled(false); //Disables the component
			ProductEightLabel.setEnabled(false); //Disables the component
			ProductEightTextField.setEnabled(false); //Disables the component
			FinishOrderButton.setEnabled(false); //Disables the component
			
			ProductOneTextField.setText(null); //Clears the text in the field
			ProductTwoTextField.setText(null); //Clears the text in the field
			ProductThreeTextField.setText(null); //Clears the text in the field
			ProductFourTextField.setText(null); //Clears the text in the field
			ProductFiveTextField.setText(null); //Clears the text in the field
			ProductSixTextField.setText(null); //Clears the text in the field
			ProductSevenTextField.setText(null); //Clears the text in the field
			ProductEightTextField.setText(null); //Clears the text in the field
		}
		
		if(e.getSource() == ClearMenuAndOrderButton) //Clears all the fields on the menu and order page
		{
			ItemNumberLabel.setEnabled(false); //Disables the component
			ItemNumberField.setEnabled(false); //Disables the component
			ItemNameLabel.setEnabled(false); //Disables the component
			ItemNameField.setEnabled(false); //Disables the component
			ItemExtrasLabel.setEnabled(false); //Disables the component
			ItemExtrasField.setEnabled(false); //Disables the component
			PriceLabel.setEnabled(false); //Disables the component
			PriceField.setEnabled(false); //Disables the component
			FinishItemButton.setEnabled(false); //Disables the component
			
			ItemNumberField.setText(null); //Clears the text in the field
			ItemNameField.setText(null); //Clears the text in the field
			ItemExtrasField.setText(null); //Clears the text in the field
			PriceField.setText(null); //Clears the text in the field
			
			ProductOneLabel.setEnabled(false); //Disables the component
			ProductOneTextField.setEnabled(false); //Disables the component
			ProductTwoLabel.setEnabled(false); //Disables the component
			ProductTwoTextField.setEnabled(false); //Disables the component
			ProductThreeLabel.setEnabled(false); //Disables the component
			ProductThreeTextField.setEnabled(false); //Disables the component
			ProductFourLabel.setEnabled(false); //Disables the component
			ProductFourTextField.setEnabled(false); //Disables the component
			ProductFiveLabel.setEnabled(false); //Disables the component
			ProductFiveTextField.setEnabled(false); //Disables the component
			ProductSixLabel.setEnabled(false); //Disables the component
			ProductSixTextField.setEnabled(false); //Disables the component
			ProductSevenLabel.setEnabled(false); //Disables the component
			ProductSevenTextField.setEnabled(false); //Disables the component
			ProductEightLabel.setEnabled(false); //Disables the component
			ProductEightTextField.setEnabled(false); //Disables the component
			FinishOrderButton.setEnabled(false); //Disables the component
			
			ProductOneTextField.setText(null); //Clears the text in the field
			ProductTwoTextField.setText(null); //Clears the text in the field
			ProductThreeTextField.setText(null); //Clears the text in the field
			ProductFourTextField.setText(null); //Clears the text in the field
			ProductFiveTextField.setText(null); //Clears the text in the field
			ProductSixTextField.setText(null); //Clears the text in the field
			ProductSevenTextField.setText(null); //Clears the text in the field
			ProductEightTextField.setText(null); //Clears the text in the field
			
		}
		
		if(e.getSource() == CreateItemButton) //Enables all the fields for creation of a menu item
		{
			ItemNumberLabel.setEnabled(true); //Enables the component
			ItemNumberField.setEnabled(true); //Enables the component
			ItemNameLabel.setEnabled(true); //Enables the component
			ItemNameField.setEnabled(true); //Enables the component
			ItemExtrasLabel.setEnabled(true); //Enables the component
			ItemExtrasField.setEnabled(true); //Enables the component
			PriceLabel.setEnabled(true); //Enables the component
			PriceField.setEnabled(true); //Enables the component
			FinishItemButton.setEnabled(true); //Enables the component
			
			ProductOneLabel.setEnabled(false); //Disables the component
			ProductOneTextField.setEnabled(false); //Disables the component
			ProductTwoLabel.setEnabled(false); //Disables the component
			ProductTwoTextField.setEnabled(false); //Disables the component
			ProductThreeLabel.setEnabled(false); //Disables the component
			ProductThreeTextField.setEnabled(false); //Disables the component
			ProductFourLabel.setEnabled(false); //Disables the component
			ProductFourTextField.setEnabled(false); //Disables the component
			ProductFiveLabel.setEnabled(false); //Disables the component
			ProductFiveTextField.setEnabled(false); //Disables the component
			ProductSixLabel.setEnabled(false); //Disables the component
			ProductSixTextField.setEnabled(false); //Disables the component
			ProductSevenLabel.setEnabled(false); //Disables the component
			ProductSevenTextField.setEnabled(false); //Disables the component
			ProductEightLabel.setEnabled(false); //Disables the component
			ProductEightTextField.setEnabled(false); //Disables the component
			FinishOrderButton.setEnabled(false); //Disables the component
			
			ProductOneTextField.setText(null); //Clears the text in the field
			ProductTwoTextField.setText(null); //Clears the text in the field
			ProductThreeTextField.setText(null); //Clears the text in the field
			ProductFourTextField.setText(null); //Clears the text in the field
			ProductFiveTextField.setText(null); //Clears the text in the field
			ProductSixTextField.setText(null); //Clears the text in the field
			ProductSevenTextField.setText(null); //Clears the text in the field
			ProductEightTextField.setText(null); //Clears the text in the field
				
		}
		
		if(e.getSource() == CreateOrderButton) //Enables all the fields for creation of an order
		{
			ItemNumberLabel.setEnabled(false); //Disables the component
			ItemNumberField.setEnabled(false); //Disables the component
			ItemNameLabel.setEnabled(false); //Disables the component
			ItemNameField.setEnabled(false); //Disables the component
			ItemExtrasLabel.setEnabled(false); //Disables the component
			ItemExtrasField.setEnabled(false); //Disables the component
			PriceLabel.setEnabled(false); //Disables the component
			PriceField.setEnabled(false); //Disables the component
			FinishItemButton.setEnabled(false); //Disables the component
			
			ItemNumberField.setText(null); //Clears the text in the field
			ItemNameField.setText(null); //Clears the text in the field
			ItemExtrasField.setText(null); //Clears the text in the field
			PriceField.setText(null); //Clears the text in the field
			
			ProductOneLabel.setEnabled(true); //Enables the component
			ProductOneTextField.setEnabled(true); //Enables the component
			ProductTwoLabel.setEnabled(true); //Enables the component
			ProductTwoTextField.setEnabled(true); //Enables the component
			ProductThreeLabel.setEnabled(true); //Enables the component
			ProductThreeTextField.setEnabled(true); //Enables the component
			ProductFourLabel.setEnabled(true); //Enables the component
			ProductFourTextField.setEnabled(true); //Enables the component
			ProductFiveLabel.setEnabled(true); //Enables the component
			ProductFiveTextField.setEnabled(true); //Enables the component
			ProductSixLabel.setEnabled(true); //Enables the component
			ProductSixTextField.setEnabled(true); //Enables the component
			ProductSevenLabel.setEnabled(true); //Enables the component
			ProductSevenTextField.setEnabled(true); //Enables the component
			ProductEightLabel.setEnabled(true); //Enables the component
			ProductEightTextField.setEnabled(true); //Enables the component
			FinishOrderButton.setEnabled(true); //Enables the component
		}
		
		if(e.getSource() == ReservationCreateButton) //Enables all the fields for creation of a reservation
		{
			ReservationIDLabel.setEnabled(true); //Enables the component
			ReservationIDTextField.setEnabled(true); //Enables the component
			ReservationForeLabel.setEnabled(true); //Enables the component
			ReservationForeTextField.setEnabled(true); //Enables the component
			ReservationSurLabel.setEnabled(true); //Enables the component
			ReservationSurTextField.setEnabled(true); //Enables the component
			ReservationTableLabel.setEnabled(true); //Enables the component
			ReservationTableTextField.setEnabled(true); //Enables the component
			ReservationDateLabel.setEnabled(true); //Enables the component
			ReservationDateTextField.setEnabled(true); //Enables the component
			ReservationDetailsLabel.setEnabled(true); //Enables the component
			ReservationDetailsTextField.setEnabled(true); //Enables the component
			ReservationPhoneLabel.setEnabled(true); //Enables the component
			ReservationPhoneTextField.setEnabled(true); //Enables the component
			ReservationAddButton.setEnabled(true); //Enables the component
			
			ReservationSearchIDLabel.setEnabled(false); //Disables the component
			ReservationSearchIDTextField.setEnabled(false); //Disables the component
			ReservationSearchForeLabel.setEnabled(false); //Disables the component
			ReservationSearchForeTextField.setEnabled(false); //Disables the component
			ReservationSearchSurLabel.setEnabled(false); //Disables the component
			ReservationSearchSurTextField.setEnabled(false); //Disables the component
			ReservationSearchTableLabel.setEnabled(false); //Disables the component
			ReservationSearchTableTextField.setEnabled(false); //Disables the component
			ReservationSearchDateLabel.setEnabled(false); //Disables the component
			ReservationSearchDateTextField.setEnabled(false); //Disables the component
			ReservationSearchDetailsLabel.setEnabled(false); //Disables the component
			ReservationSearchDetailsTextField.setEnabled(false); //Disables the component
			ReservationSearchPhoneLabel.setEnabled(false); //Disables the component
			ReservationSearchPhoneTextField.setEnabled(false); //Disables the component
			ReservationEditButton.setEnabled(false); //Disables the component
			
			ReservationSearchIDTextField.setText(null); //Clears the text in the field
			ReservationSearchForeTextField.setText(null); //Clears the text in the field
			ReservationSearchSurTextField.setText(null); //Clears the text in the field
			ReservationSearchTableTextField.setText(null); //Clears the text in the field
			ReservationSearchDateTextField.setText(null); //Clears the text in the field
			ReservationSearchDetailsTextField.setText(null); //Clears the text in the field
			ReservationSearchPhoneTextField.setText(null); //Clears the text in the field
			
			ReservationSearchLabel.setEnabled(false); //Disables the component
			ReservationSearchField.setEnabled(false); //Disables the component
			ReservationSearchButton.setEnabled(false); //Disables the component
			ReservationSearchField.setText(null); //Clears the text in the field
		}
		
		if(e.getSource() == ReservationEnableSearchButton) //Enables the fields for searching for a reservation
		{
			ReservationSearchLabel.setEnabled(true); //Enables the component
			ReservationSearchField.setEnabled(true); //Enables the component
			ReservationSearchField.setText(null); //Clears the text in the field
			ReservationSearchButton.setEnabled(true); //Enables the component
			
			ReservationIDLabel.setEnabled(false); //Disables the component
			ReservationIDTextField.setEnabled(false); //Disables the component
			ReservationForeLabel.setEnabled(false); //Disables the component
			ReservationForeTextField.setEnabled(false); //Disables the component
			ReservationSurLabel.setEnabled(false); //Disables the component
			ReservationSurTextField.setEnabled(false); //Disables the component
			ReservationTableLabel.setEnabled(false); //Disables the component
			ReservationTableTextField.setEnabled(false); //Disables the component
			ReservationDateLabel.setEnabled(false); //Disables the component
			ReservationDateTextField.setEnabled(false); //Disables the component
			ReservationDetailsLabel.setEnabled(false); //Disables the component
			ReservationDetailsTextField.setEnabled(false); //Disables the component
			ReservationPhoneLabel.setEnabled(false); //Disables the component
			ReservationPhoneTextField.setEnabled(false); //Disables the component
			ReservationAddButton.setEnabled(false); //Disables the component
			
			ReservationIDTextField.setText(null); //Clears the text in the field
			ReservationForeTextField.setText(null); //Clears the text in the field
			ReservationSurTextField.setText(null); //Clears the text in the field
			ReservationTableTextField.setText(null); //Clears the text in the field
			ReservationDateTextField.setText(null); //Clears the text in the field
			ReservationDetailsTextField.setText(null); //Clears the text in the field
			ReservationPhoneTextField.setText(null); //Clears the text in the field
			
			ReservationSearchIDLabel.setEnabled(false); //Disables the component
			ReservationSearchIDTextField.setEnabled(false); //Disables the component
			ReservationSearchForeLabel.setEnabled(false); //Disables the component
			ReservationSearchForeTextField.setEnabled(false); //Disables the component
			ReservationSearchSurLabel.setEnabled(false); //Disables the component
			ReservationSearchSurTextField.setEnabled(false); //Disables the component
			ReservationSearchTableLabel.setEnabled(false); //Disables the component
			ReservationSearchTableTextField.setEnabled(false); //Disables the component
			ReservationSearchDateLabel.setEnabled(false); //Disables the component
			ReservationSearchDateTextField.setEnabled(false); //Disables the component
			ReservationSearchDetailsLabel.setEnabled(false); //Disables the component
			ReservationSearchDetailsTextField.setEnabled(false); //Disables the component
			ReservationSearchPhoneLabel.setEnabled(false); //Disables the component
			ReservationSearchPhoneTextField.setEnabled(false); //Disables the component
			ReservationEditButton.setEnabled(false); //Disables the component
			
			ReservationSearchIDTextField.setText(null); //Clears the text in the field
			ReservationSearchForeTextField.setText(null); //Clears the text in the field
			ReservationSearchSurTextField.setText(null); //Clears the text in the field
			ReservationSearchTableTextField.setText(null); //Clears the text in the field
			ReservationSearchDateTextField.setText(null); //Clears the text in the field
			ReservationSearchDetailsTextField.setText(null); //Clears the text in the field
			ReservationSearchPhoneTextField.setText(null); //Clears the text in the field
		}
		
		if(e.getSource() == ReservationClearFieldsButton) //Clears all the fields on the reservation page
		{
			ReservationIDLabel.setEnabled(false); //Disables the component
			ReservationIDTextField.setEnabled(false); //Disables the component
			ReservationForeLabel.setEnabled(false); //Disables the component
			ReservationForeTextField.setEnabled(false); //Disables the component
			ReservationSurLabel.setEnabled(false); //Disables the component
			ReservationSurTextField.setEnabled(false); //Disables the component
			ReservationTableLabel.setEnabled(false); //Disables the component
			ReservationTableTextField.setEnabled(false); //Disables the component
			ReservationDateLabel.setEnabled(false); //Disables the component
			ReservationDateTextField.setEnabled(false); //Disables the component
			ReservationDetailsLabel.setEnabled(false); //Disables the component
			ReservationDetailsTextField.setEnabled(false); //Disables the component
			ReservationPhoneLabel.setEnabled(false); //Disables the component
			ReservationPhoneTextField.setEnabled(false); //Disables the component
			ReservationAddButton.setEnabled(false); //Disables the component
			
			ReservationIDTextField.setText(null); //Clears the text in the field
			ReservationForeTextField.setText(null); //Clears the text in the field
			ReservationSurTextField.setText(null); //Clears the text in the field
			ReservationTableTextField.setText(null); //Clears the text in the field
			ReservationDateTextField.setText(null); //Clears the text in the field
			ReservationDetailsTextField.setText(null); //Clears the text in the field
			ReservationPhoneTextField.setText(null); //Clears the text in the field
			
			ReservationSearchIDLabel.setEnabled(false); //Disables the component
			ReservationSearchIDTextField.setEnabled(false); //Disables the component
			ReservationSearchForeLabel.setEnabled(false); //Disables the component
			ReservationSearchForeTextField.setEnabled(false); //Disables the component
			ReservationSearchSurLabel.setEnabled(false); //Disables the component
			ReservationSearchSurTextField.setEnabled(false); //Disables the component
			ReservationSearchTableLabel.setEnabled(false); //Disables the component
			ReservationSearchTableTextField.setEnabled(false); //Disables the component
			ReservationSearchDateLabel.setEnabled(false); //Disables the component
			ReservationSearchDateTextField.setEnabled(false); //Disables the component
			ReservationSearchDetailsLabel.setEnabled(false); //Disables the component
			ReservationSearchDetailsTextField.setEnabled(false); //Disables the component
			ReservationSearchPhoneLabel.setEnabled(false); //Disables the component
			ReservationSearchPhoneTextField.setEnabled(false); //Disables the component
			ReservationEditButton.setEnabled(false); //Disables the component
			
			ReservationSearchIDTextField.setText(null); //Clears the text in the field
			ReservationSearchForeTextField.setText(null); //Clears the text in the field
			ReservationSearchSurTextField.setText(null); //Clears the text in the field
			ReservationSearchTableTextField.setText(null); //Clears the text in the field
			ReservationSearchDateTextField.setText(null); //Clears the text in the field
			ReservationSearchDetailsTextField.setText(null); //Clears the text in the field
			ReservationSearchPhoneTextField.setText(null); //Clears the text in the field
			
			ReservationSearchLabel.setEnabled(false); //Disables the component
			ReservationSearchField.setEnabled(false); //Disables the component
			ReservationSearchButton.setEnabled(false); //Disables the component
			ReservationSearchField.setText(null); //Clears the text in the field
		
		
		}
		
		if(e.getSource() == ReservationHomeButton) //Takes the user to the home page when clicked
		{
			myTabs.setSelectedIndex(1);
		
			ReservationIDLabel.setEnabled(false); //Disables the component
			ReservationIDTextField.setEnabled(false); //Disables the component
			ReservationForeLabel.setEnabled(false); //Disables the component
			ReservationForeTextField.setEnabled(false); //Disables the component
			ReservationSurLabel.setEnabled(false); //Disables the component
			ReservationSurTextField.setEnabled(false); //Disables the component
			ReservationTableLabel.setEnabled(false); //Disables the component
			ReservationTableTextField.setEnabled(false); //Disables the component
			ReservationDateLabel.setEnabled(false); //Disables the component
			ReservationDateTextField.setEnabled(false); //Disables the component
			ReservationDetailsLabel.setEnabled(false); //Disables the component
			ReservationDetailsTextField.setEnabled(false); //Disables the component
			ReservationPhoneLabel.setEnabled(false); //Disables the component
			ReservationPhoneTextField.setEnabled(false); //Disables the component
			ReservationAddButton.setEnabled(false); //Disables the component
			
			ReservationIDTextField.setText(null); //Clears the text in the field
			ReservationForeTextField.setText(null); //Clears the text in the field
			ReservationSurTextField.setText(null); //Clears the text in the field
			ReservationTableTextField.setText(null); //Clears the text in the field
			ReservationDateTextField.setText(null); //Clears the text in the field
			ReservationDetailsTextField.setText(null); //Clears the text in the field
			ReservationPhoneTextField.setText(null); //Clears the text in the field
			
			ReservationSearchIDLabel.setEnabled(false); //Disables the component
			ReservationSearchIDTextField.setEnabled(false); //Disables the component
			ReservationSearchForeLabel.setEnabled(false); //Disables the component
			ReservationSearchForeTextField.setEnabled(false); //Disables the component
			ReservationSearchSurLabel.setEnabled(false); //Disables the component
			ReservationSearchSurTextField.setEnabled(false); //Disables the component
			ReservationSearchTableLabel.setEnabled(false); //Disables the component
			ReservationSearchTableTextField.setEnabled(false); //Disables the component
			ReservationSearchDateLabel.setEnabled(false); //Disables the component
			ReservationSearchDateTextField.setEnabled(false); //Disables the component
			ReservationSearchDetailsLabel.setEnabled(false); //Disables the component
			ReservationSearchDetailsTextField.setEnabled(false); //Disables the component
			ReservationSearchPhoneLabel.setEnabled(false); //Disables the component
			ReservationSearchPhoneTextField.setEnabled(false); //Disables the component
			ReservationEditButton.setEnabled(false); //Disables the component
			
			ReservationSearchIDTextField.setText(null); //Clears the text in the field
			ReservationSearchForeTextField.setText(null); //Clears the text in the field
			ReservationSearchSurTextField.setText(null); //Clears the text in the field
			ReservationSearchTableTextField.setText(null); //Clears the text in the field
			ReservationSearchDateTextField.setText(null); //Clears the text in the field
			ReservationSearchDetailsTextField.setText(null); //Clears the text in the field
			ReservationSearchPhoneTextField.setText(null); //Clears the text in the field
			
			ReservationSearchLabel.setEnabled(false); //Disables the component
			ReservationSearchField.setEnabled(false); //Disables the component
			ReservationSearchButton.setEnabled(false); //Disables the component
			ReservationSearchField.setText(null); //Clears the text in the field
		}
		
		if(e.getSource() == StaffIDButton) //Shows the table with a list of staff members when pressed
		{
			staffScroll.setVisible(true); //Sets the component to be visible
			adminScroll.setVisible(false); //Sets the component to not visible
		}
		
		if(e.getSource() == AdminIDButton) //Shows the table with a list of administrators when pressed
		{
			staffScroll.setVisible(false); //Sets the component to not visible
			adminScroll.setVisible(true); //Sets the component to be visible
		}
		
		if(e.getSource() == EnableStaffPasswordButton) //When pressed, it enables the textfields and buttons which allows the staff member to change their password
		{
			ExistingPasswordLabel.setEnabled(true); //Enables the component
			ExistingPasswordField.setEnabled(true); //Enables the component
			NewPasswordLabel.setEnabled(true); //Enables the component
			NewPasswordField.setEnabled(true); //Enables the component
			ChangeStaffPasswordButton.setEnabled(true); //Enables the component
		}
		
		if(e.getSource() == EnableAdminPasswordButton) //When pressed, it enables the textfields and buttons which allows the administrator to change their password
		{
			ExistingPasswordLabel.setEnabled(true); //Enables the component
			ExistingPasswordField.setEnabled(true); //Enables the component
			NewPasswordLabel.setEnabled(true); //Enables the component
			NewPasswordField.setEnabled(true); //Enables the component
			ChangeAdminPasswordButton.setEnabled(true); //Enables the component
		}
		
		if(e.getSource() == ChangeStaffPasswordButton) //Button which will change the staff member's password if the password in the Current Password field matches their current password and if they have entered a new password
		{
			String currentPassword = ExistingPasswordField.getText(); //Gets the text from the field
			String newPassword = NewPasswordField.getText(); //Gets the text from the field
			
			if((currentPassword.equals(currentStaff.password))&&(!newPassword.equals("")))
			{
				ExistingPasswordField.setText(null); //Clears the text in the field
				NewPasswordField.setText(null); //Clears the text in the field
				ExistingPasswordLabel.setEnabled(false); //Disables the component
				ExistingPasswordField.setEnabled(false); //Disables the component
				NewPasswordLabel.setEnabled(false); //Disables the component
				NewPasswordField.setEnabled(false); //Disables the component
				ChangeStaffPasswordButton.setEnabled(false); //Disables the component
				int location = allStaff.searchName(currentStaff.staffid);
				currentStaff.password = newPassword;
				allStaff.replaceStaff(location,currentStaff);
				allStaff.writeToFile(); //Writing to file
				JOptionPane.showMessageDialog(frame, "Password changed successfully!"); //Message Dialog after password changed
			}
			
			else
			{
				JOptionPane.showMessageDialog(frame, "Incorrect current password entered or no new password entered!");
				ExistingPasswordLabel.setEnabled(false); //Disables the component
				ExistingPasswordField.setEnabled(false); //Disables the component
				ExistingPasswordField.setText(null); //Clears the text in the field
				NewPasswordLabel.setEnabled(false); //Disables the component
				NewPasswordField.setEnabled(false); //Disables the component
				NewPasswordField.setText(null); //Clears the text in the field
				ChangeStaffPasswordButton.setEnabled(false); //Disables the component
			}
		}
		
		if(e.getSource() == ChangeAdminPasswordButton) //Button which will change the administrator's password if the password in the Current Password field matches their current password and if they have entered a new password
		{
			String currentPassword = ExistingPasswordField.getText(); //Gets the text from the field
			String newPassword = NewPasswordField.getText(); //Gets the text from the field
			
			if((currentPassword.equals(currentAdmin.password))&&(!newPassword.equals("")))
			{
				ExistingPasswordField.setText(null); //Clears the text in the field
				NewPasswordField.setText(null); //Clears the text in the field
				ExistingPasswordLabel.setEnabled(false); //Disables the component
				ExistingPasswordField.setEnabled(false); //Disables the component
				NewPasswordLabel.setEnabled(false); //Disables the component
				NewPasswordField.setEnabled(false); //Disables the component
				ChangeAdminPasswordButton.setEnabled(false); //Disables the component
				int location = allAdmins.searchName(currentAdmin.adminid);
				currentAdmin.password = newPassword;
				allAdmins.replaceAdmin(location,currentAdmin);
				allAdmins.writeToFile(); //Writing to file
				JOptionPane.showMessageDialog(frame, "Password changed successfully!"); //Message dialog after password changed
			}
			
			else
			{
				JOptionPane.showMessageDialog(frame, "Incorrect current password entered or no new password entered!"); //Error message
				ExistingPasswordLabel.setEnabled(false); //Disables the component
				ExistingPasswordField.setEnabled(false); //Disables the component
				ExistingPasswordField.setText(null); //Clears the text in the field
				NewPasswordLabel.setEnabled(false); //Disables the component
				NewPasswordField.setEnabled(false); //Disables the component
				NewPasswordField.setText(null); //Clears the text in the field
				ChangeAdminPasswordButton.setEnabled(false); //Disables the component
			}
		}
		
		if(e.getSource() == CreationSearchAndEditButton) //Button on creation page which activates the search textfields and buttons
		{
			CreationStaffSearchLabel.setEnabled(true); //Enables the component
			CreationStaffSearchField.setEnabled(true); //Enables the component
			CreationStaffSearchButton.setEnabled(true); //Enables the component
			CreationAdminSearchLabel.setEnabled(true); //Enables the component
			CreationAdminSearchField.setEnabled(true); //Enables the component
			CreationAdminSearchButton.setEnabled(true); //Enables the component
			StaffForeTextField.setText(null); //Clears the text in the field
			AdminForeTextField.setText(null); //Clears the text in the field
			StaffSurTextField.setText(null); //Clears the text in the field
			AdminSurTextField.setText(null); //Clears the text in the field
			StaffMiddleTextField.setText(null); //Clears the text in the field
			AdminMiddleTextField.setText(null); //Clears the text in the field
			StaffIDTextField.setText(null); //Clears the text in the field
			AdminIDTextField.setText(null); //Clears the text in the field
			StaffBirthTextField.setText(null); //Clears the text in the field
			AdminBirthTextField.setText(null); //Clears the text in the field
			StaffPasswordTextField.setText(null); //Clears the text in the field
			AdminPasswordTextField.setText(null); //Clears the text in the field
			CreationStaffSearchField.setText(null); //Clears the text in the field
			CreationAdminSearchField.setText(null); //Clears the text in the field
			StaffForeTextField.setEnabled(false); //Disables the component
			CreationStaffForeLabel.setEnabled(false); //Disables the component
			StaffSurTextField.setEnabled(false); //Disables the component
			CreationStaffSurLabel.setEnabled(false); //Disables the component
			StaffMiddleTextField.setEnabled(false); //Disables the component
			CreationStaffMiddleLabel.setEnabled(false); //Disables the component
			StaffIDTextField.setEnabled(false); //Disables the component
			CreationStaffIDLabel.setEnabled(false); //Disables the component
			StaffBirthTextField.setEnabled(false); //Disables the component
			CreationStaffBirthLabel.setEnabled(false); //Disables the component
			StaffPasswordTextField.setEnabled(false); //Disables the component
			CreationStaffPasswordLabel.setEnabled(false); //Disables the component
			CreationAddStaffButton.setEnabled(false); //Disables the component
			CreationEditStaffButton.setEnabled(false); //Disables the component
			AdminForeTextField.setEnabled(false); //Disables the component
			CreationAdminForeLabel.setEnabled(false); //Disables the component
			AdminSurTextField.setEnabled(false); //Disables the component
			CreationAdminSurLabel.setEnabled(false); //Disables the component
			AdminMiddleTextField.setEnabled(false); //Disables the component
			CreationAdminMiddleLabel.setEnabled(false); //Disables the component
			AdminIDTextField.setEnabled(false); //Disables the component
			CreationAdminIDLabel.setEnabled(false); //Disables the component
			AdminBirthTextField.setEnabled(false); //Disables the component
			CreationAdminBirthLabel.setEnabled(false); //Disables the component
			AdminPasswordTextField.setEnabled(false); //Disables the component
			CreationAdminPasswordLabel.setEnabled(false); //Disables the component
			CreationAddAdminButton.setEnabled(false); //Disables the component
			CreationEditAdminButton.setEnabled(false); //Disables the component
		}
		
		if(e.getSource() == CreationCreateStaffButton) //Button on creation page which activates the staff fields
		{
			CreationStaffIDLabel.setEnabled(true); //Enables the component
			StaffIDTextField.setEnabled(true); //Enables the component
			CreationAddStaffButton.setEnabled(true); //Enables the component
			CreationEditStaffButton.setEnabled(false); //Disables the component
			CreationStaffSearchLabel.setEnabled(false); //Disables the component
			CreationStaffSearchField.setEnabled(false); //Disables the component
			CreationStaffSearchButton.setEnabled(false); //Disables the component
			CreationAdminSearchLabel.setEnabled(false); //Disables the component
			CreationAdminSearchField.setEnabled(false); //Disables the component
			CreationAdminSearchButton.setEnabled(false); //Disables the component
			StaffForeTextField.setText(null); //Clears the text in the field
			StaffSurTextField.setText(null); //Clears the text in the field
			StaffMiddleTextField.setText(null); //Clears the text in the field
			StaffIDTextField.setText(null); //Clears the text in the field
			StaffBirthTextField.setText(null); //Clears the text in the field
			StaffPasswordTextField.setText(null); //Clears the text in the field
			CreationStaffSearchField.setText(null); //Clears the text in the field
			StaffForeTextField.setEnabled(true); //Enables the component
			CreationStaffForeLabel.setEnabled(true); //Enables the component
			StaffSurTextField.setEnabled(true); //Enables the component
			CreationStaffSurLabel.setEnabled(true); //Enables the component
			StaffMiddleTextField.setEnabled(true); //Enables the component
			CreationStaffMiddleLabel.setEnabled(true); //Enables the component
			StaffBirthTextField.setEnabled(true); //Enables the component
			CreationStaffBirthLabel.setEnabled(true); //Enables the component
			StaffPasswordTextField.setEnabled(true); //Enables the component
			CreationStaffPasswordLabel.setEnabled(true); //Enables the component
			CreationAddStaffButton.setEnabled(true); //Enables the component
			CreationEditStaffButton.setEnabled(false); //Disables the component
			CreationAdminSearchLabel.setEnabled(false); //Disables the component
			CreationAdminSearchField.setEnabled(false); //Disables the component
			CreationAdminSearchButton.setEnabled(false); //Disables the component
			AdminForeTextField.setEnabled(false); //Disables the component
			CreationAdminForeLabel.setEnabled(false); //Disables the component
			AdminSurTextField.setEnabled(false); //Disables the component
			CreationAdminSurLabel.setEnabled(false); //Disables the component
			AdminMiddleTextField.setEnabled(false); //Disables the component
			CreationAdminMiddleLabel.setEnabled(false); //Disables the component
			AdminBirthTextField.setEnabled(false); //Disables the component
			CreationAdminBirthLabel.setEnabled(false); //Disables the component
			AdminIDTextField.setEnabled(false); //Disables the component
			CreationAdminIDLabel.setEnabled(false); //Disables the component
			AdminPasswordTextField.setEnabled(false); //Disables the component
			CreationAdminPasswordLabel.setEnabled(false); //Disables the component
			AdminForeTextField.setText(null); //Clears the text in the field
			AdminSurTextField.setText(null); //Clears the text in the field
			AdminMiddleTextField.setText(null); //Clears the text in the field
			AdminIDTextField.setText(null); //Clears the text in the field
			AdminBirthTextField.setText(null); //Clears the text in the field
			AdminPasswordTextField.setText(null); //Clears the text in the field
			CreationAdminSearchField.setText(null); //Clears the text in the field
			CreationAddAdminButton.setEnabled(false); //Disables the component
			CreationEditAdminButton.setEnabled(false); //Disables the component
		}
		
		if(e.getSource() == CreationCreateAdminButton) //Button on creation page which activates the administrator fields
		{
			CreationAddAdminButton.setEnabled(true); //Enables the component
			CreationEditAdminButton.setEnabled(false); //Disables the component
			CreationStaffSearchLabel.setEnabled(false); //Disables the component
			CreationStaffSearchField.setEnabled(false); //Disables the component
			CreationStaffSearchButton.setEnabled(false); //Disables the component
			CreationAdminSearchLabel.setEnabled(false); //Disables the component
			CreationAdminSearchField.setEnabled(false); //Disables the component
			CreationAdminSearchButton.setEnabled(false); //Disables the component
			AdminForeTextField.setText(null); //Clears the text in the field
			AdminSurTextField.setText(null); //Clears the text in the field
			AdminMiddleTextField.setText(null); //Clears the text in the field
			AdminIDTextField.setText(null); //Clears the text in the field
			AdminBirthTextField.setText(null); //Clears the text in the field
			AdminPasswordTextField.setText(null); //Clears the text in the field
			CreationAdminSearchField.setText(null); //Clears the text in the field
			AdminForeTextField.setEnabled(true); //Enables the component
			CreationAdminForeLabel.setEnabled(true); //Enables the component
			AdminSurTextField.setEnabled(true); //Enables the component
			CreationAdminSurLabel.setEnabled(true); //Enables the component
			AdminMiddleTextField.setEnabled(true); //Enables the component
			CreationAdminMiddleLabel.setEnabled(true); //Enables the component
			AdminBirthTextField.setEnabled(true); //Enables the component
			CreationAdminBirthLabel.setEnabled(true); //Enables the component
			AdminIDTextField.setEnabled(true); //Enables the component
			CreationAdminIDLabel.setEnabled(true); //Enables the component
			AdminPasswordTextField.setEnabled(true); //Enables the component
			CreationAdminPasswordLabel.setEnabled(true); //Enables the component
			CreationAddAdminButton.setEnabled(true); //Enables the component
			CreationEditAdminButton.setEnabled(false); //Disables the component
			CreationStaffSearchLabel.setEnabled(false); //Disables the component
			CreationStaffSearchField.setEnabled(false); //Disables the component
			CreationStaffSearchButton.setEnabled(false); //Disables the component
			StaffForeTextField.setText(null); //Clears the text in the field
			StaffSurTextField.setText(null); //Clears the text in the field
			StaffMiddleTextField.setText(null); //Clears the text in the field
			StaffIDTextField.setText(null); //Clears the text in the field
			StaffBirthTextField.setText(null); //Clears the text in the field
			StaffPasswordTextField.setText(null); //Clears the text in the field
			CreationStaffSearchField.setText(null); //Clears the text in the field
			StaffForeTextField.setEnabled(false); //Disables the component
			CreationStaffForeLabel.setEnabled(false); //Disables the component
			StaffSurTextField.setEnabled(false); //Disables the component
			CreationStaffSurLabel.setEnabled(false); //Disables the component
			StaffMiddleTextField.setEnabled(false); //Disables the component
			CreationStaffMiddleLabel.setEnabled(false); //Disables the component
			StaffIDTextField.setEnabled(false); //Disables the component
			CreationStaffIDLabel.setEnabled(false); //Disables the component
			StaffBirthTextField.setEnabled(false); //Disables the component
			CreationStaffBirthLabel.setEnabled(false); //Disables the component
			StaffPasswordTextField.setEnabled(false); //Disables the component
			CreationStaffPasswordLabel.setEnabled(false); //Disables the component
			CreationStaffSearchField.setText(null); //Clears the text in the field
			CreationAddStaffButton.setEnabled(false); //Disables the component
			CreationEditStaffButton.setEnabled(false); //Disables the component
		}
			
		if(e.getSource() == CreationClearFieldsButton) //Button which will clear all the fields on the creation page when pressed. Useful for when a new user is to be added
		{
			StaffIDTextField.setEnabled(false); //Disables the component
			AdminIDTextField.setEnabled(false); //Disables the component
			CreationStaffIDLabel.setEnabled(false); //Disables the component
			CreationAdminIDLabel.setEnabled(false); //Disables the component
			StaffForeTextField.setText(null); //Clears the text in the field
			AdminForeTextField.setText(null); //Clears the text in the field
			StaffSurTextField.setText(null); //Clears the text in the field
			AdminSurTextField.setText(null); //Clears the text in the field
			StaffMiddleTextField.setText(null); //Clears the text in the field
			AdminMiddleTextField.setText(null); //Clears the text in the field
			StaffIDTextField.setText(null); //Clears the text in the field
			AdminIDTextField.setText(null); //Clears the text in the field
			StaffBirthTextField.setText(null); //Clears the text in the field
			AdminBirthTextField.setText(null); //Clears the text in the field
			StaffPasswordTextField.setText(null); //Clears the text in the field
			AdminPasswordTextField.setText(null); //Clears the text in the field
			CreationStaffSearchField.setText(null); //Clears the text in the field
			CreationAdminSearchField.setText(null); //Clears the text in the field
			StaffForeTextField.setEnabled(false); //Disables the component
			CreationStaffForeLabel.setEnabled(false); //Disables the component
			StaffSurTextField.setEnabled(false); //Disables the component
			CreationStaffSurLabel.setEnabled(false); //Disables the component
			StaffMiddleTextField.setEnabled(false); //Disables the component
			CreationStaffMiddleLabel.setEnabled(false); //Disables the component
			StaffBirthTextField.setEnabled(false); //Disables the component
			CreationStaffBirthLabel.setEnabled(false); //Disables the component
			StaffPasswordTextField.setEnabled(false); //Disables the component
			CreationStaffPasswordLabel.setEnabled(false); //Disables the component
			CreationAddStaffButton.setEnabled(false); //Disables the component
			CreationEditStaffButton.setEnabled(false); //Disables the component
			AdminForeTextField.setEnabled(false); //Disables the component
			CreationAdminForeLabel.setEnabled(false); //Disables the component
			AdminSurTextField.setEnabled(false); //Disables the component
			CreationAdminSurLabel.setEnabled(false); //Disables the component
			AdminMiddleTextField.setEnabled(false); //Disables the component
			CreationAdminMiddleLabel.setEnabled(false); //Disables the component
			AdminBirthTextField.setEnabled(false); //Disables the component
			CreationAdminBirthLabel.setEnabled(false); //Disables the component
			AdminPasswordTextField.setEnabled(false); //Disables the component
			CreationAdminPasswordLabel.setEnabled(false); //Disables the component
			CreationAddAdminButton.setEnabled(false); //Disables the component
			CreationEditAdminButton.setEnabled(false); //Disables the component
			CreationStaffSearchLabel.setEnabled(false); //Disables the component
			CreationStaffSearchField.setEnabled(false); //Disables the component
			CreationStaffSearchButton.setEnabled(false); //Disables the component
			CreationAdminSearchLabel.setEnabled(false); //Disables the component
			CreationAdminSearchField.setEnabled(false); //Disables the component
			CreationAdminSearchButton.setEnabled(false); //Disables the component
		}
		
		if(e.getSource() == LogoutButton) //Logs out the current user and sets their currently selected tab to the login page
		{
			currentStaff = null;
			currentAdmin = null;
			StaffTextField.setText(null); //Clears the text in the field
			StaffPassField.setText(null); //Clears the text in the field
			AdminTextField.setText(null); //Clears the text in the field
			AdminPassField.setText(null); //Clears the text in the field
			JOptionPane.showMessageDialog(frame,"Goodbye!"); //Goodbye message dialog
			myTabs.setSelectedIndex(0);
			myTabs.setEnabledAt(0, true);
			myTabs.setEnabledAt(1, false);
			myTabs.setEnabledAt(2, false);
			myTabs.setEnabledAt(3, false);
			myTabs.setEnabledAt(4, false);
			EnableStaffPasswordButton.setVisible(false); //Sets the component to not visible
			ChangeStaffPasswordButton.setVisible(false); //Sets the component to not visible
			EnableAdminPasswordButton.setVisible(false); //Sets the component to not visible
			ChangeAdminPasswordButton.setVisible(false); //Sets the component to not visible
		}
		
		if(e.getSource() == CreationStaffSearchButton) //When pressed, it will search for a staff member with the staff ID input into the staff search textfield
		{
			String tempStaffID = CreationStaffSearchField.getText(); //Gets the text from the field
			int location = allStaff.searchName(tempStaffID);
			Staff tempStaff = allStaff.findStaff(location);
			
			StaffForeTextField.setText(tempStaff.forename);
			StaffSurTextField.setText(tempStaff.surname);
			StaffMiddleTextField.setText(tempStaff.middlename);
			StaffIDTextField.setText(tempStaff.staffid);
			StaffBirthTextField.setText(tempStaff.dateofbirth);
			StaffPasswordTextField.setText(tempStaff.password);
			StaffForeTextField.setEnabled(true); //Enables the component
			CreationStaffForeLabel.setEnabled(true); //Enables the component
			StaffSurTextField.setEnabled(true); //Enables the component
			CreationStaffSurLabel.setEnabled(true); //Enables the component
			StaffMiddleTextField.setEnabled(true); //Enables the component
			CreationStaffMiddleLabel.setEnabled(true); //Enables the component
			StaffBirthTextField.setEnabled(true); //Enables the component
			CreationStaffBirthLabel.setEnabled(true); //Enables the component
			StaffPasswordTextField.setEnabled(true); //Enables the component
			CreationStaffPasswordLabel.setEnabled(true); //Enables the component
			CreationAddStaffButton.setEnabled(false); //Disables the component
			CreationEditStaffButton.setEnabled(true); //Enables the component
		}
		
		if(e.getSource() == CreationAdminSearchButton) //When pressed, it will search for an administrator with the admin ID input into the admin search textfield
		{
			String tempAdminID = CreationAdminSearchField.getText(); //Gets the text from the field
			int location = allAdmins.searchName(tempAdminID);
			Admin tempAdmin = allAdmins.findAdmin(location);
			
			AdminForeTextField.setText(tempAdmin.forename);
			AdminSurTextField.setText(tempAdmin.surname);
			AdminMiddleTextField.setText(tempAdmin.middlename);
			AdminIDTextField.setText(tempAdmin.adminid);
			AdminBirthTextField.setText(tempAdmin.dateofbirth);
			AdminPasswordTextField.setText(tempAdmin.password);
			AdminForeTextField.setEnabled(true); //Enables the component
			CreationAdminForeLabel.setEnabled(true); //Enables the component
			AdminSurTextField.setEnabled(true); //Enables the component
			CreationAdminSurLabel.setEnabled(true); //Enables the component
			AdminMiddleTextField.setEnabled(true); //Enables the component
			CreationAdminMiddleLabel.setEnabled(true); //Enables the component
			AdminBirthTextField.setEnabled(true); //Enables the component
			CreationAdminBirthLabel.setEnabled(true); //Enables the component
			AdminPasswordTextField.setEnabled(true); //Enables the component
			CreationAdminPasswordLabel.setEnabled(true); //Enables the component
			CreationAddAdminButton.setEnabled(false); //Disables the component
			CreationEditAdminButton.setEnabled(true); //Enables the component
		}
		
		if(e.getSource() == ReservationSearchButton) //Button which will search for a reservation with the ID input into the reservation search field
		{
			String tempReservationID = ReservationSearchField.getText(); //Gets the text from the field
			int location = allReservations.searchName(tempReservationID);
			Reservation tempReservation = allReservations.findReservation(location);
			
			ReservationSearchIDTextField.setText(tempReservation.reservationid);
			ReservationSearchForeTextField.setText(tempReservation.forename);
			ReservationSearchSurTextField.setText(tempReservation.surname);
			ReservationSearchTableTextField.setText(tempReservation.table);
			ReservationSearchDateTextField.setText(tempReservation.date);
			ReservationSearchDetailsTextField.setText(tempReservation.details);
			ReservationSearchPhoneTextField.setText(tempReservation.phone);
			ReservationSearchIDLabel.setEnabled(false); //Disables the component
			ReservationSearchIDTextField.setEnabled(false); //Disables the component
			ReservationSearchForeLabel.setEnabled(true); //Enables the component
			ReservationSearchForeTextField.setEnabled(true); //Enables the component
			ReservationSearchSurLabel.setEnabled(true); //Enables the component
			ReservationSearchSurTextField.setEnabled(true); //Enables the component
			ReservationSearchTableLabel.setEnabled(true); //Enables the component
			ReservationSearchTableTextField.setEnabled(true); //Enables the component
			ReservationSearchDateLabel.setEnabled(true); //Enables the component
			ReservationSearchDateTextField.setEnabled(true); //Enables the component
			ReservationSearchDetailsLabel.setEnabled(true); //Enables the component
			ReservationSearchDetailsTextField.setEnabled(true); //Enables the component
			ReservationSearchPhoneLabel.setEnabled(true); //Enables the component
			ReservationSearchPhoneTextField.setEnabled(true); //Enables the component
			ReservationEditButton.setEnabled(true); //Enables the component
		}
		
		if(e.getSource() == StaffLoginButton) //If the username and password input into the textfields match and the staff login button is pressed then the user will be able to access the home page, rewards page and the points page
		{
			String tempUsername = StaffTextField.getText(); //Gets the text from the field
			int location = allStaff.searchName(tempUsername);
			String tempPassword = StaffPassField.getText(); //Gets the text from the field
			
			if(location >-1)
			{
				currentStaff = allStaff.findStaff(location);
				
				if(currentStaff.password.equals(tempPassword))
				{
					GoToReservationButton.setVisible(true); //Sets the component to be visible
					GoToMenuAndOrderButton.setVisible(true); //Sets the component to be visible
					GoToCreationButton.setVisible(false); //Sets the component to not visible
					EnableStaffPasswordButton.setVisible(true); //Sets the component to be visible
					ChangeStaffPasswordButton.setVisible(true); //Sets the component to be visible
					ChangeStaffPasswordButton.setEnabled(false); //Disables the component
					
					GoToReservationButton.setBounds(180, 190, 200, 25);
					GoToMenuAndOrderButton.setBounds(180, 150, 200, 25);
					LogoutButton.setBounds(180, 230, 200, 25);
					
					EnableStaffPasswordButton.setBounds(170, 350, 220, 30);
					ChangeStaffPasswordButton.setBounds(360, 400, 150, 70);
					ExistingPasswordLabel.setBounds(80, 400, 150,30);
					ExistingPasswordField.setBounds(200, 400, 150, 30);
					NewPasswordLabel.setBounds(80, 440, 150, 30);
					NewPasswordField.setBounds(200, 440, 150, 30);
					
					
					
					JOptionPane.showMessageDialog(frame,"Staff Login Successful!\r\n Logged in as: "+tempUsername); //Message Dialog after staff logged in
					myTabs.setSelectedIndex(1);
					myTabs.setEnabledAt(0, false);
					myTabs.setEnabledAt(1,true);
					myTabs.setEnabledAt(2, true);
					myTabs.setEnabledAt(3, true);
					myTabs.setEnabledAt(4, false);
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Incorrect Password!"); //Error message
				}
			}
			if((location==-1))
			{
				JOptionPane.showMessageDialog(frame, "Incorrect Username!"); //Error message
			}
		}
		
		if(e.getSource() == AdminLoginButton) //If the username and password input into the textfields match and the administrator login button is pressed then the user will be able to access every page
		{
			String tempUsername = AdminTextField.getText(); //Gets the text from the field
			int location = allAdmins.searchName(tempUsername);
			String tempPassword = AdminPassField.getText(); //Gets the text from the field
			
			if(location >-1)
			{
				currentAdmin = allAdmins.findAdmin(location);
				
				if(currentAdmin.password.equals(tempPassword))
				{
					GoToReservationButton.setVisible(true); //Sets the component to be visible
					GoToMenuAndOrderButton.setVisible(true); //Sets the component to be visible
					GoToCreationButton.setVisible(true); //Sets the component to be visible
					EnableAdminPasswordButton.setVisible(true); //Sets the component to be visible
					ChangeAdminPasswordButton.setVisible(true); //Sets the component to be visible
					ChangeAdminPasswordButton.setEnabled(false); //Disables the component
					
					GoToReservationButton.setBounds(180, 190, 200, 25);
					GoToMenuAndOrderButton.setBounds(180, 150, 200, 25);
					GoToCreationButton.setBounds(180, 230, 200, 25);
					LogoutButton.setBounds(180, 270, 200, 25);
					
					JOptionPane.showMessageDialog(frame,"Admin Login Successful!\r\n Logged in as: "+tempUsername); //Message Dialog after admin logged in
					myTabs.setSelectedIndex(1);
					myTabs.setEnabledAt(0, false);
					myTabs.setEnabledAt(1,true);
					myTabs.setEnabledAt(2, true);
					myTabs.setEnabledAt(3, true);
					myTabs.setEnabledAt(4, true);
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Incorrect Password!"); //Error message
				}
			}
			if((location==-1))
			{
				JOptionPane.showMessageDialog(frame, "Incorrect Username!"); //Error message
			}
		}
		
		if(e.getSource() == FinishItemButton) //Saves the information in menu item creation fields to the text file
		{
			String tempMenu = ItemNumberField.getText(); //Gets the text from the field
			int location = allMenus.searchName(tempMenu);
			
			if(location==-1)
			{
			
				if((!ItemNumberField.getText().equals("")==true)&&(location==-1)&&(!ItemNameField.getText().equals("")==true)&&(!ItemExtrasField.getText().equals("")==true)&&(!PriceField.getText().equals("")==true))
				{
					oneMenu = new Menu();
					oneMenu.itemnumber = ItemNumberField.getText(); //Gets the text from the field
					oneMenu.itemname = ItemNameField.getText(); //Gets the text from the field
					oneMenu.itemextras = ItemExtrasField.getText(); //Gets the text from the field
					oneMenu.price = Double.parseDouble(PriceField.getText()); //Gets the text from the field
					JOptionPane.showMessageDialog(frame, "Item was created successfully!"); //Message Dialog after item was created
					allMenus.addMenu(oneMenu);
					allMenus.writeToFile(); //Writing to file
				}
				
				else
				{
					JOptionPane.showMessageDialog(frame, "Cannot successfully create the item!\r\nIs a field empty?"); //Error message
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(frame,"Item ID already exists!"); //Error message
			}
		
		}
		
		if(e.getSource() == FinishOrderButton) //Saves the information in the order creation fields to the text file
		{
			if((!ProductOneTextField.getText().equals("")==true))
			{
				oneOrder = new Order();
				oneOrder.productone = ProductOneTextField.getText(); //Gets the text from the field
				oneOrder.producttwo = ProductTwoTextField.getText(); //Gets the text from the field
				oneOrder.productthree = ProductThreeTextField.getText(); //Gets the text from the field
				oneOrder.productfour = ProductFourTextField.getText(); //Gets the text from the field
				oneOrder.productfive = ProductFiveTextField.getText(); //Gets the text from the field
				oneOrder.productsix = ProductSixTextField.getText(); //Gets the text from the field
				oneOrder.productseven = ProductSevenTextField.getText(); //Gets the text from the field
				oneOrder.producteight = ProductEightTextField.getText(); //Gets the text from the field
				
				JOptionPane.showMessageDialog(frame, "Order was created successfully!"); //Message Dialog after order was created successfully
				allOrders.addOrder(oneOrder);
				allOrders.writeToFile(); //Writing to file
			}
				
			else
			{
				JOptionPane.showMessageDialog(frame, "Cannot successfully create the order!\r\nIs a field empty?"); //Error message
			}
			
		}
		
		if(e.getSource() == ReservationAddButton) //When all the correct staff member information is put into the fields on the creation page, and the creation add staff button is pressed then the staff member will be added successfully
		{
			String tempReservation = ReservationIDTextField.getText(); //Gets the text from the field
			int location = allReservations.searchName(tempReservation);
			
			if(location==-1)
			{
			
				if((!ReservationIDTextField.getText().equals("")==true)&&(location==-1)&&(!ReservationForeTextField.getText().equals("")==true)&&(!ReservationSurTextField.getText().equals("")==true)&&(!ReservationTableTextField.getText().equals("")==true)&&(!ReservationDateTextField.getText().equals("")==true)&&(!ReservationDetailsTextField.getText().equals("")==true)&&(!ReservationPhoneTextField.getText().equals("")==true))
				{
					oneReservation = new Reservation();
					oneReservation.reservationid = ReservationIDTextField.getText(); //Gets the text from the field
					oneReservation.forename = ReservationForeTextField.getText(); //Gets the text from the field
					oneReservation.surname = ReservationSurTextField.getText(); //Gets the text from the field
					oneReservation.table = ReservationTableTextField.getText(); //Gets the text from the field
					oneReservation.date = ReservationDateTextField.getText(); //Gets the text from the field
					oneReservation.details = ReservationDetailsTextField.getText(); //Gets the text from the field
					oneReservation.phone = ReservationPhoneTextField.getText(); //Gets the text from the field
					JOptionPane.showMessageDialog(frame, "Reservation was created successfully!"); //Message Dialog after reservation was created successfully
					allReservations.addReservation(oneReservation);
					allReservations.writeToFile(); //Writing to file
				}
				
				else
				{
					JOptionPane.showMessageDialog(frame, "Cannot successfully create the Reservation!\r\nIs a field empty?"); //Error message
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(frame,"Reservation ID already exists!"); //Error message
			}
		
		}
		
		if(e.getSource() == ReservationEditButton) //When all the correct staff member information is put into the fields on the creation page, and the creation edit staff button is pressed then the staff member will be edited successfully
		{
			try
			{
				Reservation tempReservation = new Reservation();
				String tempReservationID = ReservationSearchIDTextField.getText(); //Gets the text from the field
				int location = allReservations.searchName(tempReservationID);
				
				tempReservation.reservationid = ReservationSearchIDTextField.getText(); //Gets the text from the field
				tempReservation.forename = ReservationSearchForeTextField.getText(); //Gets the text from the field
				tempReservation.surname = ReservationSearchSurTextField.getText(); //Gets the text from the field
				tempReservation.table = ReservationSearchTableTextField.getText(); //Gets the text from the field
				tempReservation.date = ReservationSearchDateTextField.getText(); //Gets the text from the field
				tempReservation.details = ReservationSearchDetailsTextField.getText(); //Gets the text from the field
				tempReservation.phone = ReservationSearchPhoneTextField.getText(); //Gets the text from the field
				allReservations.replaceReservation(location,tempReservation);
				allReservations.writeToFile();
				JOptionPane.showMessageDialog(frame, "The Reservation details were updated successfully!"); //Message Dialog after reservation was edited
			}
			catch(Exception em)
			{
				JOptionPane.showMessageDialog(frame, "The Reservation details could not be updated!"); //Error message
			}
		}
		
		if(e.getSource() == CreationAddStaffButton) //When all the correct staff member information is put into the fields on the creation page, and the creation add staff button is pressed then the staff member will be added successfully
		{
			String tempUsername = StaffIDTextField.getText(); //Gets the text from the field
			int location = allStaff.searchName(tempUsername);
			
			if(location==-1)
			{
			
				if((!StaffPasswordTextField.getText().equals("")==true)&&(location==-1)&&(!StaffForeTextField.getText().equals("")==true)&&(!StaffSurTextField.getText().equals("")==true)&&(!StaffIDTextField.getText().equals("")==true)&&(!StaffBirthTextField.getText().equals("")==true))
				{
					oneStaff = new Staff();
					oneStaff.forename = StaffForeTextField.getText(); //Gets the text from the field
					oneStaff.surname = StaffSurTextField.getText(); //Gets the text from the field
					oneStaff.middlename = StaffMiddleTextField.getText(); //Gets the text from the field
					oneStaff.staffid = StaffIDTextField.getText(); //Gets the text from the field
					oneStaff.dateofbirth = StaffBirthTextField.getText(); //Gets the text from the field
					oneStaff.password = StaffPasswordTextField.getText(); //Gets the text from the field
					JOptionPane.showMessageDialog(frame, "Staff member was created successfully!"); //Message Dialog after staff member added
					allStaff.addStaff(oneStaff);
					allStaff.writeToFile();
				}
				
				else
				{
					JOptionPane.showMessageDialog(frame, "Cannot successfully create the staff member!\r\nIs a field empty?"); //Error message
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(frame,"Staff ID already exists!"); //Error message
			}
		
		}
		
		if(e.getSource() == CreationEditStaffButton) //When all the correct staff member information is put into the fields on the creation page, and the creation edit staff button is pressed then the staff member will be edited successfully
		{
			try
			{
				Staff tempStaff = new Staff();
				String tempStaffID = StaffIDTextField.getText(); //Gets the text from the field
				int location = allStaff.searchName(tempStaffID);
				
				tempStaff.forename = StaffForeTextField.getText(); //Gets the text from the field
				tempStaff.surname = StaffSurTextField.getText(); //Gets the text from the field
				tempStaff.middlename = StaffMiddleTextField.getText(); //Gets the text from the field
				tempStaff.staffid = StaffIDTextField.getText(); //Gets the text from the field
				tempStaff.dateofbirth = StaffBirthTextField.getText(); //Gets the text from the field
				tempStaff.password = StaffPasswordTextField.getText(); //Gets the text from the field
				allStaff.replaceStaff(location,tempStaff);
				allStaff.writeToFile();
				JOptionPane.showMessageDialog(frame, "The staff details were updated successfully!"); //Message Dialog after staff edited
			}
			catch(Exception em)
			{
				JOptionPane.showMessageDialog(frame, "The staff details could not be updated!"); //Error message
			}
		}
		
		if(e.getSource() == CreationAddAdminButton) //When all the correct admin information is put into the fields on the creation page, and the creation add admin button is pressed then the admin will be added successfully
		{
			String tempUsername = AdminIDTextField.getText(); //Gets the text from the field
			int location = allAdmins.searchName(tempUsername);
			
			if(location==-1)
			{
			
				if((!AdminPasswordTextField.getText().equals("")==true)&&(location==-1)&&(!AdminForeTextField.getText().equals("")==true)&&(!AdminSurTextField.getText().equals("")==true)&&(!AdminIDTextField.getText().equals("")==true)&&(!AdminBirthTextField.getText().equals("")==true))
				{
					oneAdmin = new Admin();
					oneAdmin.forename = AdminForeTextField.getText(); //Gets the text from the field
					oneAdmin.surname = AdminSurTextField.getText(); //Gets the text from the field
					oneAdmin.middlename = AdminMiddleTextField.getText(); //Gets the text from the field
					oneAdmin.adminid = AdminIDTextField.getText(); //Gets the text from the field
					oneAdmin.dateofbirth = AdminBirthTextField.getText(); //Gets the text from the field
					oneAdmin.password = AdminPasswordTextField.getText(); //Gets the text from the field
					JOptionPane.showMessageDialog(frame, "Admin was added successfully!"); //Message Dialog after admin was added
					allAdmins.addAdmin(oneAdmin);
					allAdmins.writeToFile();
				}
				
				else
				{
					JOptionPane.showMessageDialog(frame, "Cannot successfully add the administrator!\r\nIs a field empty?"); //Error message
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(frame, "Admin already exists!"); //Error message
			}
			
		}
		
		if(e.getSource() == CreationEditAdminButton) //When all the correct admin information is put into the fields on the creation page, and the creation edit admin button is pressed then the admin will be edited successfully
		{
			try
			{
				Admin tempAdmin = new Admin();
				String tempAdminID = AdminIDTextField.getText(); //Gets the text from the field
				int location = allAdmins.searchName(tempAdminID);
				
				tempAdmin.forename = AdminForeTextField.getText(); //Gets the text from the field
				tempAdmin.surname = AdminSurTextField.getText(); //Gets the text from the field
				tempAdmin.middlename = AdminMiddleTextField.getText(); //Gets the text from the field
				tempAdmin.adminid = AdminIDTextField.getText(); //Gets the text from the field
				tempAdmin.dateofbirth = AdminBirthTextField.getText(); //Gets the text from the field
				tempAdmin.password = AdminPasswordTextField.getText(); //Gets the text from the field
				allAdmins.replaceAdmin(location,tempAdmin);
				allAdmins.writeToFile();
				JOptionPane.showMessageDialog(frame, "The admin details were updated successfully!"); //Message Dialog after admin was edited
			}
			catch(Exception em)
			{
				JOptionPane.showMessageDialog(frame, "The admin details could not be updated!"); //Error message
			}
		}
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args)
	{
		ItalianGUI tngui = new ItalianGUI();
		tngui.runGUI();
	}	
}