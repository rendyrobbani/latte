package com.rendyrobbani.latte.domain.model.valueobject.classification;

public interface Classification {

	int TYPE_JOIN = 1;
	int TYPE_PART = 2;

	void setTypeToJoin();

	void setTypeToPart();

}