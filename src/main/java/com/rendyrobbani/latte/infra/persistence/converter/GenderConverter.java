package com.rendyrobbani.latte.infra.persistence.converter;

import com.rendyrobbani.latte.common.vo.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class GenderConverter implements AttributeConverter<Gender, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Gender gender) {
		if (gender == null) return null;
		return gender.getValue();
	}

	@Override
	public Gender convertToEntityAttribute(Integer value) {
		if (value == null) return null;
		return Gender.fromValue(value);
	}

}