package hr.foi.tbp.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.foi.tbp.dto.PermissionDTO;
import hr.foi.tbp.dto.converter.PermissionDTOConverter;
import hr.foi.tbp.facade.PermissionFacade;
import hr.foi.tbp.hibernate.model.Permission;
import hr.foi.tbp.service.PermissionService;

@Component("permissionFacade")
public class PermissionFacadeImpl implements PermissionFacade {

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private PermissionDTOConverter permissionDTOConverter;
	
	@Override
	public List<PermissionDTO> getPermissions() {
		return permissionDTOConverter.convertAll(permissionService.getPermissions());
	}

	@Override
	public PermissionDTO getPermissionById(Long id) {
		Permission permission = permissionService.getPermissionById(id);
		if(permission != null) {
			return permissionDTOConverter.convert(permission);
		}
		return null;
	}

	@Override
	public List<PermissionDTO> getPermissionsByUserId(Long id) {
		return permissionDTOConverter.convertAll(permissionService.getPermissionsByUserId(id));
	}

	@Override
	public List<PermissionDTO> getNonAssignedPermissionsForUser(Long userId) {
		return permissionDTOConverter.convertAll(permissionService.getNonAssignedPermissionsForUser(userId));
	}

}
