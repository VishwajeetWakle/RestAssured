package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		String path = "D:\\SDET Level 2\\Rest Assured\\RestAssuredSerenityBDD\\PetStoreAutomation\\src\\test\\resources\\api.petstore.swagger.io.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("Sheet2");
		int colcount = xl.getCellCount("Sheet2", 1);
		
		String apidata[][] = new String [rownum][colcount];
		
		for(int i = 1; i <= rownum; i++) {
			for(int j = 0; j < colcount; j++) {
				apidata[i-1][j] = xl.getCellData("Sheet2", i, j);
			}
			
		}
		return apidata;
		
	}

	
	@DataProvider(name="UserName")
	public String[] getUserNames() throws IOException{
		
		String path = "D:\\SDET Level 2\\Rest Assured\\RestAssuredSerenityBDD\\PetStoreAutomation\\src\\test\\resources\\api.petstore.swagger.io.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("Sheet2");
		
		String apidata[] = new String[rownum];
		
		for(int i = 1; i <= rownum; i++) {
			apidata[i-1] = xl.getCellData("Sheet2", i, 1);
		}
		return apidata;
	}

}
