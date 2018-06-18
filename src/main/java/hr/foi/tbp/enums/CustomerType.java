package hr.foi.tbp.enums;

public enum CustomerType {

	STANDARD("STANDARD"),
	
	GOLDEN("GOLDEN"),
	
	PLATINUM("PLATINUM");
	
	private String value;
	
	private CustomerType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
