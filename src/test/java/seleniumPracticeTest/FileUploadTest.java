package seleniumPracticeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import selenuimPracticeClass.FileUploadClass;

public class FileUploadTest extends BaseClass{
	
	WebDriver driver;
	FileUploadClass fuc;
	
	@BeforeTest
	public void beforeUploadTest(){
		
		driver = initiateBrowser();
		fuc = new FileUploadClass(driver);
			
	}
	
	@Test
	public void uploadTest() throws IOException, InterruptedException {
		
		final String filetoUpload = System.getProperty("user.dir") + "\\Test Data\\Upload File Example.txt";
		final String scrnShot = System.getProperty("user.dir")+ "\\Screenshot\\test.png";
				WebElement element = fuc.FileUpload();

		element.sendKeys(filetoUpload);

		driver.findElement(By.xpath("//input[@id = 'terms'][@type = 'checkbox']")).click();

		driver.findElement(By.xpath("//button[@id = 'submitbutton' and @class = 'btn buttoncolor has-spinner']"))
				.click();
		
		Thread.sleep(3000);
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		File DestFile=new File(scrnShot);
				
		FileUtils.copyFile(SrcFile, DestFile);
		
	}
		@AfterTest
		public void afterUploadTest(){
			
		
			driver.close();
		}

	}


