package com.rendyrobbani.latte.schema.specification.logs.master.program;

import com.rendyrobbani.common.schema.*;
import com.rendyrobbani.latte.schema.factory.LatteCheckFactory;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.LoggableTable;
import com.rendyrobbani.latte.schema.specification.base.master.program.MasterProgramTable;
import com.rendyrobbani.latte.schema.specification.data.master.program.DataMasterProgramTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsMasterProgramTable {

	public static final String NAME = "logs_master_program";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createBigInt("id", false, true, true));
			columns.addAll(MasterProgramTable.getColumns());
			columns.addAll(LoggableTable.getColumns());
			columns.add(LatteColumnFactory.copyOf("subject_id", DataMasterProgramTable.getTable().getId(), false));
		}
		return columns;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.create(NAME, getColumns());
		return table;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(MasterProgramTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.addAll(LoggableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					getTable(),
					getTable().findColumn("subject_id"),
					DataMasterProgramTable.getTable(),
					DataMasterProgramTable.getTable().getId()
			));
		}
		return foreignKeys;
	}

}