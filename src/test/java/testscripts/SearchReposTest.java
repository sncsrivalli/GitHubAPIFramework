package testscripts;

import org.testng.annotations.Test;

import genericLibraries.IConstantEndPointsPath;

import static io.restassured.RestAssured.*;

public class SearchReposTest extends BaseClass {

	@Test
	public void searchReposTest() {
		
		given()
			.queryParam("q", property.fetchParameter("q"))
			.queryParam("order", property.fetchParameter("order"))
		.when()
			.get(IConstantEndPointsPath.SEARCH_REPOS)
		.then()
			.log().all()
			.assertThat()
				.statusCode(200);
	}
}
