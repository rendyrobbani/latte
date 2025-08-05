package com.rendyrobbani.latte.common.schema.core;

public interface Check extends Constraint {

	String getLogic();

	@Override
	default String getValue() {
		return "check (" + this.getLogic() + ")";
	}

}