package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification requestSpecification;

	public RequestSpecification requestSpecification() {
		PrintStream stream = null;
		if (requestSpecification == null) {
			try {
				stream = new PrintStream(new FileOutputStream("logging.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			requestSpecification = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI"))
					.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream)).setContentType(ContentType.JSON).build();

			return requestSpecification;
		}
		return requestSpecification;
	}

	public String getGlobalValue(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\resources\\global.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop.getProperty(key);
	}

	public String getJsonPath(Response response, String key) {
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.get(key).toString();

	}
	
	public static JsonPath rawToJson(String response) {
		JsonPath jsonPath = new JsonPath(response);
		
		return jsonPath;
		
	}

}
