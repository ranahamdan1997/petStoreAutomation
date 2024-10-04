package api.endpoint;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints {

	public static Response createUser(User payload){
		//prerequisites
	Response response=given()
	  .contentType(ContentType.JSON)
	  .accept(ContentType.JSON)
	  .body(payload)
	  //requests
		.when()
.post(Routes.post_url); //we will get it from routes class , how we will get post_url var? by creating object
// no validation here
	return response;
	
	}
	
	
	public static Response readUser(String Username){//user name get from test cases
		//prerequisites
	Response response=given()
	  .pathParam("username", Username)
	  //requests
		.when()
.get(Routes.get_url); //we will get it from routes class , how we will get post_url var? by creating object
// no validation here
	return response;
	
	}
	

	public static Response updateUser(String userName,User payload){
		//prerequisites
	Response response=given()
	  .contentType(ContentType.JSON)
	  .accept(ContentType.JSON)
	  .pathParam("username", userName)
	  .body(payload)
	
	  //requests
		.when()
.put(Routes.update_url); //we will get it from routes class , how we will get post_url var? by creating object
// no validation here
	return response;
	
	}
	
	public static Response deleteUser(String Username){//user name get from test cases
		//prerequisites
	Response response=given()
	  .pathParam("username", Username)
	  //requests
		.when()
.delete(Routes.delete_url); //we will get it from routes class , how we will get post_url var? by creating object
// no validation here
	return response;
	
	}
}
