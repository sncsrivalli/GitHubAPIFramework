package testscripts;

import org.testng.annotations.Test;

import genericLibraries.IConstantEndPointsPath;

import static io.restassured.RestAssured.*;

public class DeleteRepoTest extends BaseClass {

	@Test
	public void deleteRepoTest() {
		
		given()
			.auth()
				.oauth2(property.fetchParameter("token"))
			.pathParam("owner", property.fetchParameter("owner"))
			.pathParam("repo", "API01")
		.when()
			.delete(IConstantEndPointsPath.DELETE_A_REPO)
		.then()
			.log().all()
			.assertThat()
				.statusCode(204);		
	}
}
