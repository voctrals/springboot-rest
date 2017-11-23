package cn.voctrals.boot.core.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEmptyToNullConverter extends BidirectionalConverter<String, Date> {

	@Override
	public Date convertTo(String source, Type<Date> destinationType) {
		if ("".equals(source)) {
			return null;
		}

		try {
			return new SimpleDateFormat("yyyyMMdd").parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String convertFrom(Date source, Type<String> destinationType) {
		if (source == null) {
			return null;
		}
		return String.valueOf(source);
	}

}
