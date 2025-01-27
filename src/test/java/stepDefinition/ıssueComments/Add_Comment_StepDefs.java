package stepDefinition.ıssueComments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepDefinition.BaseSteps;
import utils.APIutils;
import utils.TestDataReader;

public class Add_Comment_StepDefs extends BaseSteps {

	private static final Logger LOGGER = LogManager.getLogger(Add_Comment_StepDefs.class);

	@When("the user sends  GET request to Add Comments endpoint with specific key as {string}")
	public void theUserSendsGetRequestToAddCommentsEndpointWithSpecificKeyAs(String key) {

		String endPoint = issueEndpoint + "/" + key + "/comment";
		String body = TestDataReader.readData2("add-comment.json");
		response = APIutils.sendPostRequest(request, endPoint, body);
		commentText = response.jsonPath().getString("id");
		LOGGER.info("The user sends POST request to Add Comment endPoint with specific issue");
	}

	@And("the response text should be {string}")
	public void theResponseTextShouldBe(String arg0) {

		Assertions.assertThat(response.jsonPath().getString("body.content.content.text").contains(arg0))
			.isEqualTo(true);
	}

}
