package com.rendyrobbani.latte.schema.specification.data.master.fungsi;

import com.rendyrobbani.common.schema.Column;
import com.rendyrobbani.common.schema.Constraint;
import com.rendyrobbani.common.schema.Table;
import com.rendyrobbani.common.schema.TableFactory;
import com.rendyrobbani.latte.schema.factory.LatteCheckFactory;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.master.fungsi.MasterFungsiTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataMasterFungsiTable {

	public static final String NAME = "data_master_fungsi";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createFungsiCode("id", false, true));
			columns.addAll(MasterFungsiTable.getColumns());
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
			checks.addAll(MasterFungsiTable.getChecks(checks.size() + 1, getTable()));
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(MasterFungsiTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
		}
		return foreignKeys;
	}

}