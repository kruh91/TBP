package hr.foi.tbp.dto;

import hr.foi.tbp.enums.CustomerType;

public class CustomerDTO extends UserDTO {

	private CustomerType type;
	
	public CustomerDTO() {
		super();
	}
	
	public CustomerType getType() {
		return type;
	}
	
	public void setType(CustomerType type) {
		this.type = type;
	}
}
