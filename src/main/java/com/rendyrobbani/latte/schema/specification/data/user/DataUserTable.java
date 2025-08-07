package com.rendyrobbani.latte.schema.specification.data.user;

import com.rendyrobbani.common.schema.Column;
import com.rendyrobbani.common.schema.Constraint;
import com.rendyrobbani.common.schema.Table;
import com.rendyrobbani.common.schema.TableFactory;
import com.rendyrobbani.latte.schema.factory.LatteCheckFactory;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.user.UserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataUserTable {

	public static final String NAME = "data_user";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createNIP("id", false, true));
			columns.addAll(UserTable.getColumns());
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
			checks.add(LatteCheckFactory.columnIsNIP(checks.size() + 1, getTable(), getTable().getId()));
			checks.addAll(UserTable.getChecks(checks.size() + 1, getTable()));
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(UserTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
		}
		return foreignKeys;
	}

}