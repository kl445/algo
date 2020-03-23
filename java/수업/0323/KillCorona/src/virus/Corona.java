package virus;

public class Corona extends Virus{

	private String spreadSpeece;

	public Corona() {
	}

	public Corona(String spreadSpeece) {
		super();
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
