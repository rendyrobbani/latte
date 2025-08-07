 package com.rendyrobbani.common.classification.urusan;

public interface BidangClassification extends UrusanClassification {

	String VALUE = "(?!0.*|.\\.00.*|X\\.\\d.*|\\d\\.XX.*$)(X|\\d)\\.(XX|\\d{2})";
	String REGEX = "^" + VALUE + "$";

	String getBidangCode();

}