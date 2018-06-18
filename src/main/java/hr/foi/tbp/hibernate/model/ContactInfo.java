package hr.foi.tbp.hibernate.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.envers.Audited;

import hr.foi.tbp.hibernate.type.AddressUserType;

@Entity
@Audited
@Table(name = "contact_info")
@TypeDef(name = "AddressUserType", typeClass = AddressUserType.class)
public class ContactInfo extends Item {

	private String username;

	private Address address;

	private String phone;

	private String mobile;

	public ContactInfo() {
	}

	public ContactInfo(Long id, String username, String modifiedByUsername, Timestamp modificationTime) {
		super(id, modifiedByUsername, modificationTime);
		this.username = username;
	}

	public ContactInfo(Long id, String username, Address address, String modifiedByUsername, String phone, String mobile,
			Timestamp modificationTime) {
		super(id, modifiedByUsername, modificationTime);
		this.username = username;
		this.phone = phone;
		this.mobile = mobile;
		this.address = address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "address")
	@Type(type = "AddressUserType")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "phone", length = 50)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "mobile_phone", length = 50)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
