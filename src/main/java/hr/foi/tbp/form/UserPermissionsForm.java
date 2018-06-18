package hr.foi.tbp.form;

import java.util.List;

public class UserPermissionsForm {

	private Long userId;
	
	private List<Long> permissions;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public List<Long> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(List<Long> permissions) {
		this.permissions = permissions;
	}
}
