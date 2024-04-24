package restAPIExample;

import java.util.HashMap;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APITestCases {
	String BaseURI = "https://dummy.restapiexample.com/api/v1";
	@Test
	public void Test01_GetAllEmployees() {
		
			
		RestAssured.given()
		.baseUri(BaseURI)
		.when()
		.get("/employees")
		.then()
		.log()
		.body()
		.statusCode(200);

		
	}
	@Test
	public void Test02_GetSingleEmployee() {
		RestAssured.given()
		.baseUri(BaseURI)
		.when()
		.get("/employee/1")
		.then()
		.log()
		.body()
		.statusCode(200)
		.body("name",Matchers.equalTo("Tiger Nixon"));
		
				
}
	@Test
	public void Test03_CreateOperationWithHashMap() {
		
		
		HashMap<String,String> obj = new HashMap<String,String>();
		
		obj.put("name","Srilakshmi");
		obj.put("salary","15000");
		obj.put("age","30");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(obj)
	    .baseUri(BaseURI)
		.when().post("/create")
		.then().log().body().statusCode(201);
		
		}	

}


