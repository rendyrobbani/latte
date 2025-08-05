package com.rendyrobbani.latte.adapter.out.persistence.converter;

import com.rendyrobbani.latte.domain.model.valueobject.NIP;
import com.rendyrobbani.latte.domain.model.valueobject.NIPFactory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class NIPConverter implements AttributeConverter<NIP, String> {

	@Override
	public String convertToDatabaseColumn(NIP e) {
		if (e == null) return null;
		return e.getValue();
	}

	@Override
	public NIP convertToEntityAttribute(String value) {
		if (value == null) return null;
		return NIPFactory.parse(value);
	}

}