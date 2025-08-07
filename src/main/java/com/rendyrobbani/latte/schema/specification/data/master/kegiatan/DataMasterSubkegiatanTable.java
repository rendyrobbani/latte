package com.rendyrobbani.latte.schema.specification.data.master.kegiatan;

import com.rendyrobbani.common.schema.*;
import com.rendyrobbani.latte.schema.factory.LatteCheckFactory;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.master.kegiatan.MasterSubkegiatanTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataMasterSubkegiatanTable {

	public static final String NAME = "data_master_subkegiatan";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createSubkegiatanCode("id", false, true));
			columns.addAll(MasterSubkegiatanTable.getColumns());
			columns.add(LatteColumnFactory.createFungsiCode("fungsi_id", false));
			columns.add(LatteColumnFactory.createSubfungsiCode("subfungsi_id", false));
			columns.add(LatteColumnFactory.createUrusanCode("urusan_id", false));
			columns.add(LatteColumnFactory.createBidangCode("bidang_id", false));
			columns.add(LatteColumnFactory.createProgramCode("program_id", false));
			columns.add(LatteColumnFactory.createKegiatanCode("kegiatan_id", false));
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
			checks.add(LatteCheckFactory.columnEquals(checks.size() + 1, getTable(), getTable().getId(), "replace(" + getTable().findColumn("code").getName() + ", 'X', '0')"));
			checks.add(LatteCheckFactory.columnStartsWithColumn(checks.size() + 1, getTable(), getTable().getId(), getTable().findColumn("urusan_id")));
			checks.add(LatteCheckFactory.columnStartsWithColumn(checks.size() + 1, getTable(), getTable().getId(), getTable().findColumn("bidang_id")));
			checks.add(LatteCheckFactory.columnStartsWithColumn(checks.size() + 1, getTable(), getTable().getId(), getTable().findColumn("program_id")));
			checks.add(LatteCheckFactory.columnStartsWithColumn(checks.size() + 1, getTable(), getTable().getId(), getTable().findColumn("kegiatan_id")));
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(MasterSubkegiatanTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					table,
					table.findColumn("kegiatan_id"),
					DataMasterKegiatanTable.getTable(),
					DataMasterKegiatanTable.getTable().getId()
			));
		}
		return foreignKeys;
	}

}