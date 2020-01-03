//Author: Saqib Shahabuddin 
//Email: sts.shahabuddin@gmail.com 
//Name of File: ItemInfo.java
//Last Revised: 9/26/2019 
//Referances: None 

package sales; 


//A class that has all the information of the item being purchased 
public class ItemInfo
{
	//The number of things being bought
	private int quantity;
	//If the item is imported the value will be true, otherwise it will be false
	private boolean importStatus;
	//The name of the item
	private String name;
	//The price of the item
	private double price;
	
	//Constructor intializes quantity, imported, name, and price
	//Input: None 
	//Return Value: None
	ItemInfo()
	{ 
		quantity = 0;
		importStatus = false; 
		name = ""; 
		price = 0.0; 
	}

	//Setter for quantity
	//Input: The quantity of item bought  
	//Return Value: None
	void setQuantity(int newQuantity)
	{
		quantity = newQuantity;
	}

	//Getter for quantity
	//Input: None  
	//Return Value: The quantity of items bought
	int getQuantity()
	{
		return quantity;
	}

	//Setter for imported
	//Input: If the item was imported (true or false)   
	//Return Value: None
	void setImportStatus(boolean newStatus)
	{
		importStatus = newStatus;
	}

	//Getter for imported
	//Input: None
	//Return Value: If the item was imported (true or false) 
	boolean getImportStatus()
	{
		return importStatus;
	}

	//Setter for name
	//Input: The name of the item
	//Return Value: None
	void setName(String newName)
	{
		name = newName;
	}
	
	//Getter for imported
	//Input: The name of the item
	//Return Value: None
	String getName()
	{
		return name;
	}

	//Setter for imported
	//Input: The price of the item
	//Return Value: None
	void setPrice(double newPrice)
	{
		price = newPrice;
	}

	//Setter for imported
	//Input:  None
	//Return Value: The price of the item
	double getPrice()
	{
		return price;
	}
}
