package com.rendyrobbani.latte.app.migration;

public abstract class Migration {

	protected static final String FROM_SCHEMA = "espresso_2025_main";

	public abstract void migrateData(String fromSchema, String fromTable);

	public void migrateData(String fromTable) {
		migrateData(FROM_SCHEMA, fromTable);
	}

}