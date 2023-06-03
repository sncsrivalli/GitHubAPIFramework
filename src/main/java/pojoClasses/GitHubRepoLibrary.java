package pojoClasses;

public class GitHubRepoLibrary {

	private String name;
	private String description;
	private String homepage;
	private boolean repoScope;
	
	public GitHubRepoLibrary() {}
	
	public GitHubRepoLibrary(String name, String description, String homepage, boolean repoScope) {
		super();
		this.name = name;
		this.description = description;
		this.homepage = homepage;
		this.repoScope = repoScope;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public boolean isRepoScope() {
		return repoScope;
	}

	public void setRepoScope(boolean repoScope) {
		this.repoScope = repoScope;
	}
	
	
}
