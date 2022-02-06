package selenuimPracticeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownloadFileClass {
	
	ObjectRepository or = new ObjectRepository();
	WebDriver driver;
	
	public DownloadFileClass(WebDriver driver){
		
		this.driver = driver;
	}
	
	public WebElement downloadFile(){
		
		return driver.findElement(By.xpath(or.downloadFile));
	}

}
