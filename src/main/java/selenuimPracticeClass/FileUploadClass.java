package selenuimPracticeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadClass {

	ObjectRepository or = new ObjectRepository();
	WebDriver driver;

	public FileUploadClass(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement FileUpload() {
		
		return driver.findElement(By.xpath(or.fileUpload));

	}

}
