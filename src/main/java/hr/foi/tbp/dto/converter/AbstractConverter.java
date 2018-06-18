package hr.foi.tbp.dto.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

public abstract class AbstractConverter<SOURCE, TARGET> implements Converter<SOURCE, TARGET> {

	@Override
	public List<TARGET> convertAll(Collection<SOURCE> sourceList) {

		List<TARGET> targetList = new ArrayList<>();
		
		if (CollectionUtils.isNotEmpty(sourceList)) {
			for (SOURCE source : sourceList) {
				targetList.add(convert(source));
			}
		}
		
		return targetList;
	}
}
