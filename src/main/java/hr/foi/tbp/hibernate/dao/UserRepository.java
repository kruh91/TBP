package hr.foi.tbp.hibernate.dao;

import hr.foi.tbp.hibernate.model.User;

public interface UserRepository extends AbstractJpaRepository<User, Long> {

	User findByUsername(String username);

	User findByIdAndDeletedFalse(Long id);
}
