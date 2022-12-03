package support;

public class Woman implements Person{
	private String gender;
	
	public Woman() {
		this.gender = "Woman";
	}
	
	@Override
	public String getGender() {
		return gender;
	}
}