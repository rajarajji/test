package Flipkart.TaskFeature;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
	@Test
	public void assertion() throws InterruptedException {

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");
		
		WebElement emailId = driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]"));
		emailId.sendKeys("rajaraj@gmail.com");
		
		driver.findElement(By.xpath("//button[.='Request OTP']")).click();
		Thread.sleep(2000);
		
		WebElement mobNo = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		mobNo.sendKeys("8595093014");
		
		driver.findElement(By.xpath("//button[.='✕']")).click();
		driver.findElement(By.xpath("//img[@alt='Mobiles']")).click();

		WebElement electronics = driver.findElement(By.xpath("//span[.='Electronics']"));

		Actions act = new Actions(driver);
		act.moveToElement(electronics).perform();

		driver.findElement(By.xpath("//a[.='Soundbars']")).click();

		driver.findElement(By.xpath("(//a[@class='s1Q9rs'])[4]")).click();

		Set<String> windowId = driver.getWindowHandles();

		ArrayList<String> al = new ArrayList<String>(windowId);
		driver.switchTo().window(al.get(1));

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();

		driver.findElement(By.xpath("//span[.='Place Order']")).click();

		WebElement emailId1 = driver.findElement(By.xpath("//input[@maxlength='auto']"));
		emailId1.sendKeys("raj@gm.c");

		driver.findElement(By.xpath("//span[.='CONTINUE']")).click();

		String expect = "Please enter valid Email ID/Mobile number";

		String actual_msg = driver.findElement(By.xpath("//span[@class='_2YULOR']")).getText();
		System.out.println(actual_msg);

		Assert.assertEquals(actual_msg, expect);

	}
}

