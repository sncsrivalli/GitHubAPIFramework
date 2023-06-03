package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.IConstantEndPointsPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ListReposForUserTest extends BaseClass {

	@Test
	public void getReposForUserTest() {
		
		Response response = given()
								.pathParam("username", property.fetchParameter("username"))
								.queryParam("sort", property.fetchParameter("sort"))
								.queryParam("direction", property.fetchParameter("direction"))
							.when()
								.get(IConstantEndPointsPath.GET_USER_REPOS);
		response.then()
					.log().all()
					.assertThat()
						.statusCode(200)
						.contentType(ContentType.JSON);
		
		Assert.assertEquals(response.jsonPath().get("[0].owner.login"), property.fetchParameter("username"));
	}
}
