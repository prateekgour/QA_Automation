package baseClass;

import java.util.HashMap;

public class ExcelMapping {

	public HashMap <String,String> excelMapping;
	
	public ExcelMapping(){
		
		// HashMap to store excel Mapping
		excelMapping = new HashMap<String, String>();
		
		// Add new mapping entries below //
		
		excelMapping.put("CurrentEnv","Sheet1,1,1"); // current env
		excelMapping.put("Browser","Sheet1,2,1"); // current browser
		excelMapping.put("DB_Region","Sheet1,3,1"); // current DB region
		excelMapping.put("CurrentEnvURL", "Sheet1,4,1"); // get the URL based on env
	
	}

}
