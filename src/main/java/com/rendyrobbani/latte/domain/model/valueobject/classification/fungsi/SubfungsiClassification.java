package com.rendyrobbani.latte.domain.model.valueobject.classification.fungsi;

import com.rendyrobbani.latte.domain.model.valueobject.classification.Classification;

public interface SubfungsiClassification extends Classification {

	String VALUE = FungsiClassification.VALUE + "\\." + "(\\d{2})";
	String REGEX = "^" + VALUE + "$";

	String getFungsiCode();

	String getSubfungsiCode();

}