package assignment03;
/**
 * This program is going to get a file from the user and check through the file
 * and verifies if the financial summary is correct. There are four methods inside
 * this program: one main method and three helper method. Recursion is the main idea
 * to create this program and code.
 * 
 * @author Yingjie Lian	
 * @version 02/01/2017
 * @class CS-1410
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DataCheck 
{
	public static void main(String[] args) 
	{	
		// Declare a JFileChooser variable.
		JFileChooser chooser = new JFileChooser();

		// Set a dialog title to prompt user to choose a financial data.
		chooser.setDialogTitle("Please select a financial data file.");

		// Declare a "int" variable because we are going to use a 
		// JFileChooser.CANCEL_OPTION and to call that method, the 
		// variable must be "int" type. JFileChooser.CANCEL_OPTION will
		// function when cancel opening a dialog it will terminate the program.
		int result;

		// Open a dialog for user to choose a file.
		result = chooser.showOpenDialog(null);

		// Check if user cancel the chooser.
		if (result == JFileChooser.CANCEL_OPTION)
		{
			// User cancelled the chooser.
			return;
		}

		// Create a file to store the data file selected by the user
		File inputFile;
		inputFile = chooser.getSelectedFile();
		JOptionPane.showMessageDialog(null, "You chose: " + inputFile);

		try 
		{
			// Create a scanner and calls a helper method
			Scanner in = new Scanner(inputFile);
			scanNextTransaction(in);
			JOptionPane.showMessageDialog(null, "The financial data of this file is correct!");
		}
		// User try-catch to check if there is an error when run the code
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "Could not read the file: " +
					inputFile);
		}

	}
	/**
	 * This method scans the next word (a dollar amount) as a string, translates 
	 * it into a double, and returns the double.  It assumes the scanned word 
	 * is a money value (starting with a dollar sign).  I use this method whenever 
	 * I need to read a money value from the file.
	 * @param s
	 * @return money
	 */
	public static double scanMoneyValue(Scanner s)
	{
		// Creat a string to store the money value with dollor sign
		String word = s.next();
		// Remove $ sign
		String deleteSign = word.substring(1);
		// Converts "string" to "double"
		double money = Double.parseDouble(deleteSign);
		// Return the moeny value as a double in order to compare the value
		// to other money values.
		return money;
	}

	/**
	 * This method assumes the Scanner is positioned such that it is about 
	 * to read in a transaction from the file.  It reads the first word of
	 * a transaction.  If it is a buy or sell, it reads the date and money
	 * value, and returns the money value to the caller.  If it is a sub-summary, 
	 * it uses a helper method to read in the remainder of the whole sub-summary, 
	 * and then it returns the recorded value of the sub-summary to the caller.
	 * @param s
	 * @return value
	 */
	public static double scanNextTransaction(Scanner s)
	{
		//Initialize a double value.
		double value = 0;
		//Create a string to store the next string in the file.
		String checkWord = s.next();
		// Check if the string is "BUY", "SELL" , or "SUMMARY"
		if (checkWord.equals("BUY") || checkWord.equals("SELL"))
		{
			// Scan the date and store it
			String date = s.next();
			// Scan the value and use a helper method to vonvert it to a 
			// double, then store it
			value = scanMoneyValue(s);
		}
		// If the string is "SUMMARY" then run the next code
		else
		{
			value = scanSubSummary(s);
		}
		// Return the money value of the next transaction as a "double".
		return value;
	}

	/**
	 * This method finishes reading a sub-summary.  (It assumes that the word "SUMMARY" 
	 * has already been read, but that none of the rest of the summary has been read.)  
	 * It reads the values for the summary, and then it reads and sums up the appropriate 
	 * number of transactions.  If the summary value does not match the sum of the transactions,
	 * an error is displayed and the application quits.  Otherwise, the value recorded in the summary 
	 * is returned.
	 * @param s
	 * @return summaryValue
	 */
	public static double scanSubSummary(Scanner s)
	{ 
		// Store the remainder of the SUMMARY which are date, moneyValue, and 
		// transaction times.
		String summaryDate = s.next();
		double summaryValue = scanMoneyValue(s);
		int transactions = s.nextInt();
		// Add the values of sub-summaries
		double amount = 0;
		// Add all the value of sub-transaction within a summary
		while (transactions > 0)
		{
			double subSummary = scanNextTransaction(s); 
			// Add the next transaction to the previous one until
			// matched the transaction times. For example, if
			// transaction times is 4, this loop will run 4 times.
			amount = amount + subSummary;
			transactions--;
		}
		// Verify if the summary value is equal to the amount value of its transactions
		if (Math.abs(summaryValue - amount) >= 1e-10)
		{
			// Convert double to a string format with 2 decimal places.
			String convertDouble = String.format("%.2f", amount);
			// If the Summary and Transactions are not equal, it will print a message
			// within a dialog box with the date and amount.
			JOptionPane.showMessageDialog(null, "Summary error on " + summaryDate + ". \nAmount is " 
					+ summaryValue + ", should be " + convertDouble + ".");
			// Rudely terminate the program.
			System.exit(0);
		}
		// If there are all equal, return the summaryValue.
		return summaryValue;
	}
}

