package api.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
	
	//@Test
	void test_01() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	@Test
	void test_staticImport_02() {
		
		given().
		        get("https://reqres.in/api/users?page=2").
		  
		then().
		         statusCode(201).
		         body("data.id[0]",equalTo(7));
	}

}
