package com.rendyrobbani.common.classification.fungsi;

public interface SubfungsiClassification extends FungsiClassification {

	String VALUE = FungsiClassification.VALUE + "\\." + "([0-9]{2})";
	String REGEX = "^" + VALUE + "$";

	String getFungsiCode();

	String getSubfungsiCode();

}