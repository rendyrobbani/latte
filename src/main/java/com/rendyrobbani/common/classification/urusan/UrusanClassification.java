package com.rendyrobbani.common.classification.urusan;

import com.rendyrobbani.common.classification.Classification;

public interface UrusanClassification extends Classification {

	String REGEX = "^(?!0)(X|\\d)$";

	String getUrusanCode();

}