package hr.foi.tbp.hibernate.type;

import hr.foi.tbp.enums.CustomerType;

public class CustomerTypeUserType extends PostgreEnumUserType<CustomerType> {

	public CustomerTypeUserType() {
		super(CustomerType.class);
	}

	@Override
	public int[] sqlTypes() {
	    return new int[] {25000};
	}
}
