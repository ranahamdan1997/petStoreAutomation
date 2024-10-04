package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
@DataProvider(name="Data")
public String[][]getAllData()throws IOException{
	
	String path=System.getProperty("user.dir")+"//testData//Userdataup.xlsx";//System.getProperty("user.dir" : it is will get project current location
	XLUtility xl=new XLUtility(path);
	int rownum=xl.getRowCount("Sheet1");
	int colcount=xl.getCellCount("Sheet1",1);
	String apidata[][]=new String [rownum][colcount];
	for(int i=1;i<=rownum;i++) {
		for(int j=0;j<colcount;j++) {
			
			apidata[i-1][j]=xl.getCellData("Sheet1", i, j);}
		
			
		}
		
		return apidata;//the result string array and it will return all details
		
		
	}

@DataProvider(name="UserNames")
public String[]getUserNames()throws IOException{//here get only the usernames 
	String path=System.getProperty("user.dir")+"//testData//Userdataup.xlsx";
	XLUtility xl=new XLUtility(path);
	int rownum=xl.getRowCount("Sheet1");
   String apidata[]=new String[rownum];
   
   for(int i=1;i<=rownum;i++) {
	   
	   apidata[i-1]=xl.getCellData("Sheet1",i, 1);//we have only one dimensional array
	   
	   
   }
	
	return apidata;
	
}
}

