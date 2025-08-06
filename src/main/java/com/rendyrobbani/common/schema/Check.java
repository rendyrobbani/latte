package com.rendyrobbani.common.schema;

public interface Check extends Constraint {

	String getLogic();

	@Override
	default String getValue() {
		return "check (" + this.getLogic() + ")";
	}

}