package seleniumPracticeTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.postgresql.util.PSQLException;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
		
		Capabilities cap = ((ChromeDriver) driver).getCapabilities();
	    System.out.println(cap.getVersion());
				

	}

	@Test(priority = 1, groups = { "db" })
	public void queryTest() throws SQLException {

		ResultSet rs = executeQuery("select associate_name from associate_role where associate_id = 1001");

		while (rs.next()) {
			System.out.println(rs.getString("associate_name"));
		}
	}

	@Test(priority = 2, groups = { "db" })
	public void insertQuery() throws SQLException {

		try {
			if (insertAssociate(1002, 3, 100, "Bablu")) {
				System.out.println("Successfully entred");
			}
		} catch (PSQLException pe) {

			System.out.println("Value Already Exists !");
		}

		Reporter.log("We used abc for this test");

	}

	@Test(priority = 3, dependsOnMethods = { "insertQuery", "queryTest" })
	public void deleteQueryTest() throws SQLException {

		if (deleteQuery(1002)) {
			System.out.println("Deleted successfully");
		}

	}

	@Test(priority = 4)
	public void uploadTest() throws IOException, InterruptedException {

		final String filetoUpload = System.getProperty("user.dir") + "\\Test Data\\Upload File Example.txt";
		WebElement element = fuc.FileUpload();

		element.sendKeys(filetoUpload);

		driver.findElement(By.xpath("//input[@id = 'terms'][@type = 'checkbox']")).click();

		driver.findElement(By.xpath("//button[@id = 'submitbutton' and @class = 'btn buttoncolor has-spinner']"))
				.click();

	}

	@Test(priority = 5)
	public void screenshotTest() throws IOException, InterruptedException {

		Thread.sleep(3000);
		final String scrnShot = System.getProperty("user.dir") + "\\Screenshot\\test.png";
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(scrnShot);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	@Test(priority = 6, dataProviderClass= baseClass.DataProviders.class, dataProvider = "CredentialsProvider1")
	public void loginScreen(String uname, String pass){
		
		driver.get("https://demoqa.com/login");
		driver.findElement(By.xpath("//form[@id='userForm']/div[1]//h5[contains(text(),'Login in Book Store')]")).isDisplayed();
		
//	}
//
//	@Test(priority = 7)
//	public void loginTest(){
		
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		
		driver.findElement(By.xpath("//button[@id='login']")).click();
		driver.findElement(By.xpath("//label[@id='userName-label'][contains(text(), 'User Name')]")).isDisplayed();
		
//	}
//	
//	@Test(priority = 8)
//	public void logoutTest(){

		driver.findElement(By.xpath("//button[text()='Log out']")).click();
		driver.findElement(By.xpath("//form[@id='userForm']/div[1]//h5[contains(text(),'Login in Book Store')]")).isDisplayed();		
	}
	
	
	
	@AfterTest
	public void afterUploadTest() throws SQLException {

		closeConnection();
		driver.close();
	}

}
