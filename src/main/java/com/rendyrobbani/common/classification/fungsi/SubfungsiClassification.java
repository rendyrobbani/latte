package com.rendyrobbani.common.classification.fungsi;

import com.rendyrobbani.common.classification.Classification;

public interface SubfungsiClassification extends Classification {

	String VALUE = FungsiClassification.VALUE + "\\." + "(\\d{2})";
	String REGEX = "^" + VALUE + "$";

	String getFungsiCode();

	String getSubfungsiCode();

}