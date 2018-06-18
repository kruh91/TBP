package hr.foi.tbp.service;

import java.util.List;

import hr.foi.tbp.hibernate.model.Permission;

public interface PermissionService {

	List<Permission> getPermissions();
	
	Permission getPermissionById(Long id);
	
	List<Permission> getPermissionsByUserId(Long id);
	
	List<Permission> getNonAssignedPermissionsForUser(Long userId);
}
