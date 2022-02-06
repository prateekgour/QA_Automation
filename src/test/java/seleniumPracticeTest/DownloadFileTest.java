package seleniumPracticeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenuimPracticeClass.BaseClass;
import selenuimPracticeClass.DownloadFileClass;

public class DownloadFileTest {

	public static void main(String[] args) {

		BaseClass bs = new BaseClass();
		WebDriver driver = bs.initiateBrowser();

		DownloadFileClass dfc = new DownloadFileClass(driver);

		String baseURL = "https://demo.guru99.com/test/yahoo.html";
		driver.get(baseURL);

		WebElement downloadButton = dfc.downloadFile();

		String sourceLocation = downloadButton.getAttribute("href");

		String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

		try {
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal);
		} catch (InterruptedException | IOException ex) {
			System.out.println(ex.toString());
		}
		driver.close();
	}

}
