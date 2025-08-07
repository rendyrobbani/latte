package com.rendyrobbani.latte.schema.specification.logs.master.urusan;

import com.rendyrobbani.common.schema.*;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.LoggableTable;
import com.rendyrobbani.latte.schema.specification.base.master.urusan.MasterUrusanTable;
import com.rendyrobbani.latte.schema.specification.data.master.urusan.DataMasterUrusanTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsMasterUrusanTable {

	public static final String NAME = "logs_master_urusan";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createBigInt("id", false, true, true));
			columns.addAll(MasterUrusanTable.getColumns());
			columns.addAll(LoggableTable.getColumns());
			columns.add(LatteColumnFactory.copyOf("subject_id", DataMasterUrusanTable.getTable().getId(), false));
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
			foreignKeys.addAll(MasterUrusanTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.addAll(LoggableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					getTable(),
					getTable().findColumn("subject_id"),
					DataMasterUrusanTable.getTable(),
					DataMasterUrusanTable.getTable().getId()
			));
		}
		return foreignKeys;
	}

}