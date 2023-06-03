package testscripts;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import genericLibraries.IConstantEndPointsPath;
import io.restassured.http.ContentType;


public class UpdateRepoTest extends BaseClass {

	@Test
	public void updateRepoTest() {
		given()
			.auth()
				.oauth2(property.fetchParameter("token"))
			.pathParam("owner", property.fetchParameter("owner"))
			.pathParam("repo", property.fetchParameter("repo"))
			.formParam("description", "My repo")
			.formParam("private", true)
			.contentType(ContentType.JSON)
		.when()
			.patch(IConstantEndPointsPath.UPDATE_A_REPO)
		.then()
			.log().all()
			.assertThat()
				.statusCode(200);
	}
}
