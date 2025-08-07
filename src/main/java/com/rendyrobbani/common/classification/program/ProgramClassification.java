package com.rendyrobbani.common.classification.program;

import com.rendyrobbani.common.classification.urusan.BidangClassification;

public interface ProgramClassification extends BidangClassification {

	String REGEX = "^(?!0.*|.\\.0{2}.*|X\\.\\d{2}.*|\\d\\.X{2}.*)(X|\\d)\\.(XX|\\d{2})\\.(?!0{2})(\\d{2})$";

	String getProgramCode();

}