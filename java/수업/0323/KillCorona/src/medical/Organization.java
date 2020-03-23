package medical;

public class Organization {

	private String name;
	private int employeeCount;
	//기본 생성자 및 멤버변수를 매개변수로 받는 생성자를 추가하세요.
	public Organization() {
	}
	public Organization(String name, int employeeCount) {
		this.name = name;
		this.employeeCount = employeeCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	public void about() {
		System.out.println("Organization : "+name);
	}
	@Override
	public String toString() {
		return "Organization [name=" + name + ", employeeCount=" + employeeCount + "]";
	}
	
	
	
	//기본 인캡슐레이션 적용
	
}
