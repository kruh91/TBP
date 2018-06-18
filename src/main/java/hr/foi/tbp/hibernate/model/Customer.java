package hr.foi.tbp.hibernate.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.envers.Audited;

import hr.foi.tbp.enums.CustomerType;
import hr.foi.tbp.hibernate.type.CustomerTypeUserType;

@Entity
@Audited
@Table(name = "customer")
@TypeDef(name = "CustomerTypeUserType", typeClass = CustomerTypeUserType.class)
public class Customer extends User {

	private CustomerType type;
	
	private Set<Permission> permissions = new HashSet<Permission>(0);
	
	public Customer() {
	}

	public Customer(Long id, String firstName, String lastName, String username, String password, String email, Boolean active, Boolean deleted, String modifiedByUsername,
			Timestamp modificationTime, Set<Permission> permissions, CustomerType type) {
		super(id, firstName, lastName, username, password, email, active, deleted, modifiedByUsername, modificationTime);
		this.type = type;
		this.permissions = permissions;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	@Type(type = "CustomerTypeUserType")
	public CustomerType getType() {
		return type;
	}
	
	public void setType(CustomerType type) {
		this.type = type;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "permission2customer", joinColumns = {
			@JoinColumn(name = "customer_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "permission_id", nullable = false) })
	public Set<Permission> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
