package api.endpoint;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints2 {

    // Method created for getting URLs from properties file
    static ResourceBundle getURL() {
        ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load properties file
        return routes;
    }
	public static Response createUser(User payload){
		String post_url=getURL().getString("post_url");
		//prerequisites
	Response response=given()
	  .contentType(ContentType.JSON)
	  .accept(ContentType.JSON)
	  .body(payload)
	  //requests
		.when()
.post(post_url); //we will get it from routes class , how we will get post_url var? by creating object
// no validation here
	return response;
	
	}
	
	
	public static Response readUser(String Username){//user name get from test cases
		String get_url=getURL().getString("get_url");

		//prerequisites
	Response response=given()
	  .pathParam("username", Username)
	  //requests
		.when()
.get(get_url); //we will get it from routes class , how we will get post_url var? by creating object
// no validation here
	return response;
	
	}
	

	public static Response updateUser(String userName,User payload){
		String update_url=getURL().getString("update_url");

		//prerequisites
	Response response=given()
	  .contentType(ContentType.JSON)
	  .accept(ContentType.JSON)
	  .pathParam("username", userName)
	  .body(payload)
	
	  //requests
		.when()
.put(update_url); //we will get it from routes class , how we will get post_url var? by creating object
// no validation here
	return response;
	
	}
	
	public static Response deleteUser(String Username){//user name get from test cases
		String delete_url=getURL().getString("delete_url");

		//prerequisites
	Response response=given()
	  .pathParam("username", Username)
	  //requests
		.when()
.delete(delete_url); //we will get it from routes class , how we will get post_url var? by creating object
// no validation here
	return response;
	
	}
}
