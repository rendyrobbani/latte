package com.rendyrobbani.latte.schema.specification.logs.user;

import com.rendyrobbani.common.schema.*;
import com.rendyrobbani.latte.schema.factory.LatteCheckFactory;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.base.LoggableTable;
import com.rendyrobbani.latte.schema.specification.base.user.UserTable;
import com.rendyrobbani.latte.schema.specification.data.user.DataUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsUserTable {

	public static final String NAME = "logs_user";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createBigInt("id", false, true, true));
			columns.add(LatteColumnFactory.copyOf("subject_id", DataUserTable.getTable().getId(), false));
			columns.addAll(UserTable.getColumns());
			columns.addAll(LoggableTable.getColumns());
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
			checks.addAll(UserTable.getChecks(checks.size() + 1, getTable()));
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.add(ForeignKeyFactory.create(
					foreignKeys.size() + 1,
					getTable(),
					getTable().getColumns().stream().filter(c -> c.getName().equals("subject_id")).toList(),
					DataUserTable.getTable(),
					List.of(DataUserTable.getTable().getId())
			));
			foreignKeys.addAll(UserTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
		}
		return foreignKeys;
	}

}