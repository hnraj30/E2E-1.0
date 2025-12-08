package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	@Test(priority = 3, invocationCount = 2, enabled = true)
	public void create()
	{
		System.out.println("CREATE");
	}
	
	@Test(priority = 2,dependsOnMethods = "delete")
	public void modify()
	{
		System.out.println("MODIFY");
	}
	
	@Test(priority = -3)
	public void delete()
	{
		Assert.fail();
		System.out.println("DELETE");
	}

}
