package com.rendyrobbani.latte.schema.specification.sipd.master.kegiatan;

import com.rendyrobbani.common.schema.*;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.master.kegiatan.MasterKegiatanTable;
import com.rendyrobbani.latte.schema.specification.data.master.kegiatan.DataMasterKegiatanTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SIPDMasterKegiatanTable {

	public static final String NAME = "sipd_master_kegiatan";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createBigInt("id", false, true, true));
			columns.addAll(MasterKegiatanTable.getColumns());
			columns.add(LatteColumnFactory.copyOf("subject_id", DataMasterKegiatanTable.getTable().getId(), false));
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
			foreignKeys.addAll(MasterKegiatanTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					getTable(),
					getTable().findColumn("subject_id"),
					DataMasterKegiatanTable.getTable(),
					DataMasterKegiatanTable.getTable().getId()
			));
		}
		return foreignKeys;
	}

}