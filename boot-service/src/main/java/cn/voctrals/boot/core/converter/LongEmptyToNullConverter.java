package cn.voctrals.boot.core.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class LongEmptyToNullConverter extends BidirectionalConverter<String, Long> {

	@Override
	public Long convertTo(String source, Type<Long> destinationType) {
		if ("".equals(source)) {
			return null;
		}
		
		return Long.parseLong(source);
	}

	@Override
	public String convertFrom(Long source, Type<String> destinationType) {
		if (source == null) {
			return null;
		}
		return String.valueOf(source);
	}

}
