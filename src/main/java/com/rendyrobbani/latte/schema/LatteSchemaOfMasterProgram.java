package com.rendyrobbani.latte.schema;

import com.rendyrobbani.common.schema.Constraint;
import com.rendyrobbani.common.schema.Schema;
import com.rendyrobbani.common.schema.SchemaFactory;
import com.rendyrobbani.common.schema.Table;
import com.rendyrobbani.latte.schema.specification.data.master.program.DataMasterProgramTable;
import com.rendyrobbani.latte.schema.specification.logs.master.program.LogsMasterProgramTable;
import com.rendyrobbani.latte.schema.specification.sipd.master.program.SIPDMasterProgramTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteSchemaOfMasterProgram {

	private static final String NAME = "MasterProgram";

	private static List<Table> tables;

	private static List<Table> getTables() {
		if (tables == null) {
			tables = new ArrayList<>();
			tables.add(DataMasterProgramTable.getTable());
			tables.add(LogsMasterProgramTable.getTable());
			tables.add(SIPDMasterProgramTable.getTable());
		}
		return tables;
	}

	private static List<Constraint> checks;

	private static List<Constraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.addAll(DataMasterProgramTable.getChecks());
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	private static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(DataMasterProgramTable.getForeignKeys());
			foreignKeys.addAll(LogsMasterProgramTable.getForeignKeys());
			foreignKeys.addAll(SIPDMasterProgramTable.getForeignKeys());
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