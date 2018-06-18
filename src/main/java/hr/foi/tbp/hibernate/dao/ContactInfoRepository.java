package hr.foi.tbp.hibernate.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import hr.foi.tbp.hibernate.model.ContactInfo;

public interface ContactInfoRepository extends AbstractJpaRepository<ContactInfo, Long> {
	
	List<ContactInfo> findByUsername(@Param("username") String username);
}
