package com.rendyrobbani.latte.adapter.out.persistence.converter;

import com.rendyrobbani.latte.domain.meta.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class GenderConverter implements AttributeConverter<Gender, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Gender e) {
		if (e == null) return null;
		return e.getValue();
	}

	@Override
	public Gender convertToEntityAttribute(Integer value) {
		return Gender.fromValue(value);
	}

}