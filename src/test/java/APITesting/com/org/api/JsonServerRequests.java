package APITesting.com.org.api;

import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

import APITesting.com.org.classes.Info;
import APITesting.com.org.classes.Posts;
import APITesting.com.org.classes._Post;

import static com.jayway.restassured.RestAssured.*;

import static org.hamcrest.Matchers.lessThan;


public class JsonServerRequests {
	// Get  /posts
//	@Test
	public void test_01() {
		Response resp = given().
		when().
		get("http://localhost:3000/posts");
		
		System.out.println("Get response is : "+resp.asString());
	}
	// Post  /posts
//	@Test
	public void test_02() {
		Response resp = given().
	    body("   {\"id\":\"2\",\"title\":\"dummytitle\",\"author\":\"Vaiqu\"}  ").
		when().
		contentType(ContentType.JSON).
		post("http://localhost:3000/posts");
		
		System.out.println("Post response is : "+resp.asString());
	}
//	 Post request using object
//	@Test
	public void test_03() {
		Posts posts = new Posts();
		posts.setId("4");
		posts.setTitle("posts request by object");
		posts.setAuthor("Norayr");
		
		Response resp = given().
		when().
		contentType(ContentType.JSON).
		body(posts).
		post("http://localhost:3000/posts");
		
		System.out.println("response : "+resp.asString());
		
		
	}
	
//	@Test
	public void test_04() {
		Response resp = given().
		when().
		get("http://localhost:3000/posts/3");
		
		
		System.out.println(resp.asString());
	}
// Put request	
//	@Test
	public void test_05() {
		Posts posts = new Posts();
		posts.setId("3");
		posts.setAuthor("updated author name");
		posts.setTitle("updated title name");
		Response resp = given().
		when().
		contentType(ContentType.JSON).
		body(posts).
		put("http://localhost:3000/posts/3");
		
		
		System.out.println(resp.asString());
	}
//	Patch request
//	@Test
	public void test_06() {
		
		Response resp = given().
		when().
		contentType(ContentType.JSON).
		body("{ \"title\": \"updated title with PATCH\"}").
		patch("http://localhost:3000/posts/3");
		
		
		System.out.println(resp.asString());
	}
	
//	@Test
	public void test_07() {
		
		Response resp = given().
		when().
		delete("http://localhost:3000/posts/sIZlnhU");
		
		
		System.out.println(resp.asString());
	}
	
//	complex POSTS
//	@Test
	public void test_08() {
		Info info = new Info();
		info.setEmail("info@appium-selenium.com");
		info.setPhone("111111");
		info.setAddress("Armenia");
		
		
		_Post posts = new _Post();
		posts.setAuthor("Author");
		posts.setId("10");
		posts.setTitle("title");
		posts.setInfo(info);
		
		
		Response resp = given().
		when().
		contentType(ContentType.JSON).
		body(posts).
		post("http://localhost:3000/posts");
		
		
		System.out.println(resp.asString());
	}
	
//	Get Request calculate Response time
//	Get  /posts
	
//	@Test
	public void test_10() {
		
		Response resp = given().
		when().
		get("http://localhost:3000/posts");
		
		Long time = resp.getTime();
		
		System.out.println("The response time is "+ time);
		
		
		ValidatableResponse x = given().
		when().
		get("http://localhost:3000/posts").
		then().
		and().
		time(lessThan(51L));
		
		
	}
	
}