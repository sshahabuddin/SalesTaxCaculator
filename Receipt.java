//Author: Saqib Shahabuddin 
//Email: sts.shahabuddin@gmail.com 
//Name of File: Receipt.java
//Last Revised: 9/26/2019 
//Referances: None 

package sales; 

import java.util.*;
import java.text.DecimalFormat;

//Receipt class inherits from ItemInfo class 
public class Receipt extends ItemInfo
{
	final static double SALES_TAX = 0.10;
	
	final static double IMPORT_TAX = 0.05;

	
	//A list of ItemInfo 
	protected List<ItemInfo> itemsList = new ArrayList<>();

	//The total sales tax for the entire itemsList
	private double salesTax;
	//The total sales tax plus the price of the items
	private double totalPrice;
	
	//Consructor inializes salesTax and totalPrice 
	//Input: None
	//Return Value: None 
	Receipt()
	{ 
		salesTax = 0.0; 
		totalPrice = 0.0; 
	}

	void addList(List<ItemInfo> newItemsList)
	{
		itemsList = newItemsList;
	}
	
	void resetValues()
	{
		salesTax = 0.0; 
		totalPrice = 0.0; 
	}
	
	//Function calculates the salesTax of all the items and the totalPrice 
	//Input: None 
	//Return Value: None 
	void calculateTaxes()
	{
		
		for (ItemInfo temp : itemsList)
		{
			
	    	String name = temp.getName();
	    	double price = temp.getPrice();
	    	int quantity = temp.getQuantity();
	    		    		    	
	    	totalPrice += price; 

	    	
			if(temp.getImportStatus())
			{
				salesTax += price * IMPORT_TAX;
			}
	     
			
	    	if(name.indexOf("chocolate") == -1 && name.indexOf("book") == -1 && name.indexOf("pill") == -1)
			{
				salesTax += (quantity * price) * SALES_TAX;
			}
	    }
		
		salesTax = Math.ceil(salesTax * 20) / 20.0;
	    totalPrice += salesTax;
	}
	
	
	
	//Function prints out the itemsList along with the salesTax and totalPrice
	//Input: None 
	//Return Value: None 
	void printReceipt()
	{ 
	
		DecimalFormat decFor = new DecimalFormat("0.00");

        
		
		for (ItemInfo temp : itemsList)
		{
	    	System.out.println(temp.getQuantity() + " " +  temp.getName() + ": " + temp.getPrice()); 
	    }
			    
		System.out.println("Sales Tax: " + decFor.format(salesTax)); 
		System.out.println("Total: " + decFor.format(totalPrice));
	    
	}


}
