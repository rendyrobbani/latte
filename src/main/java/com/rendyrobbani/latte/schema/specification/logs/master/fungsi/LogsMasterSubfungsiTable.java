package com.rendyrobbani.latte.schema.specification.logs.master.fungsi;

import com.rendyrobbani.common.schema.*;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.LoggableTable;
import com.rendyrobbani.latte.schema.specification.base.master.fungsi.MasterSubfungsiTable;
import com.rendyrobbani.latte.schema.specification.data.master.fungsi.DataMasterSubfungsiTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsMasterSubfungsiTable {

	public static final String NAME = "logs_master_subfungsi";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createBigInt("id", false, true, true));
			columns.addAll(MasterSubfungsiTable.getColumns());
			columns.addAll(LoggableTable.getColumns());
			columns.add(LatteColumnFactory.copyOf("subject_id", DataMasterSubfungsiTable.getTable().getId(), false));
		}
		return columns;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.create(NAME, getColumns());
		return table;
	}

	private static List<Constraint> checks;

	public static List<Constraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.addAll(MasterSubfungsiTable.getChecks(checks.size() + 1, getTable()));
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(MasterSubfungsiTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					getTable(),
					getTable().findColumn("subject_id"),
					DataMasterSubfungsiTable.getTable(),
					DataMasterSubfungsiTable.getTable().getId()
			));
		}
		return foreignKeys;
	}

}