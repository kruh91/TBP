package hr.foi.tbp.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * The Interface AbstractJpaRepository.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
@NoRepositoryBean
public interface AbstractJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	
	@Override
	<S extends T> List<S> save(Iterable<S> entities);
	
	@Override
	<S extends T> S save(S arg0);
	
	@Override
	<S extends T> S saveAndFlush(S entity);

}
