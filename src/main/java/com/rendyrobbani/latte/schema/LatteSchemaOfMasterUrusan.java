package com.rendyrobbani.latte.schema;

import com.rendyrobbani.common.schema.Constraint;
import com.rendyrobbani.common.schema.Schema;
import com.rendyrobbani.common.schema.SchemaFactory;
import com.rendyrobbani.common.schema.Table;
import com.rendyrobbani.latte.schema.specification.data.master.urusan.DataMasterUrusanTable;
import com.rendyrobbani.latte.schema.specification.data.master.urusan.DataMasterBidangTable;
import com.rendyrobbani.latte.schema.specification.logs.master.urusan.LogsMasterUrusanTable;
import com.rendyrobbani.latte.schema.specification.logs.master.urusan.LogsMasterBidangTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteSchemaOfMasterUrusan {

	private static final String NAME = "MasterUrusan";

	private static List<Table> tables;

	private static List<Table> getTables() {
		if (tables == null) {
			tables = new ArrayList<>();
			tables.add(DataMasterUrusanTable.getTable());
			tables.add(LogsMasterUrusanTable.getTable());
			tables.add(DataMasterBidangTable.getTable());
			tables.add(LogsMasterBidangTable.getTable());
		}
		return tables;
	}

	private static List<Constraint> checks;

	private static List<Constraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.addAll(DataMasterUrusanTable.getChecks());
			checks.addAll(DataMasterBidangTable.getChecks());
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	private static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(DataMasterUrusanTable.getForeignKeys());
			foreignKeys.addAll(LogsMasterUrusanTable.getForeignKeys());
			foreignKeys.addAll(DataMasterBidangTable.getForeignKeys());
			foreignKeys.addAll(LogsMasterBidangTable.getForeignKeys());
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
				NAME,
				getTables(),
				getChecks(),
				getForeignKeys(),
				getUniqueKeys()
		);
		return schema;
	}

}