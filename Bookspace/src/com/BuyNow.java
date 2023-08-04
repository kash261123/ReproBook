package com;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

class Credential{
	//Credential
	String myNum = "9821371243";
	String password="Adobe@2112";
	String UPI ="anything@payu";
	public void isLoading() throws InterruptedException {
		Thread.sleep(3000);
	}
	public void isLoading(int wait) throws InterruptedException {
		Thread.sleep(wait);
	}
}

public class BuyNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		//creating object for accesing methods and data
		Credential c= new Credential();
		
		
		//declaring webdriver
		WebDriver driver = new ChromeDriver();
		
		
		//Navigate
		driver.get("https://uat.bookscape.com/");
		driver.manage().window().maximize();
		c.isLoading();
		
		
		//Signin
		driver.findElement(By.xpath("//button[text()=\"SIGN IN\"]")).click();
		c.isLoading();
		
		
		//details enter
		driver.findElement(By.xpath("//input[@placeholder=\"Email Address or Phone Number\"]")).sendKeys(c.myNum);
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(c.password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()=\"SIGN IN\"]")).click();
		
		
		//Payment window with default UPI id
		c.isLoading();
		driver.findElement(By.xpath("//div[text()=\"Excel in Your Next Exam Bundle 4\"]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[5]/button[1]")).click();
		c.isLoading();
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your UPI ID\"]")).sendKeys(c.UPI);
		driver.findElement(By.xpath("//button[text()=\"VERIFY AND PAY\"]")).click();
		
		
		//Redirect scenario
		c.isLoading(5000);
		driver.findElement(By.linkText("click")).click();
		
		
		//switch tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//input[@value=\"Simulate Success transaction\"]")).click();
		c.isLoading();
		driver.findElement(By.xpath("//button[text()=\"GOT IT\"]")).click();
		ArrayList<String> oldtabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(oldtabs.get(0));
		
		
		//waiting untill procced the payment
		c.isLoading(30000);
		
		
		//capturing payment result
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\kashs\\eclipse-workspace\\Bookspace\\Screenshots\\ordersuccessfull.jpg"));
				//order Succesfull
		}

}