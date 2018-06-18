package hr.foi.tbp.hibernate.dao;

import java.util.List;

import hr.foi.tbp.hibernate.model.Permission;

public interface PermissionRepository extends AbstractJpaRepository<Permission, Long> {

	List<Permission> findPermissionByUsersId(Long id);
	
	List<Permission> findPermissionByUsersIdNot(Long id);
}
