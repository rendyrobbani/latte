package com.rendyrobbani.latte.schema.specification.base.master.fungsi;

import com.rendyrobbani.common.schema.Column;
import com.rendyrobbani.common.schema.Constraint;
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
			columns.add(LatteColumnFactory.createSubfungsiCode("code", false));
			columns.add(LatteColumnFactory.createVarChar("name", false));
			columns.addAll(LockableTable.getColumns());
			columns.addAll(AuditableTable.getColumns());
		}
		return columns;
	}

	public static List<Constraint> getChecks(Integer index, Table table) {
		var checks = new ArrayList<Constraint>();
		checks.add(LatteCheckFactory.columnIsSubfungsiCode(checks.size() + index, table, table.findColumn("code")));
		return checks;
	}

	@SuppressWarnings("JavaExistingMethodCanBeUsed")
	public static List<Constraint> getForeignKeys(Integer index, Table table) {
		var foreignKeys = new ArrayList<Constraint>();
		foreignKeys.addAll(LockableTable.getForeignKeys(foreignKeys.size() + index, table));
		foreignKeys.addAll(AuditableTable.getForeignKeys(foreignKeys.size() + index, table));
		return foreignKeys;
	}

}