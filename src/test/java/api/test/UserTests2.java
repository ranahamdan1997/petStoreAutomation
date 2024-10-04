package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.util.Assert;
import com.github.javafaker.Faker;

//import api.endpoint.UserEndPoints;
import api.endpoint.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
 
	Faker faker;
	User userPayload;
	public Logger logger;
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		
	userPayload.setUsername(faker.name().username());
	userPayload.setFirstname(faker.name().firstName());
	userPayload.setLastname(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	userPayload.setPassword(faker.internet().password(5,10));
	userPayload.setPhone(faker.phoneNumber().cellPhone());
	//logs
	logger=(Logger) LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPOSTuser(){
  		System.out.println("here the brgining");
	Response response=	UserEndPoints2.createUser(userPayload); //it will return respone
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		logger.info("*******user is created*********");

	}
	

	@Test(priority=2)
	public void testGetuserbyname(){
		logger.info("*******Reading user info*********");

		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		logger.info("*******user is displayed*********");

	}	
	
	
	

	@Test(priority=3)
	public void testupdateuser(){
		logger.info("*******user updated*********");

		//update data using payload
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
	Response response=	UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload); //it will return respone
		response.then().log().all();
		//or you can response.then().log().body().statuscode(200_;
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		//check the data after updating
		Response responseafterupdate=UserEndPoints2.readUser(this.userPayload.getUsername());
		responseafterupdate.then().log().all();
		AssertJUnit.assertEquals(responseafterupdate.getStatusCode(),200);
		
		
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		logger.info("*******deleting user*********");

		Response response=	UserEndPoints2.deleteUser(this.userPayload.getUsername());
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		logger.info("*******user is deleted*********");

	}
	
	
}
