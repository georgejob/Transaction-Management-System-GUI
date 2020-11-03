package application;
/**
 * Controller class 'TransactionController.fxml' this class controls all aspects of the GUI
 * @author Jon Cattuna, George Job
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class TransactionController 
{
	AccountDatabase database = new AccountDatabase();
	String first;
	String last;
	Float amount = 0.0f;
	boolean loyal2 = false;
	
	AccountDatabase data = new AccountDatabase();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    
    @FXML
    private Button importButton;
    
    @FXML
    private Button exportButton;
///////////////////////////////////////////Printing radio button group
    @FXML
    private RadioButton PrintLNrb;

    @FXML
    private RadioButton PrintSrb;

    @FXML
    private RadioButton PrintDOrb;
    
    @FXML
    private Group PrintGroup;
///////////////////////////////////////////////
    @FXML
    private Button PrintButton;

    @FXML
    private TextArea PrintText;

    @FXML
    private Button createButton;
/////////////////////////////grouping account radio buttons
    @FXML
    private RadioButton SrbM;
    //RadioButton SrBM = new RadioButton();

    @FXML
    private RadioButton MMrbM;

    @FXML
    private RadioButton CrbM;
    
    @FXML
    private RadioButton SrbD;
    //RadioButton SrBM = new RadioButton();

    @FXML
    private RadioButton MMrbD;

    @FXML
    private RadioButton CrbD;
    
    @FXML
    private Group ManagerGroup;
    //Group ManagerGroup = new Group;
    //ToggleGroup ManagerGroup;
    //ManagerGroup.getChildren().add(MMrbM);
    //SrBM.setToggleGroup(ManagerGroup);
    
////////////////////////////////////////////////
    @FXML
    private CheckBox checkDD;
    boolean dd = false;

    @FXML
    private CheckBox checkLoyal;
    boolean loyal = false;

    @FXML
    private DatePicker inputDateM;

    @FXML
    private TextField inputFirstM;

    @FXML
    private TextField inputLastM;
    
    @FXML
    private TextField inputAmountM;

    @FXML
    private TextArea AccountText;
    
    @FXML
    private TextArea AccountText2;

    @FXML
    private Button closeButton;

    @FXML
    private Button DepositButton;

   

    @FXML
    private TextField AmountD;

    @FXML
    private TextField inputFirstD;

    @FXML
    private TextField inputLastD;

    @FXML
    private Button WithdrawButton;
    
    //////////////////////Date for the deposit/withdarw tab
    @FXML
    private TextField DayD;
    

    @FXML
    private TextField MonthD;

    @FXML
    private TextField YearD;
 //////////////////////////////////////////////////
    
    //////////////////////////////date for account manager tab
    @FXML
    private TextField DayM;

    @FXML
    private TextField MonthM;

    @FXML
    private TextField YearM;
    
    @FXML
    private TextField AmountM;
/////////////////////////////////////////////////////////////
    String ManagerFirstName;
    String ManagerLastName;
    String DepositFirstName;
    String DepositLastName;
    
    /////Creating printing booleans///////////
    boolean Sprint = false;
    boolean Lprint = false;
    boolean Dprint = false;
    
    ///////////////Day month year//////////////////
    String dayM;
    String monthM;
    String yearM;
    
    String dayD;
    String monthD;
    String yearD;
    
    String amountM;
    String amountD;
    
    ///////////////accoutn radi obuttons booleans
    boolean checking = false;
    boolean saving = false;
    boolean money = false;
    
    boolean checkingD = false;
    boolean savingD = false;
    boolean moneyD = false;
    
    
    @FXML
    /**
     * Write code to read from file
     * @param event
     */
    void importFile(ActionEvent event) throws FileNotFoundException 
    {
    	FileChooser chooser = new FileChooser();
    	chooser.setTitle("Open Source file for import");
    	chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
    		new ExtensionFilter("All Files", "*.txt"));
    	Stage stage = new Stage();
    	File SourceFile = chooser.showOpenDialog(stage);
    	//
    	Scanner scanner = new Scanner(SourceFile);
    	while(scanner.hasNextLine())
    	{
    		String line = scanner.nextLine();
    		String[] cmdArray = line.split(",");
    		
    		if(cmdArray[0].equals("C"))
    		{
	    		first = cmdArray[1];
				last = cmdArray[2];
				try
				{
					amount = Float.parseFloat(cmdArray[3]);
				}
				catch(NumberFormatException e)
				{
					
				}
				
				if(cmdArray[5].toLowerCase().equals("true"))
				{
					loyal = true;
				}
				else if(cmdArray[5].toLowerCase().equals("false"))
				{
					loyal = false;
				}
				else
				{
				}
				
				String[] dateComponents = cmdArray[4].split("/");
				Date accountDate = new Date(Integer.parseInt(dateComponents[0]), Integer.parseInt(dateComponents[1]), Integer.parseInt(dateComponents[2]));
				if(!accountDate.isValid())
				{
					//System.out.println(accountDate + " is not a valid date!");
				}
				
				Checking newChecking = new Checking(new Profile(first,last), amount, accountDate, loyal);
				
				if(database.add(newChecking))
				{
					//System.out.println("Account opened and added to the database.");
				}
				else
				{
					//System.out.println("Account is already in the database.");
				}
    		}
    		else if(cmdArray[0].equals("S"))
    		{
    			first = cmdArray[1];
				last = cmdArray[2];
				try
				{
					amount = Float.parseFloat(cmdArray[3]);
				}
				catch(NumberFormatException e)
				{
					
				}
				
				if(cmdArray[5].toLowerCase().equals("true"))
				{
					loyal = true;
				}
				else if(cmdArray[5].toLowerCase().equals("false"))
				{
					loyal = false;
				}
				else
				{
				}
				
				String[] dateComponents = cmdArray[4].split("/");
				Date accountDate = new Date(Integer.parseInt(dateComponents[0]), Integer.parseInt(dateComponents[1]), Integer.parseInt(dateComponents[2]));
				if(!accountDate.isValid())
				{
					//System.out.println(accountDate + " is not a valid date!");
				}
				
				Savings newChecking = new Savings(new Profile(first,last), amount, accountDate, loyal);
				
				if(database.add(newChecking))
				{
					//System.out.println("Account opened and added to the database.");
				}
				else
				{
					//System.out.println("Account is already in the database.");
				}
    		}
    		else if(cmdArray[0].equals("M"))
    		{
    			first = cmdArray[1];
				last = cmdArray[2];
				try
				{
					amount = Float.parseFloat(cmdArray[3]);
				}
				catch(NumberFormatException e)
				{
					
				}
				
				if(cmdArray[5].toLowerCase().equals("true"))
				{
					loyal = true;
				}
				else if(cmdArray[5].toLowerCase().equals("false"))
				{
					loyal = false;
				}
				else
				{
				}
				
				String[] dateComponents = cmdArray[4].split("/");
				Date accountDate = new Date(Integer.parseInt(dateComponents[0]), Integer.parseInt(dateComponents[1]), Integer.parseInt(dateComponents[2]));
				if(!accountDate.isValid())
				{
					//System.out.println(accountDate + " is not a valid date!");
				}
				
				MoneyMarket newChecking = new MoneyMarket(new Profile(first,last), amount, accountDate);
				
				if(database.add(newChecking))
				{
					//System.out.println("Account opened and added to the database.");
				}
				else
				{
					//System.out.println("Account is already in the database.");
				}
    		}
    	}
    }
    
    
    
    @FXML
    /**
     * Write code to write to file
     * @param event
     */
    void exportFile(ActionEvent event) 
    {
    	FileChooser chooser = new FileChooser();
    	chooser.setTitle("Open Target file to export");
    	chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
    		new ExtensionFilter("All Files", "*.txt"));
    	Stage stage = new Stage();
    	File TargetFile = chooser.showSaveDialog(stage);
    	//

    	
    }
    

    @FXML
    /**
     * first name text field to take input create/close/deposit/withdraw
     * @param event
     */
    void getFirst(ActionEvent event) 
    {
    	ManagerFirstName = inputFirstM.getText();    	
    	DepositFirstName = inputFirstD.getText();
    	
    	
    	//
    }

    @FXML
    /**
     * last name text field to take input create/close/deposit/withdraw
     * @param event
     */
    void getLast(ActionEvent event) 
    {
    	DepositLastName = inputLastD.getText();
    	ManagerLastName = inputLastM.getText();
    	//
    }
    
    @FXML
    /**
     * close account button 
     * @param event
     */
    void AccountClose(ActionEvent event) 
    {
    	if (checking == true)
    	{
    		Checking dummyChecking = new Checking(new Profile(ManagerFirstName,ManagerLastName), amount, new Date(0,0,0), loyal);
    		
    		if(database.remove(dummyChecking))
			{
    			AccountText.setText("Account closed and removed from the database.");
			}
			else
			{
				AccountText.setText("Account does not exist.");
			}
    		
    		//AccountText.setText("Closing checkinga account " + ManagerFirstName + " " + ManagerLastName + " " + dayM + "/" + monthM + "/" + yearM);
    	}
    	else if (saving == true)
    	{
    		Savings dummySavings = new Savings(new Profile(ManagerFirstName,ManagerLastName), amount, new Date(0,0,0), loyal);
    		
    		if(database.remove(dummySavings))
			{
    			AccountText.setText("Account closed and removed from the database.");
			}
			else
			{
				AccountText.setText("Account does not exist.");
			}
    		
    		//AccountText.setText("Closing saving account " + ManagerFirstName + " " + ManagerLastName + " " + dayM + "/" + monthM + "/" + yearM);
    	}
    	else if (money == true)
    	{
    		MoneyMarket dummyMM = new MoneyMarket(new Profile(ManagerFirstName,ManagerLastName), amount, new Date(0,0,0));
    		
    		if(database.remove(dummyMM))
			{
    			AccountText.setText("Account closed and removed from the database.");
			}
			else
			{
				AccountText.setText("Account does not exist.");
			}
    		
    		//AccountText.setText("Closing money market account " + ManagerFirstName + " " + ManagerLastName + " " + dayM + "/" + monthM + "/" + yearM);
    	}
    	else
    		AccountText.setText("Please select an account type");
    	//AccountText.setText("Closing Account " + ManagerFirstName + " " + ManagerLastName + " " + dayM + "/" + monthM + "/" + yearM);
    	//
    }

    @FXML
    void AccountCreation(ActionEvent event) 
    {
    	if (checking == true)
    	{
    		try
			{
				amount = Float.parseFloat(amountM);
				

	    		if(checkDD.isSelected())
	    		{
	    			loyal2 = true;
	    		}
	    		else
	    		{
	    			loyal2 = false;
	    		}
	    		
	    		Date accountDate = new Date(Integer.parseInt(monthM), Integer.parseInt(dayM), Integer.parseInt(yearM));
	    		if(!accountDate.isValid())
				{
	    			AccountText.setText(accountDate + " is not a valid date!");
				}
	    		else
	    		{
		    		Checking newChecking = new Checking(new Profile(ManagerFirstName,ManagerLastName), amount, accountDate, loyal2);
		    		
		    		if(database.add(newChecking))
					{
						AccountText.setText("Account opened and added to the database.");
					}
					else
					{
						AccountText.setText("Account is already in the database.");
					}
	    		}
			}
			catch(NumberFormatException e)
			{
				AccountText.setText("Input data type mismatch.");
			}
    		
    		
    		//AccountText.setText("New checkinga account " + ManagerFirstName + " " + ManagerLastName + " " + dayM + "/" + monthM + "/" + yearM);
    	}
    	else if (saving == true)
    	{
    		try
			{
				amount = Float.parseFloat(amountM);
				

	    		if(checkLoyal.isSelected())
	    		{
	    			loyal2 = true;
	    		}
	    		else
	    		{
	    			loyal2 = false;
	    		}
	    		
	    		Date accountDate = new Date(Integer.parseInt(monthM), Integer.parseInt(dayM), Integer.parseInt(yearM));
	    		if(!accountDate.isValid())
				{
	    			AccountText.setText(accountDate + " is not a valid date!");
				}
	    		else
	    		{
		    		Savings newSavings = new Savings(new Profile(ManagerFirstName,ManagerLastName), amount, accountDate, loyal2);
		    		
		    		if(database.add(newSavings))
					{
						AccountText.setText("Account opened and added to the database.");
					}
					else
					{
						AccountText.setText("Account is already in the database.");
					}
	    		}
			}
			catch(NumberFormatException e)
			{
				AccountText.setText("Input data type mismatch.");
			}
    		
    		
    		//AccountText.setText("New saving account " + ManagerFirstName + " " + ManagerLastName + " " + dayM + "/" + monthM + "/" + yearM);
    	}
    	else if (money == true)
    	{
    		try
			{
				amount = Float.parseFloat(amountM);
	    		
	    		Date accountDate = new Date(Integer.parseInt(monthM), Integer.parseInt(dayM), Integer.parseInt(yearM));
	    		if(!accountDate.isValid())
				{
	    			AccountText.setText(accountDate + " is not a valid date!");
				}
	    		else
	    		{
		    		MoneyMarket newMM = new MoneyMarket(new Profile(ManagerFirstName,ManagerLastName), amount, accountDate);
		    		
		    		if(database.add(newMM))
					{
						AccountText.setText("Account opened and added to the database.");
					}
					else
					{
						AccountText.setText("Account is already in the database.");
					}
	    		}
			}
			catch(NumberFormatException e)
			{
				AccountText.setText("Input data type mismatch.");
			}
    		
    		//AccountText.setText("New money market account " + ManagerFirstName + " " + ManagerLastName + " " + dayM + "/" + monthM + "/" + yearM);
    	}
    	else
    		AccountText.setText("Please select an account type");
    	//AccountText.setText("New Account " + ManagerFirstName + " " + ManagerLastName + " " + dayM + "/" + monthM + "/" + yearM);
    	//
    }
    
    @FXML
    /**
     * Deposit button
     * @param event
     */
    void Deposit(ActionEvent event) 
    {
    	if(checkingD == true)
    	{
	    	try
			{
				amount = Float.parseFloat(amountD);
				
				Checking dummyChecking = new Checking(new Profile(DepositFirstName,DepositLastName), amount, new Date(0,0,0), loyal);
				
				if(database.deposit(dummyChecking, amount))
				{
					AccountText2.setText(amount + " deposited to account.");
				}
				else
				{
					AccountText2.setText("Account does not exist.");
				}
			}
			catch(NumberFormatException e)
			{
				AccountText2.setText("Input data type mismatch.");
			}
    	}
    	else if(savingD == true)
    	{
    		try
			{
				amount = Float.parseFloat(amountD);
				
				Savings dummySavings = new Savings(new Profile(DepositFirstName,DepositLastName), amount, new Date(0,0,0), loyal);
				
				if(database.deposit(dummySavings, amount))
				{
					AccountText2.setText(amount + " deposited to account.");
				}
				else
				{
					AccountText2.setText("Account does not exist.");
				}
			}
			catch(NumberFormatException e)
			{
				AccountText2.setText("Input data type mismatch.");
			}
    	}
    	else if(moneyD == true)
    	{
    		try
			{
				amount = Float.parseFloat(amountD);
				
				MoneyMarket dummyMM = new MoneyMarket(new Profile(DepositFirstName,DepositLastName), amount, new Date(0,0,0));
				
				if(database.deposit(dummyMM, amount))
				{
					AccountText2.setText(amount + " deposited to account.");
				}
				else
				{
					AccountText2.setText("Account does not exist.");
				}
			}
			catch(NumberFormatException e)
			{
				AccountText2.setText("Input data type mismatch.");
			}
    	}
    	else
    	{
    		AccountText2.setText("Please select an account type.");
    	}

    }

    @FXML
    /**
     * withdraw button
     * @param event
     */
    void Withdraw(ActionEvent event) 
    {
    	if(checking == true)
    	{
    		try
			{
				amount = Float.parseFloat(amountD);
				
				Checking dummyChecking = new Checking(new Profile(DepositFirstName,DepositLastName), amount, new Date(0,0,0), loyal);
				
				int withdrawResult = database.withdrawal(dummyChecking, amount);
				if(withdrawResult == 0)
				{
					AccountText2.setText(amount + " withdrawn from the account.");
				}
				else if(withdrawResult == 1)
				{
					//if withdraw is over total account amount
					AccountText2.setText("Insufficient funds.");
				}
				else if(withdrawResult == -1)
				{
					AccountText2.setText("Account does not exist.");
				}
			}
			catch(NumberFormatException e)
			{
				AccountText2.setText("Input data type mismatch.");
			}
			
			
    	}
    	else if(saving == true)
    	{
    		try
			{
				amount = Float.parseFloat(amountD);
				
				Savings dummySavings = new Savings(new Profile(DepositFirstName,DepositLastName), amount, new Date(0,0,0), loyal);
				
				int withdrawResult = database.withdrawal(dummySavings, amount);
				if(withdrawResult == 0)
				{
					AccountText2.setText(amount + " withdrawn from the account.");
				}
				else if(withdrawResult == 1)
				{
					//if withdraw is over total account amount
					AccountText2.setText("Insufficient funds.");
				}
				else if(withdrawResult == -1)
				{
					AccountText2.setText("Account does not exist.");
				}
			}
			catch(NumberFormatException e)
			{
				AccountText2.setText("Input data type mismatch.");
			}
    	}
    	else if(money == true)
    	{
    		try
			{
				amount = Float.parseFloat(amountD);
				
				MoneyMarket dummyMM = new MoneyMarket(new Profile(DepositFirstName,DepositLastName), amount, new Date(0,0,0));
				
				int withdrawResult = database.withdrawal(dummyMM, amount);
				if(withdrawResult == 0)
				{
					AccountText2.setText(amount + " withdrawn from the account.");
				}
				else if(withdrawResult == 1)
				{
					//if withdraw is over total account amount
					AccountText2.setText("Insufficient funds.");
				}
				else if(withdrawResult == -1)
				{
					AccountText2.setText("Account does not exist.");
				}
			}
			catch(NumberFormatException e)
			{
				AccountText2.setText("Input data type mismatch.");
			}
    	}
    	else
    	{
    		AccountText2.setText("Please select an account type.");
    	}
    	
    }

    @FXML
    /**
     * Amount textfield for deposit/withdraw
     * @param event
     */
    void SelectAmount(ActionEvent event) 
    {
    	
    }

    @FXML
    /**
     * radio button for checking account create/close
     * @param event
     */
    void SelectChecking(ActionEvent event) 
    {
    	checkLoyal.setDisable(true);
    	checkLoyal.setSelected(false);
    	checkDD.setDisable(false);
    	checking = true;
    	saving = false;
    	money = false;
    	
    	
    }
   
    @FXML
    /**
     * radio button for money market account create/close
     * @param event
     */
    void SelectMoneyMarket(ActionEvent event) 
    {
    	checkDD.setDisable(true);
    	checkDD.setSelected(false);
    	checkLoyal.setDisable(true);
    	checkLoyal.setSelected(false);
    	checking = false;
    	saving = false;
    	money = true;
    	
    	
    	
    }

    @FXML
    /**
     * radio button for savings account create/close
     * @param event
     */
    void SelectSavings(ActionEvent event) 
    {    	
    	checkLoyal.setDisable(false);
    	checkDD.setDisable(true);
    	checkDD.setSelected(false);
    	checking = false;
    	saving = true;
    	money = false;
    	
  
    	//checkLoayal.setDisable(true);
    	
    	
    }
    
    @FXML
    /**
     * radio button for checking account create/close
     * @param event
     */
    void SelectCheckingD(ActionEvent event) 
    {
    	checkingD = true;
    	savingD = false;
    	moneyD = false;
    	
    	
    }
   
    @FXML
    /**
     * radio button for money market account create/close
     * @param event
     */
    void SelectMoneyMarketD(ActionEvent event) 
    {
    	checkingD = false;
    	savingD = false;
    	moneyD = true;
    	
    	
    	
    }

    @FXML
    /**
     * radio button for savings account create/close
     * @param event
     */
    void SelectSavingsD(ActionEvent event) 
    {
    	checkingD = false;
    	savingD = true;
    	moneyD = false;
    	
  
    	//checkLoayal.setDisable(true);
    	
    	
    }
   
    
    @FXML
    /**
     * checkbox for Direct Deposit in create
     * @param event
     */
    void checkDD(ActionEvent event) 
    {
    	
    	
    }

    @FXML
    /**
     * checkbox for loyalty in create
     * @param event
     */
    void checkLoyal(ActionEvent event) 
    {
    	
    	
    }
 
//////////////////////////////////Printing radio buttons methods
    @FXML
    /**
     * Print button
     * @param event
     */
    void clickPrint(ActionEvent event) 
    {
    	if(Dprint == true)
    	{
    		//printByDateOpen(data);
    		if(database.getSize() > 0)
			{
    			PrintText.setText("--Printing statements by data opened--\n\n" + database.printByDateOpen());
			}
			else
			{
				PrintText.setText("Database is empty.");
			}
    	}
    	else if(Lprint == true)
    	{
    		//printByLastName(data);
    		if(database.getSize() > 0)
			{
    			PrintText.setText("--Printing statements by last name--\n\n" + database.printByLastName());
			}
			else
			{
				PrintText.setText("Database is empty.");
			}
    	}
    	else
    	{
    		//printAccounts(data);
    		if(database.getSize() > 0)
			{
				PrintText.setText("--Listing accounts in the database--\n" + database.printAccounts() + "--end of listing--\n");
			}
			else
			{
				PrintText.setText("Database is empty.");
			}
    	}
    	
    }

    @FXML
    /**
     * Standard print radio button
     * @param event
     */
    void selectPrint(ActionEvent event) 
    {
    	Sprint = true;
    	Dprint = false;
    	Lprint = false;
    	
    	
    }

    @FXML
    /**
     * Printing by date created radio button
     * @param event
     */
    void selectPrintDate(ActionEvent event) 
    {
    	Dprint = true;
    	Sprint = false;
    	Lprint = false;
    	
    	
    }

    @FXML
    /**
     * printing by last name radio button
     * @param event
     */
    void selectPrintLast(ActionEvent event) 
    {
    	Lprint = true;
    	Dprint = false;
    	Sprint = false;
    	//
    }
///////////////////////////////////////////////////////////    
    
    
    
    @FXML
    /**
     * date text field
     * @param event
     */
    void inputDay(ActionEvent event) 
    {
    	dayM = DayM.getText();
    }

    @FXML
    /**
     * month text field
     * @param event
     */
    void inputMonth(ActionEvent event) 
    {
    	monthM = MonthM.getText();

    }

    @FXML
    /**
     * year text field
     * @param event
     */
    void inputYear(ActionEvent event) 
    {
    	yearM = YearM.getText();

    }
    ////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void inputAmount(ActionEvent event)
    {
    	amountM = AmountM.getText();
    }

    @FXML
    void inputAmountD(ActionEvent event)
    {
    	amountD = AmountD.getText();
    }
 

    @FXML
    /**
     * This method is called by the FXMLLoader when initialization is complete 
     */
    void initialize() 
    {
    	
    	ToggleGroup ManagerGroup = new ToggleGroup();
    	SrbM.setToggleGroup(ManagerGroup);
    	MMrbM.setToggleGroup(ManagerGroup);
    	CrbM.setToggleGroup(ManagerGroup);
    	
    	ToggleGroup ManagerGroup2 = new ToggleGroup();
    	SrbD.setToggleGroup(ManagerGroup2);
    	MMrbD.setToggleGroup(ManagerGroup2);
    	CrbD.setToggleGroup(ManagerGroup2);
    	
    	ToggleGroup PrintGroup = new ToggleGroup();
    	PrintLNrb.setToggleGroup(PrintGroup);
    	PrintSrb.setToggleGroup(PrintGroup);
    	PrintDOrb.setToggleGroup(PrintGroup);
    	
    	
    }
}
