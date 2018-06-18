package hr.foi.tbp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.foi.tbp.hibernate.dao.PermissionRepository;
import hr.foi.tbp.hibernate.model.Permission;
import hr.foi.tbp.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public List<Permission> getPermissions() {
		return permissionRepository.findAll();
	}

	@Override
	public Permission getPermissionById(Long id) {
		return permissionRepository.findOne(id);
	}

	@Override
	public List<Permission> getPermissionsByUserId(Long id) {
		return permissionRepository.findPermissionByUsersId(id);
	}

	@Override
	public List<Permission> getNonAssignedPermissionsForUser(Long userId) {
		return permissionRepository.findPermissionByUsersIdNot(userId);
	}

}
