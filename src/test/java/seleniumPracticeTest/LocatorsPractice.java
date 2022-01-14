package seleniumPracticeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {

	public static void main(String[] args) {
       
		System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
        String actualText = "";
        String expectedText = "Practice Page";
        
        driver.get(baseUrl);
   
        WebElement element = driver.findElement(By.xpath("//h1[text()='Practice Page']"));
        
        actualText = element.getText();
        
         if (actualText.contentEquals(expectedText)){
        	 System.out.println("Test Passed");
         }
         else{
        	 System.out.println("Test Failed");
         }
        
        driver.close();
}
}
