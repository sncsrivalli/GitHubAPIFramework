package testscripts;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.IConstantEndPointsPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ListReposForAuthUserTest extends BaseClass{

	@Test
	public void getReposForAuthUserTest() {
		
		Response response = given()
								.auth()
									.oauth2(property.fetchParameter("token"))
							.when()
								.get(IConstantEndPointsPath.GET_AUTH_USER_REPOS);
		
		response.then()
					.log().all()
					.assertThat()
						.statusCode(200)
						.contentType(ContentType.JSON);
		
		Assert.assertEquals(response.jsonPath().get("[0].owner.login"),property.fetchParameter("username"));
	}
}
