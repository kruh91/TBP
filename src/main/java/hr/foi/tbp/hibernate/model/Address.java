package hr.foi.tbp.hibernate.model;

public class Address {

	private String country;

	private String town;

	private String postalCode;

	private String address;

	public Address() {

	}

	public Address(String value) {
		value = value.substring(1,value.length()-1);
        String[] splitted = value.split(",");
        country = removeQuotation(splitted[0]);
        town = removeQuotation(splitted[1]);
        postalCode = removeQuotation(splitted[2]);
        address = removeQuotation(splitted[3]);
	}

	public Address(String country, String town, String postalCode, String address) {
		super();
		this.country = country;
		this.town = town;
		this.postalCode = postalCode;
		this.address = address;
	}
	
	@Override
    public String toString() {
        return "(" + country + "," + town + "," + postalCode + "," + address + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((town == null) ? 0 : town.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (town == null) {
            if (other.town != null)
                return false;
        } else if (!town.equals(other.town))
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
    }

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String  removeQuotation(String field) {
		String result = field;
		
		if(result.startsWith("\"")) {
			result = result.substring(1);
		}
		
		if(result.endsWith("\"")) {
			result = result.substring(0, result.length() - 1);
		}
		
		return result;
	}
}
