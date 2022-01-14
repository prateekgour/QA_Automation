package seleniumPracticeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice1 {
	
	public static void main(String[] args) {
	       
		System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
        String expectedPage = "Rahul Shetty Academy";
        String actualPage ="";
        
        driver.get(baseUrl);
        
        WebElement element = driver.findElement(By.xpath("//button[text()='Home']"));
        
        element.click();
        
        actualPage = driver.getTitle();
        
        if(actualPage.contentEquals(expectedPage)){
        	System.out.println("Test Passed");
        }
        else{
        	System.out.println("Test Failed");
        }
driver.close();
}
}
