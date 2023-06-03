package testscripts;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import genericLibraries.IConstantEndPointsPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesUtility;
import static io.restassured.RestAssured.*;

public class BaseClass {

	PropertiesUtility property;
	JavaUtility jutil;
	
	@BeforeMethod
	public void methodConfig() {
		property = new PropertiesUtility();
		jutil = new JavaUtility();
		
		property.propertiesInit(IConstantEndPointsPath.PROPERTIES_PATH);
		
		baseURI = "https://api.github.com";
	}
	
	@AfterMethod
	public void methodTearDown() {
		Reporter.log("Request Ended", true);
	}
}
