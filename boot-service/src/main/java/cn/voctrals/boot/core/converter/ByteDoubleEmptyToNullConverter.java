package cn.voctrals.boot.core.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class ByteDoubleEmptyToNullConverter extends BidirectionalConverter<String, Byte> {

	@Override
	public Byte convertTo(String source, Type<Byte> destinationType) {
		if ("".equals(source)) {
			return null;
		}
		
		return Byte.parseByte(source);
	}

	@Override
	public String convertFrom(Byte source, Type<String> destinationType) {
		if (source == null) {
			return null;
		}
		return String.valueOf(source);
	}

}
