package com.rendyrobbani.latte.domain.model.valueobject.classification.fungsi;

import com.rendyrobbani.latte.domain.model.valueobject.classification.Classification;

public interface FungsiClassification extends Classification {

	String VALUE = "(\\d{2})";
	String REGEX = "^" + VALUE + "$";

	String getFungsiCode();

}