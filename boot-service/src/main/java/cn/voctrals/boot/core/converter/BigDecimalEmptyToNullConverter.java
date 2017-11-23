package cn.voctrals.boot.core.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.math.BigDecimal;

public class BigDecimalEmptyToNullConverter extends BidirectionalConverter<String, BigDecimal> {

	@Override
	public BigDecimal convertTo(String source, Type<BigDecimal> destinationType) {
		if ("".equals(source)) {
			return null;
		}
		
		return new BigDecimal(source);
	}

	@Override
	public String convertFrom(BigDecimal source, Type<String> destinationType) {
		if (source == null) {
			return null;
		}
		return String.valueOf(source);
	}

}
