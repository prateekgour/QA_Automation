package selenuimPracticeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableClass {
	
	ObjectRepository or = new ObjectRepository();
	WebDriver driver;
	
	public WebTableClass(WebDriver driver){
		
		this.driver = driver;
	}
	
	public WebElement webTable(){
		
		return driver.findElement(By.xpath(or.webTable));
	}

}
