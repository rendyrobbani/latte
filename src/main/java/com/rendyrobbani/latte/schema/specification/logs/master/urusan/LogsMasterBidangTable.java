package com.rendyrobbani.latte.schema.specification.logs.master.urusan;

import com.rendyrobbani.common.schema.*;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.LoggableTable;
import com.rendyrobbani.latte.schema.specification.base.master.urusan.MasterBidangTable;
import com.rendyrobbani.latte.schema.specification.data.master.urusan.DataMasterBidangTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsMasterBidangTable {

	public static final String NAME = "logs_master_bidang";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createBigInt("id", false, true, true));
			columns.addAll(MasterBidangTable.getColumns());
			columns.addAll(LoggableTable.getColumns());
			columns.add(LatteColumnFactory.copyOf("subject_id", DataMasterBidangTable.getTable().getId(), false));
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
			foreignKeys.addAll(MasterBidangTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.addAll(LoggableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					getTable(),
					getTable().findColumn("subject_id"),
					DataMasterBidangTable.getTable(),
					DataMasterBidangTable.getTable().getId()
			));
		}
		return foreignKeys;
	}

}