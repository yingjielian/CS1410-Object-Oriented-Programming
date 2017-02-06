package lab04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class VerifyFileStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFileChooser chooser;
		chooser = new JFileChooser();
		chooser.setDialogTitle("Which file would you like to verify?");
//		chooser.showOpenDialog(null);
		int result;
		result = chooser.showOpenDialog(null);

		if (result == JFileChooser.CANCEL_OPTION)
		{
			// User cancelled the chooser.
			return;
		}

		File inputFile;
		inputFile = chooser.getSelectedFile();
		System.out.println ("You chose: " + inputFile);

		// Create the scanner, read the file, print out the words, and close the scanner/file.

		try
		{
			Scanner in = new Scanner(inputFile);  // Scan through the input file that the user chose.

			while (in.hasNext())
			{
				String word = in.next();
				if (isOpeningTag(word))
				{
					String name = word.substring(1);  // Extract the tag name.
					findClosingTag(in, name);  // Use the helper method to find the closing tag.
				}
			}

			System.out.println ("File verified OK.");

			in.close();
		}
		catch (IOException e)
		{
			System.out.println("Could not read the file: " + inputFile);
		}

	}
	/**
	 * Returns true if the parameter string represents an opening tag,
	 * such as "<name", or false otherwise.
	 *   
	 * @param s Any string
	 * @return true if the string is an opening tag.
	 */
	public static boolean isOpeningTag (String s)
	{
		if (s.length() >= 2 && s.startsWith("<") && s.charAt(1) != '/')
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isClosingTag (String s)
	{
		if (s.length() >= 2 && s.startsWith("<") && s.charAt(1) == '/')
			return true;
		else 
			return false;
	}

	/** This method is intentionally missing it's contract.  Can you see what it does?
	 * (You may want to add this contract later!)
	 */
	public static void findClosingTag (Scanner s, String openName)
	{
		// Loop as long as there are words in the file.

		while (s.hasNext())
		{
			// Get the next word.

			String word = s.next();

			// If it is an opening tag, check it further.

			if (isOpeningTag(word))
			{
				String name = word.substring(1);  // Extract the tag name.
				findClosingTag(s, name);  // Use the helper function to find the closing tag.
			}  

			if (isClosingTag(word))
			{
				// Extract the name from the tag.

				String closeName = word.substring(2);

				// Make sure the closing tag name matches the opening tag name.

				if (closeName.equals(openName))
					return;  // We're done looking for a closing tag, success.
				else
				{
					System.out.println ("Closing tag " + closeName + " does not match opening tag " + openName + ".");
					System.exit(0);  // Rudely exits the application immediately.
				}
			}

			// End of loop, go back and read another word.
		}

		// If we get here, there was nothing else to scan in the file.

		System.out.println ("Could not find closing tag for tag " + openName + ".");
		System.exit(0);  // Rudely exits the application immediately.
	}
}


