package seleniumPracticeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import selenuimPracticeClass.BaseClass;

public class DropDownTest extends BaseClass {

	public static void main(String[] args) {
		
		BaseClass bs = new BaseClass();
		WebDriver driver = bs.initiateBrowser();
		
		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@id = 'dropdown-class-example']"));
		
		if(dropdown.isEnabled() && dropdown.isDisplayed()) 
		   { 
		      System.out.println("Dropdown is enabled and visible"); 
		   } 
		  else { 
		      System.out.println("Dropdown is not visible"); 
		  } 
		
		Select select = new Select (dropdown);
		
		int size = select.getOptions().size();
		
		System.out.println("Size of list "+size);
		
		select.selectByVisibleText("Option2");
		
		String selectedOption = select.getFirstSelectedOption().getText();
		
		System.out.println("Option Selected : "+selectedOption);
		
		driver.close();

	}

}
