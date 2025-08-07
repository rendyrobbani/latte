package com.rendyrobbani.latte.schema.specification.base.master.urusan;

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
public final class MasterUrusanTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createUrusanCode("code", false));
			columns.add(LatteColumnFactory.createVarChar("name", false));
			columns.addAll(LockableTable.getColumns());
			columns.addAll(AuditableTable.getColumns());
		}
		return columns;
	}

	@SuppressWarnings("JavaExistingMethodCanBeUsed")
	public static List<Constraint> getForeignKeys(Integer index, Table table) {
		var foreignKeys = new ArrayList<Constraint>();
		foreignKeys.addAll(LockableTable.getForeignKeys(foreignKeys.size() + index, table));
		foreignKeys.addAll(AuditableTable.getForeignKeys(foreignKeys.size() + index, table));
		return foreignKeys;
	}

}