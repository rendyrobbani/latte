package com.rendyrobbani.latte.adapter.out.persistence.converter;

import com.rendyrobbani.latte.domain.meta.PangkatASN;
import com.rendyrobbani.latte.domain.meta.PangkatP3K;
import com.rendyrobbani.latte.domain.meta.PangkatPNS;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class PangkatASNConverter implements AttributeConverter<PangkatASN, String> {

	@Override
	public String convertToDatabaseColumn(PangkatASN e) {
		if (e == null) return null;
		return e.getValue();
	}

	@Override
	public PangkatASN convertToEntityAttribute(String value) {
		PangkatASN e;
		e = PangkatPNS.fromValue(value);
		if (e != null) return e;
		e = PangkatP3K.fromValue(value);
		return e;
	}

}