package com.rendyrobbani.latte.common.schema.core;

public interface Constraint {

	Table getTable();

	String getName();

	String getValue();

	default String getDeleteDDL(boolean useIfExists) {
		return String.join(" ", "alter table", this.getTable().getName(), "drop constraint" + (useIfExists ? " if exists" : ""), this.getName()) + ";";
	}

	default String getDeleteDDL() {
		return this.getDeleteDDL(false);
	}

	default String getCreateDDL() {
		return String.join(" ", "alter table", this.getTable().getName(), "add constraint", this.getName(), this.getValue()) + ";";
	}

}