package Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class automation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String baseUrl = "https://www.phptravels.net/home";
		
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
		
		//click on tours
		driver.findElement(By.xpath("//a[normalize-space()='Tours']")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		
		//destination setting
		WebElement destination = driver.findElement(By.xpath("//form[@action='https://www.phptravels.net/tours/search']//div[@class='form-icon-left typeahead__container']"));
		destination.click();
		driver.findElement(By.xpath("//li[1]//ul[1]//li[5]")).click(); 
		
		//tour type setting
		WebElement tourType = driver.findElement(By.xpath("//div[@id='tourtype_chosen']//a[contains(@class,'chosen-single')]"));
		tourType.click();
		driver.findElement(By.xpath("//li[normalize-space()='Yacht']")).click(); 
		
		//Date Picker
		WebElement dateBox = driver.findElement(By.xpath("//form[@action='https://www.phptravels.net/tours/search']//input[@id='DateTours']"));
		dateBox.clear();
		dateBox.sendKeys("01/09/2021");
		
		
		//set adult
		WebElement incrAdult = driver.findElement(By.xpath("//form[contains(@action,'https://www.phptravels.net/tours/search')]//button[contains(@type,'button')][normalize-space()='+']"));
		incrAdult.click();
		
		// Click on search 
		driver.findElement(By.xpath("//form[contains(@action,'https://www.phptravels.net/tours/search')]//button[contains(@type,'submit')][normalize-space()='Search']")).click();
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
		
		//Change date
		WebElement dateBox2 = driver.findElement(By.xpath("//input[@placeholder='Date']"));
		dateBox2.clear();
		dateBox2.sendKeys("01/09/2021");
		
		//click on bookNow 
		driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-block mt-20 btn-action btn-lg loader']")).click();
		
		// book as guest
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("First Name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Last Name");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("email1@abc.com");
		driver.findElement(By.xpath("//input[@name='confirmemail']")).sendKeys("email1@abc.com");
		driver.findElement(By.xpath("//input[@name='phone']']")).sendKeys("01712345678");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Address");
		driver.findElement(By.xpath("//a[@class='chosen-single']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Bangladesh']")).click();
		
		//enter wrong coupon code
		driver.findElement(By.xpath("//input[@class='o2 coupon form-bg-light']")).sendKeys("DIS10");
		driver.findElement(By.xpath("//button[normalize-space()='Apply Coupon']")).click();
		
		driver.switchTo().alert().accept();
		
		//click on pay on arrival
		driver.findElement(By.xpath("//button[normalize-space()='Pay on Arrival']")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		
		driver.switchTo().alert().accept();
		
	}
}
