package com.rendyrobbani.latte.domain.model.valueobject.classification;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassificationImpl implements Classification {

	protected int type;

	protected final List<String> codes;

	@Override
	public void setTypeToJoin() {
		this.type = TYPE_JOIN;
	}

	@Override
	public void setTypeToPart() {
		this.type = TYPE_PART;
	}

	protected String getCode(int index) {
		if (this.type == TYPE_PART) return this.codes.get(index);
		var code = new ArrayList<String>();
		for (int i = 0; i <= index; i++) code.add(this.codes.get(i));
		return String.join(".", code);
	}

	protected ClassificationImpl(List<String> codes) {
		this.type = TYPE_JOIN;
		this.codes = codes;
	}

}