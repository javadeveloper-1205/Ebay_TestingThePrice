package ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver", "geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");

		driver.findElement(By.id("gh-ac")).sendKeys("iphone 12");
		driver.findElement(By.id("gh-btn")).click();
		
		Thread.sleep(500);
		driver.findElement(By.id("gh-btn")).click();
		
		driver.findElements(By.className("s-item__image-img")).get(4).click();
		
		String price = driver.findElement(By.id("prcIsum")).getText();
		
		System.out.println(price.replace("US $", "").equals("879.10") ? "Price is correct" : "Price isn't correct");
		
//		driver.quit();
		
	}
}
