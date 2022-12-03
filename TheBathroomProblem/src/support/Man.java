package support;

public class Man implements Person{
	private String gender;
	
	public Man() {
		this.gender = "Man";
	}
	
	@Override
	public String getGender() {
		return gender;
	}
}