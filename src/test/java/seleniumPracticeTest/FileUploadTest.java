package seleniumPracticeTest;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.postgresql.util.PSQLException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import selenuimPracticeClass.FileUploadClass;

public class FileUploadTest extends BaseClass {

	WebDriver driver;
	FileUploadClass fuc;

	@BeforeTest
	public void beforeUploadTest() throws SQLException {

		driver = initiateBrowser();
		fuc = new FileUploadClass(driver);
		getConnection("postgres", "yash9496");

	}

	@Test
	public void uploadTest() throws IOException, InterruptedException {

		final String filetoUpload = System.getProperty("user.dir") + "\\Test Data\\Upload File Example.txt";
		final String scrnShot = System.getProperty("user.dir") + "\\Screenshot\\test.png";
		WebElement element = fuc.FileUpload();

		element.sendKeys(filetoUpload);

		driver.findElement(By.xpath("//input[@id = 'terms'][@type = 'checkbox']")).click();

		driver.findElement(By.xpath("//button[@id = 'submitbutton' and @class = 'btn buttoncolor has-spinner']"))
				.click();

		Thread.sleep(3000);

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(scrnShot);

		FileUtils.copyFile(SrcFile, DestFile);

	}

	@Test
	public void queryTest() throws SQLException {

		ResultSet rs = executeQuery("select associate_name from associate_role where associate_id = 1001");

		while (rs.next()) {
			System.out.println(rs.getString("associate_name"));
		}
	}

	@Test(priority=1)
	public void insertQuery() throws SQLException {

		try {
			if (insertAssociate(1002, 3, 100, "Bablu")) {
				System.out.println("Successfully entred");
			}
		} catch (PSQLException pe) {

			System.out.println("Value Already Exists !");
		}

	}

	@Test(priority=2)
	public void deleteQueryTest() throws SQLException {
		
		if(deleteQuery(1002)){
			System.out.println("Deleted successfully");
		}

	}

	@AfterTest
	public void afterUploadTest() throws SQLException {

		closeConnection();
		driver.close();
	}

}
