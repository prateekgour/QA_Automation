package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	// Test Data Path
	final String testDataPath = System.getProperty("user.dir") + "\\test data\\TestData.xlsx";
	public WebDriver driver;
	ExcelMapping em = new ExcelMapping();
	public Connection conn;
	String envName;
	String envURL;
	String browser;
	String dbRegion;

	public WebDriver initiateBrowser() {

		BaseClass bs = new BaseClass();
		
		// get envName from test data and set URL
		envName = bs.excelRead(em.excelMapping.get("CurrentEnv"));
		
		if(envName.equalsIgnoreCase("SIT")) {
			
			envURL = bs.excelRead(em.excelMapping.get("CurrentEnvURL"));
			System.out.println("Executing on: " +  envName);
			
		}else if (envName.equalsIgnoreCase("UAT")) {
			
			envURL = bs.excelRead(em.excelMapping.get("CurrentEnvURL"));
			System.out.println("Executing on: " +  envName);
			
		}else if (envName.equalsIgnoreCase("PERF")) {
			
			envURL = bs.excelRead(em.excelMapping.get("CurrentEnvURL"));
			System.out.println("Executing on: " +  envName);
		}

		// get browser from excel test data
	    browser = bs.excelRead(em.excelMapping.get("Browser"));
		
        if (browser.equalsIgnoreCase("chrome")) {
        	
        	System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        	//create object of chrome options
            ChromeOptions options = new ChromeOptions();
            
            //add the headless argument
           // options.addArguments("headless");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(envURL);
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe"); 
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(envURL);
			
		}
		return driver;
	}

	// Method to read value from excel
	public String excelRead(String key) {

		// string value to be returned
		String val = "";

		// Split sheetname, rownum, colnum
		String keySeparated[] = key.split(",");

		if (keySeparated.length != 3) {
			System.out.println("Incorrect key Passed to Excel Read Method");
			return null;
		}

		String sheetName = keySeparated[0];
		int row = Integer.parseInt(keySeparated[1]);
		int col = Integer.parseInt(keySeparated[2]);

		// empty sheet object
		Sheet sheet = null;

		try {

			// load file
			FileInputStream fis = new FileInputStream(testDataPath);

			// initialize excel as a workbook
			Workbook workbook = WorkbookFactory.create(fis);

			// load the sheet from excel
			sheet = workbook.getSheet(sheetName);

			// get value from respective location
			val = sheet.getRow(row).getCell(col).getStringCellValue();
		}

		catch (Exception e) {

			System.out.println("Excel Read Error");
			e.printStackTrace();
		}

		return val;
	}

	// Method to write value to excel
	public String excelWrite(String key, String value) {

		String keySeparated[] = key.split(",");

		if (keySeparated.length != 3) {
			System.out.println("Incorrect key Passed to Excel Read Method");
			return null;
		}

		String sheetName = keySeparated[0];
		int row = Integer.parseInt(keySeparated[1]);
		int col = Integer.parseInt(keySeparated[2]);

		// empty sheet object
		Sheet sheet = null;

		try {

			// load file
			FileInputStream fis = new FileInputStream(testDataPath);

			// initialize excel as a workbook
			Workbook workbook = WorkbookFactory.create(fis);

			// load the sheet from excel
			sheet = workbook.getSheet(sheetName);

			// get value from respective location
			sheet.getRow(row).getCell(col).setCellValue(value);

			FileOutputStream fos = new FileOutputStream(testDataPath);

			workbook.write(fos);

			workbook.close();

		} catch (Exception e) {

			System.out.println("Excel Write Error");
			e.printStackTrace();
		}

		return "File Edited Successfully";
	}

	// ---Override excelRead Method---
	public String excelRead(String sheetName, String row, String column) {

		// string value to be returned
		String val = "";

		int row_num = Integer.parseInt(row);
		int col_num = Integer.parseInt(column);

		// empty sheet object
		Sheet sheet = null;

		try {

			// load file
			FileInputStream fis = new FileInputStream(testDataPath);

			// initialize excel as a workbook
			Workbook workbook = WorkbookFactory.create(fis);

			// load the sheet from excel
			sheet = workbook.getSheet(sheetName);

			// get value from respective location
			val = sheet.getRow(row_num).getCell(col_num).getStringCellValue();
		}

		catch (Exception e) {

			System.out.println("Excel Read Error");
			e.printStackTrace();
		}

		return val;
	}

	// ---Override excelWrite Method---
	public String excelWrite(String sheetName, String row, String column, String value) {

		int row_num = Integer.parseInt(row);
		int col_num = Integer.parseInt(column);

		// empty sheet object
		Sheet sheet = null;

		try {

			// load file
			FileInputStream fis = new FileInputStream(testDataPath);

			// initialize excel as a workbook
			Workbook workbook = WorkbookFactory.create(fis);

			// load the sheet from excel
			sheet = workbook.getSheet(sheetName);

			// get value from respective location
			sheet.getRow(row_num).getCell(col_num).setCellValue(value);

			FileOutputStream fos = new FileOutputStream(testDataPath);

			workbook.write(fos);

			workbook.close();

		} catch (Exception e) {

			System.out.println("Excel Write Error");
			e.printStackTrace();
		}

		return "File Edited Successfully";
	}

	public void getConnection(String uname, String pass) throws SQLException {
		
		BaseClass bs = new BaseClass();
		dbRegion = bs.excelRead(em.excelMapping.get("DB_Region"));
		System.out.println("DB pointing set to: " + dbRegion);
		
		String url = "jdbc:postgresql://localhost/" + dbRegion + "?user=" + uname + "&password=" + pass + "&ssl=false";

		if (conn == null)
			conn = DriverManager.getConnection(url);
	}

	public void closeConnection() throws SQLException {

		if (conn != null)
			conn.close();
	}

	public ResultSet executeQuery(String query) throws SQLException {

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	public boolean insertAssociate( int assID, int roleID, int unitID,String name) throws SQLException {

		PreparedStatement stmt = conn.prepareStatement("Insert into associate_role values (?,?,?,?)");
		stmt.setInt(1, assID);
		stmt.setInt(2, roleID);
		stmt.setInt(3, unitID);
		stmt.setString(4, name);
		
		int i = stmt.executeUpdate();

		if (i < 1)
			return false;

		else
			return true;
	}
	
	public boolean deleteQuery(int associateId) throws SQLException {
		
		String query = "delete from associate_role where associate_id = "+associateId+"";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		return true;
		
	}
	
	public Object[][] getLoginCreds(int startRow, int endRow) throws IOException {

		// Convert row noss to index
		startRow--;
		endRow--;

		// Create an object of File class to open xlsx file
		File file = new File(testDataPath);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		// Create object of XSSFWorkbook class
		Workbook workbook = new XSSFWorkbook(inputStream);

		// Read sheet inside the workbook by its name
		Sheet sheet = workbook.getSheet("Login");

		// Object for returning creds
		Object object[][] = new Object[endRow - startRow + 1][2];

		for (int i = startRow; i < endRow + 1; i++) {

			Row row = sheet.getRow(i);

			// Create a loop to get cell values

			for (int j = 0; j <= 1; j++) {

				object[i][j] = row.getCell(j).getStringCellValue();
			}

			//object[i][2] = Integer.toString(i + 1);
		}

		return object;

	}

}
