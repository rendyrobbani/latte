package com.rendyrobbani.common.classification.fungsi;

import com.rendyrobbani.common.classification.Classification;

public interface FungsiClassification extends Classification {

	String VALUE = "(\\d{2})";
	String REGEX = "^" + VALUE + "$";
	String MARIADB_VALUE = "([0-9]{2})";
	String MARIADB_REGEX = "^" + MARIADB_VALUE + "$";

	String getFungsiCode();

}