package com.main;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test123 {
	static WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest(groups = {"Smoke","Reg"})
	public void initializeDriver()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@DataProvider(name="getAlertName")
	public Object[][] getData()
	{
		Object[][] data = {{"Nami" },{"Shiv"}};
		return data;
	}
	
	@Test(dataProvider = "getAlertName", groups="Reg")
	public void AlertCheck(String Name) throws InterruptedException
	{
	
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(Name);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertText);
		
	}
	
	@Test(groups = "Smoke", invocationCount = 1)
	public void CheckBox()
	{
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		boolean checkbox1 = driver.findElement(By.id("checkBoxOption1")).isSelected();
		if(checkbox1 == false)
			driver.findElement(By.id("checkBoxOption")).click();
		else
			System.out.println("Checkbox1 is already selected");
	}
	
	@Test(groups = {"Smoke","Reg"})
	@Parameters("Name")
	public void paramTest(String Name)
	{
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Printing Title for :"+Name);
		System.out.println(driver.getTitle());
	}
	
	
	@Test(enabled = true, groups = "Reg")
	public void AutoSuggesstions() throws InterruptedException, IOException
	{
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("IND");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='ui-menu-item']/div"))));
		//Thread.sleep(2000);
		
		List<WebElement> li = driver.findElements(By.xpath("//*[@class='ui-menu-item']/div"));
		Iterator<WebElement> ir = li.iterator();
		System.out.println("Suggestions Size : "+li.size());
		
		while(ir.hasNext())
		{
			WebElement suggestion = ir.next();
			if(suggestion.getText().equalsIgnoreCase("India"))
			{
				suggestion.click();
				break;
			}
		}
		
	}

	
	@AfterTest(groups = {"Smoke","Reg"})
	public void tearDown()
	{
		driver.quit();
	}

}
