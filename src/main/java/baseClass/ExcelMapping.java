package baseClass;

import java.util.HashMap;

public class ExcelMapping {

	public HashMap <String,String> excelMapping;
	
	public ExcelMapping(){
		
		// HashMap to store excel Mapping
		excelMapping = new HashMap<String, String>();
		
		// Add new mapping entries below //
		
		excelMapping.put("CurrentEnvURL","Sheet1,1,1"); // current env url
		excelMapping.put("Browser","Sheet1,2,1"); // current browser
		excelMapping.put("Browser2","Sheet1,3,1");
	
	}

}
