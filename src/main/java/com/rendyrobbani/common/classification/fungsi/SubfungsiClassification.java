package com.rendyrobbani.common.classification.fungsi;

public interface SubfungsiClassification extends FungsiClassification {

	String REGEX = "^(?!00\\.0[1-9]|00\\.[1-9][0-9]|0[1-9]\\.00|[1-9][0-9]\\.00)(\\d{2})\\.(\\d{2})$";

	String getSubfungsiCode();

}