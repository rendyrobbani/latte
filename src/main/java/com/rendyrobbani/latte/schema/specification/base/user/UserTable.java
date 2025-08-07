package com.rendyrobbani.latte.schema.specification.base.user;

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
public final class UserTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createPangkat("pangkat", false));
			columns.add(LatteColumnFactory.createVarChar("name", false));
			columns.add(LatteColumnFactory.createVarChar("title_prefix", true));
			columns.add(LatteColumnFactory.createVarChar("title_suffix", true));
			columns.add(LatteColumnFactory.createVarChar("password", false));
			columns.add(LatteColumnFactory.createDateOnly("birth_date", false));
			columns.add(LatteColumnFactory.createDateOnly("start_date", true));
			columns.add(LatteColumnFactory.createGender("gender", false));
			columns.add(LatteColumnFactory.createSmallInt("number", false));
			columns.add(LatteColumnFactory.createBoolean("is_pns", false));
			columns.add(LatteColumnFactory.createBoolean("is_p3k", false));
			columns.addAll(LockableTable.getColumns());
			columns.addAll(AuditableTable.getColumns());
		}
		return columns;
	}

	public static List<Constraint> getChecks(Integer index, Table table) {
		var checks = new ArrayList<Constraint>();
		checks.add(LatteCheckFactory.columnIsPangkat(checks.size() + index, table, table.findColumn("pangkat")));
		checks.add(LatteCheckFactory.columnIsGender(checks.size() + index, table, table.findColumn("gender")));
		checks.add(LatteCheckFactory.columnNotEqualsColumn(checks.size() + index, table, table.findColumn("is_pns"), table.findColumn("is_p3k")));
		return checks;
	}

	public static List<Constraint> getForeignKeys(Integer index, Table table) {
		var foreignKeys = new ArrayList<Constraint>();
		foreignKeys.addAll(LockableTable.getForeignKeys(foreignKeys.size() + index, table));
		foreignKeys.addAll(AuditableTable.getForeignKeys(foreignKeys.size() + index, table));
		return foreignKeys;
	}

}