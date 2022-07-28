package baseClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	// dataProvider to get login credentials
	@DataProvider(name = "CredentialsProvider1")
	public Object[][] getCredentials() throws IOException {

		// test data
		BaseClass bs = new BaseClass();

		Object[][] credentials = bs.getLoginCreds(1, 5);
				
		return credentials;
	}
	
	/*
	 * // dataProvider to get login credentials
	 * 
	 * @DataProvider(name = "CredentialsProvider2") public static Object[][]
	 * getCredentials2() throws IOException {
	 * 
	 * // test data 
	 * TestDataUtilities testData = new TestDataUtilities();;
	 * 
	 * Object[][] credentials = testData.getLoginCreds(5, 15); 
	 * 
	 * return credentials;
	 * 
	 * }
	 */
	
	}
