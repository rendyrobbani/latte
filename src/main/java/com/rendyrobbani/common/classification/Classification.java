package com.rendyrobbani.common.classification;

public interface Classification {

	String COMMON_SEPARATOR = "\\.";
	String MARIADB_SEPARATOR = COMMON_SEPARATOR.replaceAll("\\\\\\.", "\\\\\\\\.");
	int TYPE_JOIN = 1;
	int TYPE_PART = 2;

	void setTypeToJoin();

	void setTypeToPart();

}