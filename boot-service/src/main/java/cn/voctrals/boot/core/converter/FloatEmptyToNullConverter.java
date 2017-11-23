package cn.voctrals.boot.core.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class FloatEmptyToNullConverter extends BidirectionalConverter<String, Float> {

	@Override
	public Float convertTo(String source, Type<Float> destinationType) {
		if ("".equals(source)) {
			return null;
		}
		
		return Float.parseFloat(source);
	}

	@Override
	public String convertFrom(Float source, Type<String> destinationType) {
		if (source == null) {
			return null;
		}
		return String.valueOf(source);
	}

}
