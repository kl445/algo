package virus;

public class Corona extends Virus{

	private String spreadSpeece;

	public Corona(String name, int level) {
		super(name,level);
	}

	public Corona(String name, int level,String spreadSpeece) {
		super(name, level);
		this.spreadSpeece = spreadSpeece;
	}

	public String getSpreadSpeece() {
		return spreadSpeece;
	}

	public void setSpreadSpeece(String spreadSpeece) {
		this.spreadSpeece = spreadSpeece;
	}

	@Override
	public String toString() {
		return "Corona [spreadSpeece=" + spreadSpeece + "]";
	}
	
	
}
