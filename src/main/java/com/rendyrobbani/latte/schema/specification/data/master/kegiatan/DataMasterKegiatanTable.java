package com.rendyrobbani.latte.schema.specification.data.master.kegiatan;

import com.rendyrobbani.common.schema.*;
import com.rendyrobbani.latte.schema.factory.LatteCheckFactory;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.master.kegiatan.MasterKegiatanTable;
import com.rendyrobbani.latte.schema.specification.data.master.fungsi.DataMasterFungsiTable;
import com.rendyrobbani.latte.schema.specification.data.master.fungsi.DataMasterSubfungsiTable;
import com.rendyrobbani.latte.schema.specification.data.master.program.DataMasterProgramTable;
import com.rendyrobbani.latte.schema.specification.data.master.urusan.DataMasterBidangTable;
import com.rendyrobbani.latte.schema.specification.data.master.urusan.DataMasterUrusanTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataMasterKegiatanTable {

	public static final String NAME = "data_master_kegiatan";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createKegiatanCode("id", false, true));
			columns.addAll(MasterKegiatanTable.getColumns());
			columns.add(LatteColumnFactory.createFungsiCode("fungsi_id", false));
			columns.add(LatteColumnFactory.createSubfungsiCode("subfungsi_id", false));
			columns.add(LatteColumnFactory.createUrusanCode("urusan_id", false));
			columns.add(LatteColumnFactory.createBidangCode("bidang_id", false));
			columns.add(LatteColumnFactory.createProgramCode("program_id", false));
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
		}
		return checks;
	}

	private static List<Constraint> uniqueKeys;

	public static List<Constraint> getUniqueKeys() {
		if (uniqueKeys == null) {
			uniqueKeys = new ArrayList<>();
			uniqueKeys.add(UniqueKeyFactory.create(
					uniqueKeys.size() + 1,
					getTable(),
					List.of(getTable().findColumn("urusan_id"),
							getTable().findColumn("bidang_id"),
							getTable().findColumn("program_id"),
							getTable().getId())
			));
			uniqueKeys.add(UniqueKeyFactory.create(
					uniqueKeys.size() + 1,
					getTable(),
					List.of(getTable().findColumn("fungsi_id"),
							getTable().findColumn("subfungsi_id"),
							getTable().findColumn("urusan_id"),
							getTable().findColumn("bidang_id"),
							getTable().findColumn("program_id"),
							getTable().getId())
			));
		}
		return uniqueKeys;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(MasterKegiatanTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					table,
					List.of(table.findColumn("fungsi_id"),
							table.findColumn("subfungsi_id")),
					DataMasterSubfungsiTable.getTable(),
					List.of(DataMasterSubfungsiTable.getTable().findColumn("fungsi_id"),
							DataMasterSubfungsiTable.getTable().findColumn("id"))
			));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					table,
					table.findColumn("fungsi_id"),
					DataMasterFungsiTable.getTable(),
					DataMasterFungsiTable.getTable().getId()
			));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					table,
					table.findColumn("subfungsi_id"),
					DataMasterSubfungsiTable.getTable(),
					DataMasterSubfungsiTable.getTable().getId()
			));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					table,
					table.findColumn("urusan_id"),
					DataMasterUrusanTable.getTable(),
					DataMasterUrusanTable.getTable().getId()
			));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					table,
					table.findColumn("bidang_id"),
					DataMasterBidangTable.getTable(),
					DataMasterBidangTable.getTable().getId()
			));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					table,
					table.findColumn("program_id"),
					DataMasterProgramTable.getTable(),
					DataMasterProgramTable.getTable().getId()
			));
		}
		return foreignKeys;
	}

}