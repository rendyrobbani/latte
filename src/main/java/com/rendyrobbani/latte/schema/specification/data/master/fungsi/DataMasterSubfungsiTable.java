package com.rendyrobbani.latte.schema.specification.data.master.fungsi;

import com.rendyrobbani.common.schema.*;
import com.rendyrobbani.latte.schema.factory.LatteCheckFactory;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.master.fungsi.MasterSubfungsiTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataMasterSubfungsiTable {

	public static final String NAME = "data_master_subfungsi";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createSubfungsiCode("id", false, true));
			columns.addAll(MasterSubfungsiTable.getColumns());
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
			checks.add(LatteCheckFactory.columnEqualsColumn(checks.size() + 1, getTable(), getTable().getId(), getTable().findColumn("code")));
			checks.addAll(MasterSubfungsiTable.getChecks(checks.size() + 1, getTable()));
			columns.add(LatteColumnFactory.createFungsiCode("fungsi_id", false));
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
					table,
					table.findColumn("fungsi_id"),
					DataMasterFungsiTable.getTable(),
					DataMasterFungsiTable.getTable().getId()
			));
		}
		return foreignKeys;
	}

}