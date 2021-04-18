package BasicGoogleTest;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Listeners(generics.TestNG_Listeners.class)
public class GoogleWord_Test extends Base
{
	//no need to declare WebDriver reference here as it is picked from static webdriver reference from Base Class
	@BeforeTest
	public void setup() throws IOException 
	{
		Base.Initialize();
	}	


	@Test//(retryAnalyzer=RetryLogic.RetryAnalyzer.class)  //call RetryAnalyzer at test level
	public void T1_SearchWord() throws InterruptedException{
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Wiki");
		Thread.sleep(500);
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();

		System.out.println("In P1 method");
	}



	@Test//(retryAnalyzer=RetryLogic.RetryAnalyzer.class) //call RetryAnalyzer at test level
	public void T2_ClickOnWikiLink() throws InterruptedException{
		//Click on 1st result link
		Assert.assertEquals(true, true);
		driver.findElement(By.xpath("//h3[contains(text(),'Wiki - Wikipedia')]")).click();
		System.out.println("In P2 method");

		//Extra: to print all files/folders present in a directory----can be used to check if files are downloaded or not in runtime.
		File file =new File(System.getProperty("user.dir")+"//src//test//java//generics");
		String []liStDir= file.list();
		System.out.println("number of files/folder present in dir= "+liStDir.length);

		for(int i=0; i<liStDir.length; i++)	{
			//print all files/folders present in given dir
			System.out.println(liStDir[i]);
			//check if specific file/folder is present in given dir
			if(liStDir[i].equals("Screenshots.java")){
				System.out.println("Screenshots.java is present in this dir");
			}
		}

	}


	@Test//(retryAnalyzer=RetryLogic.RetryAnalyzer.class) //call RetryAnalyzer at test level
	public void T3_VerifyTextOnPage() throws InterruptedException{

		Assert.assertEquals(true, false);
		//Click on main page link after that website loads
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Main page')]")).click();
		System.out.println("In P3 method----->Assert is susscessfully");

	}

}