package hr.foi.tbp.facade;

import java.util.List;

import hr.foi.tbp.dto.PermissionDTO;

public interface PermissionFacade {

	List<PermissionDTO> getPermissions();

	PermissionDTO getPermissionById(Long id);
	
	List<PermissionDTO> getPermissionsByUserId(Long id);
	
	List<PermissionDTO> getNonAssignedPermissionsForUser(Long userId);
}
