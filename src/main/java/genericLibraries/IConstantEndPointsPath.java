package genericLibraries;

public interface IConstantEndPointsPath {

	String CREATE_REPO = "/user/repos";
	String GET_AUTH_USER_REPOS = "/user/repos";
	String GET_USER_REPOS = "/users/{username}/repos";
	String GET_A_REPO = "/repos/{owner}/{repo}";
	String UPDATE_A_REPO = "/repos/{owner}/{repo}";
	String DELETE_A_REPO = "/repos/{owner}/{repo}";
	String SEARCH_REPOS = "/search/repositories";
	
	String PROPERTIES_PATH = System.getProperty("user.dir")+ "/src/test/resources/parameters.properties";
}
