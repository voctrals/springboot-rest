package cn.voctrals.boot.core.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class IntegerEmptyToNullConverter extends BidirectionalConverter<String, Integer> {

	@Override
	public Integer convertTo(String source, Type<Integer> destinationType) {
		if ("".equals(source)) {
			return null;
		}
		
		return Integer.parseInt(source);
	}

	@Override
	public String convertFrom(Integer source, Type<String> destinationType) {
		if (source == null) {
			return null;
		}
		return String.valueOf(source);
	}

}
