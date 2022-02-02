package seleniumPracticeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		String actualOutput ="";
		String expectedOutput = "bmw";
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		
		element.click();
		
		if(element.isSelected()){
			
			WebElement element1 = driver.findElement(By.xpath("//label[normalize-space()='Option1']"));
			actualOutput = element1.getAttribute("for");
			
			//System.out.println(actualOutput);
			
			if (actualOutput.contentEquals(expectedOutput)){
				
				System.out.println("Test Passed");
			}
			else {
				
				System.out.println("Test Failed");
			}
			
		}
		else{
			
			System.out.println("option 1 not selected");
		}
			
		driver.close();
		

	}

}
