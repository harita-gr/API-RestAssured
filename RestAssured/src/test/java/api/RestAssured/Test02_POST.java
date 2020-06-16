package api.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class Test02_POST {

	//@Test
	void test_01() {
		
		//Create a map
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "Harita");
		map.put("job","Engineer");
		
		System.out.println(map);
		
		//Parsing into JSON using "JSON Simple"
		JSONObject request = new JSONObject(map);
		System.out.println(request);
			
	}
	
	@Test
	void test_02() {
		JSONObject request = new JSONObject();
		request.put("name", "Harita");
		request.put("job","Engineer");
		System.out.println(request);
		
		
		given().
		      header("Content-Type","application/json"). //OR
		      //contentType(ContentType.JSON).   
		      accept(ContentType.JSON).
		      body(request.toJSONString()).
		when().
		      post("https://reqres.in/api/users").
		then().
		      statusCode(201).
		      log().all();
		
	}	
}

