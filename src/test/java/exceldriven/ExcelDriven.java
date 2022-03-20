package exceldriven;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.data.DataDriven;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resources.Utils;

public class ExcelDriven {
	
	@Test
	public void addBook() {
		DataDriven dataDriven = new DataDriven();
		ArrayList addBook = dataDriven.getData("RestAddbook","RestAssured");
		
		HashMap<String, Object> jsonAsMap = new HashMap<>();
		jsonAsMap.put("name", addBook.get(1));
		jsonAsMap.put("isbn", addBook.get(2));
		jsonAsMap.put("aisle", addBook.get(3));
		jsonAsMap.put("author",addBook.get(4));
		RestAssured.baseURI="http://216.10.245.166";
//		.body("{\r\n"
//				+ "\r\n"
//				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
//				+ "\"isbn\":\"kale\",\r\n"
//				+ "\"aisle\":\"227\",\r\n"
//				+ "\"author\":\"John foe\"\r\n"
//				+ "}\r\n"
//				+ "")
		String response = given().log().all().header("Content-Type","application/json")
		.body(jsonAsMap)
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = Utils.rawToJson(response);
		String id = js.getString("ID");
		System.out.println("ID===>"+id);
		
	}

}
