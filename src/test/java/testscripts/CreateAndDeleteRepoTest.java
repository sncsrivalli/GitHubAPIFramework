package testscripts;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import genericLibraries.IConstantEndPointsPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClasses.GitHubRepoLibrary;

public class CreateAndDeleteRepoTest extends BaseClass {

	@Test
	public void createAndDeleteRepoTest() {
		String repoName = property.fetchParameter("repoName") + jutil.generateRandomNumber(50);

		GitHubRepoLibrary repoObj = new GitHubRepoLibrary(repoName, 
				property.fetchParameter("description"),
				property.fetchParameter("homepage"), 
				Boolean.parseBoolean(property.fetchParameter("private")));
		
		Response response = given()
								.auth()
									.oauth2(property.fetchParameter("token"))
									.body(repoObj)
									.contentType(ContentType.JSON)
							.when()
								.post(IConstantEndPointsPath.CREATE_REPO);
		response.then()
					.log().all()
					.assertThat()
						.statusCode(201);
		
		String repo = response.jsonPath().get("name");
		
		given()
			.auth()
				.oauth2(property.fetchParameter("token"))
			.pathParam("owner", property.fetchParameter("owner"))
			.pathParam("repo", repo)
		.when()
			.delete(IConstantEndPointsPath.DELETE_A_REPO)
		.then()
			.log().all()
			.assertThat()
				.statusCode(204);
	}
}
