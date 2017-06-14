package com.nutritracker.common.utils;

import javax.persistence.AttributeConverter;

public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {
	
	@Override
	public String convertToDatabaseColumn(Boolean value) {
		return (value == null || !value) ? "N" : "Y";
	}

	@Override
	public Boolean convertToEntityAttribute(String value) {
		return "Y".equals(value);
	}
	
}
