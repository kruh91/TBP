package hr.foi.tbp.hibernate.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "permission")
public class Permission extends Item {

	private String code;
	
	private String name;
	
	private String description;
	
	private Set<Customer> customers = new HashSet<Customer>(0);
	
	public Permission() {
	}
	
	public Permission(Long id, String code, String name, Set<Customer> customers, String modifiedByUsername,
			Timestamp modificationTime) {
		super(id, modifiedByUsername, modificationTime);
		this.id = id;
		this.code = code;
		this.name = name;
		this.customers = customers;
	}

	public Permission(Long id, String code, String name, String description, Set<Customer> customers, String modifiedByUsername,
			Timestamp modificationTime) {
		super(id, modifiedByUsername, modificationTime);
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.customers = customers;
	}

	@Column(name = "code", unique = true, nullable = false, length = 30)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", unique = true, nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Audited
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
	public Set<Customer> getUsers() {
		return customers;
	}

	public void setUsers(Set<Customer> customers) {
		this.customers = customers;
	}
}
