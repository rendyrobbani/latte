package com.rendyrobbani.latte.adapter.out.persistence.converter;

import com.rendyrobbani.latte.domain.meta.PangkatPNS;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class PangkatPNSConverter implements AttributeConverter<PangkatPNS, String> {

	@Override
	public String convertToDatabaseColumn(PangkatPNS e) {
		if (e == null) return null;
		return e.getValue();
	}

	@Override
	public PangkatPNS convertToEntityAttribute(String value) {
		return PangkatPNS.fromValue(value);
	}

}