package steps;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getNumViews {
	Response RS;
	RequestSpecification RQ;
	List<String> numOfViewsList;

	@Given("I am a user")
	public void i_am_a_user() {

		RQ = given().header("User-Agent", "PostmanRuntime/7.28.4");
	}

	@When("I send request to colourlovers api")
	public void i_send_request_to_colourlovers_api() {

		RS = RQ.get("http://www.colourlovers.com/api/patterns");

		assertEquals(RS.statusCode(), 200);
	}

	@Then("I can get the number of views for each pattern")
	public void I_can_get_the_number_of_views_for_each_pattern() {

		numOfViewsList = RS.xmlPath().getList("patterns.pattern.numViews");

		assertFalse(numOfViewsList.isEmpty());
	}

	@And("the number of views is greater than {int}")
	public void the_number_of_views_is_greater_than(int number) {

		for (int i = 0; i < numOfViewsList.size(); i++) {
			int Viewsnum = Integer.parseInt(RS.xmlPath().getString("patterns.pattern.numViews[" + i + "]"));
			assertTrue(Viewsnum > number);

		}

	}

}
