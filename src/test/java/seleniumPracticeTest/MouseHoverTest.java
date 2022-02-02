package seleniumPracticeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		
		Actions action = new Actions (driver);
		
		WebElement mousehover = driver.findElement(By.xpath("//button[@id = 'mousehover']"));
		
		action.moveToElement(mousehover).build().perform();
		
		Thread.sleep(3000);
		
		WebElement mousehovercontent = driver.findElement(By.xpath("//div[@class = 'mouse-hover-content']//a[text()='Top']"));
		
		mousehovercontent.click();
		
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
