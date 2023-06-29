package TVT.TVT;

import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Api {
    
	@Test(enabled=false)
	public void requestTestng()
	{
	
		//baseURI = "https://reqres.in/api/users/2";
		
		Response response= RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.statusCode());
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,200);
	}
	
	@Test(priority=2)
	public void getRequest()
	{
		Response response= RestAssured.get("https://web.tvt-test.com?pages=2");
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.statusCode());
		System.out.println(response.getHeader("content-type"));
	    System.out.println(response.getBody().asString());
		System.out.println(response.getBody().prettyPrint());
		
		
	}
	@Test(enabled=false)
	public void deleteRequest()
	{
		RestAssured.baseURI="https://reqres.in/api";
		ValidatableResponse response = RestAssured
				.given()
				.header("","")
				.when()
				.delete("users/2")
				.then()
				.statusCode(204);
	}
	
	}
