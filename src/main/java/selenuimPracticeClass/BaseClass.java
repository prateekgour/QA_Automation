package selenuimPracticeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	// public WebDriver driver;
	
	public WebDriver initiateBrowser(){
		
		System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

}
