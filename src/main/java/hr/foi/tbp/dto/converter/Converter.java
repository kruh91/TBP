package hr.foi.tbp.dto.converter;

import java.util.Collection;
import java.util.List;

public interface Converter<SOURCE, TARGET> {

	TARGET convert(SOURCE source);
	
	List<TARGET> convertAll(Collection<SOURCE> source);
}
