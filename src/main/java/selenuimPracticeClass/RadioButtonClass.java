package selenuimPracticeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonClass {
	
	ObjectRepository or = new ObjectRepository();
	WebDriver driver;
		
	public RadioButtonClass(WebDriver driver){
		
		this.driver = driver;
	}
	
	public WebElement radioBtn(){
		
		return driver.findElement(By.xpath(or.radioBtn));
	}

}
