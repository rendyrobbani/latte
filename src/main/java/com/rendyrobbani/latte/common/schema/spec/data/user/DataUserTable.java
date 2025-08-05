package com.rendyrobbani.latte.common.schema.spec.data.user;

import com.rendyrobbani.latte.common.schema.core.Column;
import com.rendyrobbani.latte.common.schema.core.Constraint;
import com.rendyrobbani.latte.common.schema.core.Table;
import com.rendyrobbani.latte.common.schema.core.factory.CheckFactory;
import com.rendyrobbani.latte.common.schema.core.factory.ColumnFactory;
import com.rendyrobbani.latte.common.schema.core.factory.TableFactory;
import com.rendyrobbani.latte.common.schema.spec.base.AuditableTable;
import com.rendyrobbani.latte.common.schema.spec.base.LockableTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataUserTable {

	public static final String TABLE_NAME = "data_user";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createChar("id", 18, false, true));
			columns.add(ColumnFactory.createChar("pangkat", 2, false));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.add(ColumnFactory.createVarChar("title_prefix", true));
			columns.add(ColumnFactory.createVarChar("title_suffix", true));
			columns.add(ColumnFactory.createVarChar("password", false));
			columns.add(ColumnFactory.createDateOnly("birth_date", false));
			columns.add(ColumnFactory.createDateOnly("start_date", true));
			columns.add(ColumnFactory.createTinyInt("gender", false));
			columns.add(ColumnFactory.createSmallInt("number", false));
			columns.add(ColumnFactory.createBoolean("is_pns", false));
			columns.add(ColumnFactory.createBoolean("is_p3k", false));
			columns.addAll(LockableTable.getColumns());
			columns.addAll(AuditableTable.getColumns());
		}
		return columns;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.create(TABLE_NAME, getColumns());
		return table;
	}

	private static List<Constraint> checks;

	public static List<Constraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(CheckFactory.columnIsNIP(checks.size() + 1, getTable(), getTable().getId()));
			checks.add(CheckFactory.columnIsPangkatASN(checks.size() + 1, getTable(), getTable().findColumn("pangkat")));
			checks.add(CheckFactory.columnIsGender(checks.size() + 1, getTable(), getTable().findColumn("gender")));
			checks.add(CheckFactory.columnBetween(checks.size() + 1, getTable(), getTable().findColumn("number"), 1, 999));
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(LockableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.addAll(AuditableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
		}
		return foreignKeys;
	}

}