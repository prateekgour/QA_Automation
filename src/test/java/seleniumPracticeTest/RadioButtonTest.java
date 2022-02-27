package seleniumPracticeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.BaseClass;
import selenuimPracticeClass.RadioButtonClass;

public class RadioButtonTest extends BaseClass{

	public static void main(String[] args) {
		
		BaseClass bs = new BaseClass();
		WebDriver driver = bs.initiateBrowser();
		
		RadioButtonClass rbc = new RadioButtonClass(driver);
		
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		String actualOutput ="";
		String expectedOutput = "Radio1";
		
		driver.get(baseUrl);
		
		rbc.radioBtn().click();
		actualOutput = rbc.radioBtn().getText();
		
		//System.out.println(actualOutput);
		
		if (actualOutput.contentEquals(expectedOutput)){
			System.out.println("Test Passed");
		}
		else{
			System.out.println("Test Failed");
		}
		driver.close();

	}

}
