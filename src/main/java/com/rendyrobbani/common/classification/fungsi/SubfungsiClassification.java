package com.rendyrobbani.common.classification.fungsi;

public interface SubfungsiClassification extends FungsiClassification {

	String VALUE = "(?!00\\.0[1-9]|00\\.[1-9][0-9]|0[1-9]\\.00|[1-9][0-9]\\.00)(\\d{2})\\.(\\d{2})";
	String REGEX = "^" + VALUE + "$";
	String MARIADB_VALUE = "(00.00|0[1-9].0[1-9]|0[1-9].[1-9][0-9]|[1-9][0-9].0[1-9]|[1-9][0-9].[1-9][0-9])";
	String MARIADB_REGEX = "^" + MARIADB_VALUE + "$";

	String getSubfungsiCode();

}