package APITesting.com.org.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

public class WheaterGetRequest {
	//simple Get Request for getting wheather by City name
	//Status code : 200
	//	?@Test
	public void Test_01() {

		Response resp = when().get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=81ca09894232a6a30da403b6ad1f178e");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);

	}
	//Status code: 401
	//	@Test
	public void Test_02() {

		Response resp = when().get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=81ca09894232a6a30da403b6ad1f178");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 401);

	}
	//	How to use parameters with rest assured
	//	@Test
	public void Test_03() {

		Response resp = given().param("q", "London").
				param("appid", "81ca09894232a6a30da403b6ad1f178e").
				when().
				get("https://api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);

		if(resp.getStatusCode() == 200) {
			System.out.println("Api is working fine");
		}
		else {
			System.out.println("Api is not working fine");
		}

	}
	//	Assert our testcase in Rest assured api
	//	@Test
	public void Test_04() {

		given().param("q", "London").
		param("appid", "81ca09894232a6a30da403b6ad1f178e").
		when().
		get("https://api.openweathermap.org/data/2.5/weather").
		then().
		assertThat().statusCode(200);


	}

	//	
	//	@Test
	public void Test_05() {

		Response resp = given().param("q", "London").
				param("appid", "81ca09894232a6a30da403b6ad1f178e").
				when().
				get("https://api.openweathermap.org/data/2.5/weather");


		System.out.println(resp.asString());


	}
	//	@Test
	public void Test_06() {

		Response resp = given().param("id", "2643743").
				param("appid", "81ca09894232a6a30da403b6ad1f178e").
				when().
				get("https://api.openweathermap.org/data/2.5/weather");


		System.out.println(resp.asString());
	}

	//	@Test
	public void Test_07() {

		Response resp = given().param("zip", "201010,in").
				param("appid", "81ca09894232a6a30da403b6ad1f178e").
				when().
				get("https://api.openweathermap.org/data/2.5/weather");


		System.out.println(resp.asString());
	}

	//	@Test
	public void Test_08() {

		String wheatherReport = given().
				param("id", "2643743").
				param("appid", "81ca09894232a6a30da403b6ad1f178e").
				when().
				get("https://api.openweathermap.org/data/2.5/weather").
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");


		System.out.println(wheatherReport);
	}
	//	@Test
	public void Test_09() {

		Response resp = given().
				param("id", "2643743").
				param("appid", "81ca09894232a6a30da403b6ad1f178e").
				when().
				get("https://api.openweathermap.org/data/2.5/weather");

		String actualWeatherReport = resp.then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");

		String expectedWeatherReport = "";

		if(actualWeatherReport.equals(expectedWeatherReport)) {
			System.out.println("Testcase passed");
		}
		else {
			System.out.println("Testcase failed");
		}



	}
	@Test
	public void Test_10() {
		
				Long path = when().
				
				get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:400,59.93823555,30.2668659740719)[amenity=cafe];out;").then().
				
				extract().path("elements[8].id");
				
				System.out.println(path);
//		System.out.println(resp.asString())
		
		
		
		
	    
//
//		List<String> list = new ArrayList<String>();
//		JSONArray array = obj.getJSONArray("interests");

//		String reportByID = resp.then().
//				contentType(ContentType.JSON).
//				extract().
//				path("weather[0].description");
//
//		System.out.println(reportByID);
//
//		String lon = String.valueOf(resp.
//				then().
//				contentType(ContentType.JSON).
//				extract().
//				path("coord.lon"));
//		System.out.println(lon);
//
//		String lat = String.valueOf(resp.
//				then().
//				contentType(ContentType.JSON).
//				extract().
//				path("coord.lat"));
//		System.out.println(lat);
//
//		String reportpByCordinate = given().
//				param("lon", lon).
//				param("lat", lat).
//				param("appid", "81ca09894232a6a30da403b6ad1f178e").
//				when().
//				get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:1000,55.752121,37.617664)[shop~%22.*%22];out;").
//				then().
//				contentType(ContentType.JSON).
//				extract().
//				path("elements.lat");
		
//		System.out.println(resp.asString());
//		Assert.assertEquals(reportByID, reportpByCordinate);

	}

}
