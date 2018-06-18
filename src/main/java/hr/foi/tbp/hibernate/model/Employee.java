package hr.foi.tbp.hibernate.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "employee")
public class Employee extends User {

	private String department;
	
	public Employee() {
	}
	
	public Employee(Long id, String firstName, String lastName, String username, String password, String email, Boolean active, Boolean deleted, String department, String modifiedByUsername,
			Timestamp modificationTime) {
		super(id, firstName, lastName, username, password, email, active, deleted, modifiedByUsername, modificationTime);
		this.department = department;
	}

	@Column(name = "department", nullable = false, length = 255)
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
}
