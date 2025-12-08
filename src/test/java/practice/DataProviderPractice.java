package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void addProductToCart(String brand, int price, int quantity, String model)
	{
		System.out.println("Brand:"+brand+"  Price:"+price+"  Quantity:"+quantity+"  Model:"+model);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = new Object[3][4];
		
		data[0][0] = "Iphone";
		data[0][1] = 100000;
		data[0][2] = 25;
		data[0][3] = "16Pro";
		
		data[1][0] = "Samsung";
		data[1][1] = 80000;
		data[1][2] = 50;
		data[1][3] = "S25";
		
		data[2][0] = "Nothing";
		data[2][1] = 50000;
		data[2][2] = 75;
		data[2][3] = "Phone3";
		
		return data;
	}
	
	
	
}
