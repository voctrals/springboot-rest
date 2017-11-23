package cn.voctrals.boot.core.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class ShortEmptyToNullConverter extends BidirectionalConverter<String, Short> {

	@Override
	public Short convertTo(String source, Type<Short> destinationType) {
		if ("".equals(source)) {
			return null;
		}
		
		return Short.parseShort(source);
	}

	@Override
	public String convertFrom(Short source, Type<String> destinationType) {
		if (source == null) {
			return null;
		}
		return String.valueOf(source);
	}

}
