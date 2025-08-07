package com.rendyrobbani.latte.schema.specification.base.master.fungsi;

import com.rendyrobbani.common.schema.Column;
import com.rendyrobbani.common.schema.Constraint;
import com.rendyrobbani.common.schema.ForeignKeyFactory;
import com.rendyrobbani.common.schema.Table;
import com.rendyrobbani.latte.schema.factory.LatteCheckFactory;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.AuditableTable;
import com.rendyrobbani.latte.schema.specification.base.LockableTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MasterSubfungsiTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createSubfungsiCode("id", false, true));
			columns.add(LatteColumnFactory.createVarChar("name", false));
			columns.addAll(LockableTable.getColumns());
			columns.addAll(AuditableTable.getColumns());
			columns.add(LatteColumnFactory.createFungsiCode("fungsi_id", false));
		}
		return columns;
	}

	public static List<Constraint> getChecks(Integer index, Table table) {
		var checks = new ArrayList<Constraint>();
		checks.add(LatteCheckFactory.columnIsSubfungsiCode(checks.size() + index, table, table.findColumn("id")));
		return checks;
	}

	public static List<Constraint> getForeignKeys(Integer index, Table table) {
		var foreignKeys = new ArrayList<Constraint>();
		foreignKeys.addAll(LockableTable.getForeignKeys(foreignKeys.size() + index, table));
		foreignKeys.addAll(AuditableTable.getForeignKeys(foreignKeys.size() + index, table));
		foreignKeys.add(ForeignKeyFactory.create(
				index,
				table,
				table.findColumn("fungsi_id"),
				table,
				table.findColumn("fungsi_id")
		));
		return foreignKeys;
	}

}