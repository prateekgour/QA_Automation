package seleniumPracticeTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenuimPracticeClass.BaseClass;
import selenuimPracticeClass.BrokenLinkClass;

public class BrokenLinkTest {

	public static void main(String[] args) {

		BaseClass bs = new BaseClass();
		WebDriver driver = bs.initiateBrowser();
		BrokenLinkClass blc = new BrokenLinkClass(driver);

		String baseURL = "https://rahulshettyacademy.com/AutomationPractice/";
		String url = "";
		HttpURLConnection huc = null;
		int respcode = 200;

		driver.get(baseURL);
		driver.manage().window().maximize();

		List<WebElement> LinkElements = blc.Links();

		int listSize = LinkElements.size();
		System.out.println("List Size is : "+listSize);
		
		Iterator<WebElement> it = LinkElements.iterator();

		while (it.hasNext()) {

			url = it.next().getAttribute("href");
			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			/*if (!url.startsWith(baseURL)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}*/

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respcode = huc.getResponseCode();

				if (respcode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		driver.close();
	}

}
