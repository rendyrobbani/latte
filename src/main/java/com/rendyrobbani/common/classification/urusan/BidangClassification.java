 package com.rendyrobbani.common.classification.urusan;

public interface BidangClassification extends UrusanClassification {

	String REGEX = "^(?!0.*|.\\.0{2}.*|X\\.\\d{2}.*|\\d\\.X{2}.*)(X|\\d)\\.(XX|\\d{2})$";

	String getBidangCode();

}