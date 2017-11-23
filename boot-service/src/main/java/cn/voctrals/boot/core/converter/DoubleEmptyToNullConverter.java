package cn.voctrals.boot.core.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class DoubleEmptyToNullConverter extends BidirectionalConverter<String, Double> {

	@Override
	public Double convertTo(String source, Type<Double> destinationType) {
		if ("".equals(source)) {
			return null;
		}
		
		return Double.parseDouble(source);
	}

	@Override
	public String convertFrom(Double source, Type<String> destinationType) {
		if (source == null) {
			return null;
		}
		return String.valueOf(source);
	}

}
