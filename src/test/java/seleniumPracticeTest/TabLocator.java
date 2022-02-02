package seleniumPracticeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabLocator {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
        String expectedTitle = "Rahul Shetty Academy";
        String actualTitle = "";
        
        driver.get(baseUrl);
        
        WebElement element = driver.findElement(By.xpath("//a[text()='Open Tab']"));
        
        String newTab = element.getAttribute("href");
        
        System.out.println(newTab);
        
        element.click();
        
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        
        for(String str : windowHandles)
        	System.out.println(str);
        
        driver.switchTo().window(windowHandles.get(1));
                
//        String a = "window.open('newTab','_blank');";
  //      ((JavascriptExecutor)driver).executeScript(a);
        
        actualTitle = driver.getTitle();
        
        if (actualTitle.contentEquals(expectedTitle)){
        	System.out.println("Test Passed");
        }
        else
        {
        	System.out.println("Test Failed");
        }
        driver.close();
        
	}

}
