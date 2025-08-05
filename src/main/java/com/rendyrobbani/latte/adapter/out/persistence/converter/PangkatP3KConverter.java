package com.rendyrobbani.latte.adapter.out.persistence.converter;

import com.rendyrobbani.latte.domain.meta.PangkatP3K;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class PangkatP3KConverter implements AttributeConverter<PangkatP3K, String> {

	@Override
	public String convertToDatabaseColumn(PangkatP3K e) {
		if (e == null) return null;
		return e.getValue();
	}

	@Override
	public PangkatP3K convertToEntityAttribute(String value) {
		return PangkatP3K.fromValue(value);
	}

}