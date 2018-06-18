package hr.foi.tbp.dto.converter;

import org.springframework.stereotype.Component;

import hr.foi.tbp.dto.PermissionDTO;
import hr.foi.tbp.hibernate.model.Permission;

@Component("permissionDTOConverter")
public class PermissionDTOConverter extends AbstractConverter<Permission, PermissionDTO> {

	@Override
	public PermissionDTO convert(Permission source) {
		
		PermissionDTO target = new PermissionDTO();
		target.setId(source.getId());
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		
		return target;
	}
}
