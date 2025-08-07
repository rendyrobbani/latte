package com.rendyrobbani.common.classification.fungsi;

import com.rendyrobbani.common.classification.Classification;

public interface FungsiClassification extends Classification {

	String VALUE = "([0-9]{2})";
	String REGEX = "^" + VALUE + "$";

	String getFungsiCode();

}