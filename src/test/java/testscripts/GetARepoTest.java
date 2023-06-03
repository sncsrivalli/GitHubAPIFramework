package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.IConstantEndPointsPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetARepoTest extends BaseClass {

	@Test
	public void getARepoTest() {
		
		Response response = given()
								.pathParam("owner", property.fetchParameter("owner"))
								.pathParam("repo", property.fetchParameter("repo"))
							.when()
								.get(IConstantEndPointsPath.GET_A_REPO);
		response.then()
					.log().all()
					.assertThat()
						.statusCode(200)
						.contentType(ContentType.JSON);
		
		Assert.assertEquals(response.jsonPath().get("name"), property.fetchParameter("repo"));
		
	}
}
