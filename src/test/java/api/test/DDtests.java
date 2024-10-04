package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoint.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class DDtests {

	//i want to create post request for multiple users
	
    @Test(priority=1, dataProvider="Data", dataProviderClass=api.utilities.DataProviders.class)
	public void testPOSTuser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph )//we have to recieve data,it should be the same order from excelsheet   
	{
		System.out.println("here the brgining");
	User userPayload=new  User(); 
	userPayload.setId(Integer.parseInt(userID));
	userPayload.setUsername(userName);
	userPayload.setFirstname(fname);
	userPayload.setLastname(lname);
	userPayload.setEmail(useremail);
	userPayload.setPassword(pwd);
	userPayload.setPhone(ph);
	
	Response response=UserEndPoints.createUser(userPayload);
	AssertJUnit.assertEquals(response.getStatusCode(), 200);}
//Here i want to delete those users
	
    @Test(priority=2, dataProvider="UserNames", dataProviderClass=api.utilities.DataProviders.class)
public void testDeleteUserByName(String userName)
	{
Response response =UserEndPoints.deleteUser(userName);
AssertJUnit.assertEquals(response.getStatusCode(), 200);}

	}




