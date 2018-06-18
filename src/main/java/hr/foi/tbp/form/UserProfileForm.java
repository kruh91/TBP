package hr.foi.tbp.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import hr.foi.tbp.enums.CustomerType;

public class UserProfileForm {

	private Long id;

	@NotNull(message="Obavezno polje")
	@Size(min=1, message = "Obavezno polje")
	private String firstName;

	@NotNull(message="Obavezno polje")
	@Size(min=1, message = "Obavezno polje")
	private String lastName;

	@NotNull(message="Obavezno polje")
	@Size(min=1, message = "Obavezno polje")
	private String username;

	private String password;

	@NotNull(message="Obavezno polje")
	@Pattern(regexp=".+@.+\\.[a-z]+", message="Neispravna email adresa")
	private String email;

	private Boolean active;
	
	private Boolean deleted;
	
	@NotNull(message="Obavezno polje")
	private CustomerType type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}
	
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public CustomerType getType() {
		return type;
	}
	
	public void setType(CustomerType type) {
		this.type = type;
	}
}
