package stepDefinition;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.AutoCloseableBDDSoftAssertions;
import utils.ConfigManager;

import static io.restassured.RestAssured.baseURI;

public class BaseSteps {

	protected static Response response;

	protected static RequestSpecification request;

	protected AutoCloseableBDDSoftAssertions soft = new AutoCloseableBDDSoftAssertions();

	protected ObjectMapper mapper = new ObjectMapper();

	protected String deleteIssue;
	protected String allUsersEndpoint;
	protected String issueEndpoint;
	protected String userEndpoint;
	protected String findUsersEndpoint;
	protected String recentProjectEndpoint;
	protected String projectEndpoint;
	protected String deleteIssueAttachmentEndpoint;
	protected static String attachmentId;

	protected String jiraUserName;
	protected String jiraToken;

	public BaseSteps() {
		baseURI = ConfigManager.getProperty("base.uri");
		allUsersEndpoint = ConfigManager.getProperty("api.all.users.endpoint");
		issueEndpoint = ConfigManager.getProperty("api.issue.endpoint");
		userEndpoint = ConfigManager.getProperty("api.user.endpoint");
		findUsersEndpoint = ConfigManager.getProperty("api.find.users.endpoint");
		recentProjectEndpoint = ConfigManager.getProperty("api.recent.project.endpoint");
		projectEndpoint = ConfigManager.getProperty("api.project.endpoint");
		deleteIssueAttachmentEndpoint = ConfigManager.getProperty("api.delete.issue.attachment.endpoint");
		jiraUserName = System.getenv("jiraUserName");
		jiraToken = System.getenv("jiraToken");
		deleteIssue= ConfigManager.getProperty("api.delete.issue.endpoint");

	}

}
