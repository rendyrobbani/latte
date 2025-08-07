package com.rendyrobbani.latte.schema;

import com.rendyrobbani.common.schema.Constraint;
import com.rendyrobbani.common.schema.Schema;
import com.rendyrobbani.common.schema.SchemaFactory;
import com.rendyrobbani.common.schema.Table;
import com.rendyrobbani.latte.schema.specification.data.user.DataUserTable;
import com.rendyrobbani.latte.schema.specification.logs.user.LogsUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteSchemaOfUser {

	private static List<Table> tables;

	private static List<Table> getTables() {
		if (tables == null) {
			tables = new ArrayList<>();
			tables.add(DataUserTable.getTable());
			tables.add(LogsUserTable.getTable());
		}
		return tables;
	}

	private static List<Constraint> checks;

	private static List<Constraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.addAll(DataUserTable.getChecks());
			checks.addAll(LogsUserTable.getChecks());
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	private static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(DataUserTable.getForeignKeys());
			foreignKeys.addAll(LogsUserTable.getForeignKeys());
		}
		return foreignKeys;
	}

	private static List<Constraint> uniqueKeys;

	private static List<Constraint> getUniqueKeys() {
		if (uniqueKeys == null) uniqueKeys = new ArrayList<>();
		return uniqueKeys;
	}

	private static Schema schema;

	public static Schema getSchema() {
		if (schema == null) schema = SchemaFactory.create(
				"latte_user",
				getTables(),
				getChecks(),
				getForeignKeys(),
				getUniqueKeys()
		);
		return schema;
	}

}