package selenuimPracticeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinkClass {
	
	ObjectRepository or = new ObjectRepository();
	WebDriver driver;
	
	public BrokenLinkClass(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public List<WebElement> Links (){
		
		return (driver.findElements(By.tagName(or.brokenURL)));
	}
	
	

}
