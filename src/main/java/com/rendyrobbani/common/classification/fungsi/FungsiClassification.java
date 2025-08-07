package com.rendyrobbani.common.classification.fungsi;

import com.rendyrobbani.common.classification.Classification;

public interface FungsiClassification extends Classification {

	String REGEX = "^(\\d{2})$";

	String getFungsiCode();

}