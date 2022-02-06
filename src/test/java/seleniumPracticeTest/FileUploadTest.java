package seleniumPracticeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenuimPracticeClass.BaseClass;
import selenuimPracticeClass.FileUploadClass;

public class FileUploadTest {

	public static void main(String[] args) throws IOException, InterruptedException {

		final String filetoUpload = System.getProperty("user.dir") + "\\Test Data\\Upload File Example.txt";
		final String scrnShot = System.getProperty("user.dir")+ "\\Screenshot\\test.png";
		
		BaseClass bs = new BaseClass();
		WebDriver driver = bs.initiateBrowser();

		FileUploadClass fuc = new FileUploadClass(driver);

		String baseURL = "https://demo.guru99.com/test/upload/";

		driver.get(baseURL);
		driver.manage().window().maximize();

		WebElement element = fuc.FileUpload();

		element.sendKeys(filetoUpload);

		driver.findElement(By.xpath("//input[@id = 'terms' and @type = 'checkbox']")).click();

		driver.findElement(By.xpath("//button[@id = 'submitbutton' and @class = 'btn buttoncolor has-spinner']"))
				.click();
		
		Thread.sleep(3000);
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		File DestFile=new File(scrnShot);
				
		FileUtils.copyFile(SrcFile, DestFile);
		
		driver.close();

	}

}
