package seleniumPracticeTest;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenuimPracticeClass.BaseClass;
import selenuimPracticeClass.WebTableClass;

public class WebTableTest {

	public static void main(String[] args) {

		BaseClass bs = new BaseClass();
		WebDriver driver = bs.initiateBrowser();

		WebTableClass wtc = new WebTableClass(driver);

		String baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";

		driver.get(baseUrl);
		driver.manage().window().maximize();

		WebElement element = wtc.webTable();

		List<WebElement> column_count = element.findElements(By.xpath("thead/tr/th"));

		int col_size = column_count.size();

		System.out.println("No of columns : " + col_size);

		List<WebElement> row_count = element.findElements(By.xpath("tbody/tr"));

		int row_size = row_count.size();

		System.out.println("No of columns : " + row_size);
		
		List<WebElement> output = element.findElements(By.xpath("tbody/tr[5]/td"));
		
		Iterator<WebElement> it = output.iterator();
		
		while(it.hasNext()){
			System.out.print(it.next().getText());
			System.out.print(" ");
		}

		driver.close();

	}

}
