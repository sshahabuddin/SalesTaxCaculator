//Author: Saqib Shahabuddin 
//Email: sts.shahabuddin@gmail.com 
//Name of File: SalesTax.java
//Last Revised: 9/26/2019 
//Referances: None 

package sales;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//A class that reads input from the text files
public class SalesTax 
{
	//Function reads input from a specified text file that is saved to a string
	//Input: None 
	//Return Value: The string that is saved from the text file 
	 public static List<String> readTextFile(String fileName) throws FileNotFoundException
	 {
		 List<String> listString = new ArrayList<String>();
		 try
		 {
			 Scanner scanner = new Scanner(new File(fileName));
			 while (scanner.hasNextLine()) 
			 {
				 listString.add(scanner.nextLine()); 
			 }
		 }
		 
		 catch (FileNotFoundException e)
		 {
			 System.out.println("File not found."); 
		 }
		 
		
		return listString;
	 }
	 

	 //Function parses the string from the text file and saves the information 
	 //Input: A list of string, each string represents a line from the textfile 
	 //Return Value: None 
	 public static List<ItemInfo> processString(List<String> allLines) 
	 {
		List<ItemInfo> items = new ArrayList<>();
		
		
		for (String line : allLines) 
		{ 
			ItemInfo temp = new ItemInfo();
			
			if(!Character.isLetter(line.charAt(0)))
			{
				temp.setQuantity(Character.getNumericValue(line.charAt(0)));
			}
			
			temp.setName(line.substring(2, line.indexOf(" at")));
			
			if(line.indexOf("imported") != -1)
			{
				temp.setImportStatus(true);
			}
			 
			else 
			{
				temp.setImportStatus(false);
			}
				 
			double price = Double.parseDouble(line.substring(line.indexOf(" at") + 4, line.length()));
			temp.setPrice(price);
			
			items.add(temp);
		}
		
		return items; 
	 }

	//Main function is where all the functions that are called that needed to be excuted 
	//Input: String[] args
	//Return Value: None
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner input = new Scanner(System.in);
		Receipt receipt = new Receipt();
		String userAnswer = "";
		String nameFile = "";
		boolean doOver = false;  
		boolean error = false; 

		do { 
			System.out.print("Enter the name of the text file:");

	    	nameFile = input.next();
			
	    	List<String> inputStrings = readTextFile(nameFile);
		
	    	if(processString(inputStrings) != null)
	    	{
	    		receipt.addList(processString(inputStrings));
		
		
	    		receipt.calculateTaxes();
		
		
	    		receipt.printReceipt();
	    		
	    		receipt.resetValues();
	    	} 
	    	
			do {
				System.out.print("Would you like to enter another file name? (Yes/No)");
	
		    	userAnswer = input.next();
		    	userAnswer = userAnswer.toLowerCase();
		    	
		    	if(userAnswer.compareTo("yes") == 0)
		    	{ 
		    		doOver = true; 
		    		error = false;
		    	}
		    	
		    	else if(userAnswer.compareTo("no") == 0)
		    	{ 
		    		doOver = false; 
		    		error = false;
		    	}
		    	
		    	else
		    	{ 
		    		System.out.println("Invalid input. Please try again");
		    		error = true; 
		    	}
			}while(error);
		}while(doOver); 
		
	}
}

