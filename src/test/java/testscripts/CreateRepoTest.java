package testscripts;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.IConstantEndPointsPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClasses.GitHubRepoLibrary;

public class CreateRepoTest extends BaseClass {

	@Test
	public void createRepoForAuthUserTest() {

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
		
		Assert.assertEquals(response.jsonPath().get("name"),repoName);
	}
}
