package com.rendyrobbani.latte.common.schema.spec.logs.user;

import com.rendyrobbani.latte.common.schema.core.Constraint;
import com.rendyrobbani.latte.common.schema.core.Table;
import com.rendyrobbani.latte.common.schema.core.factory.CheckFactory;
import com.rendyrobbani.latte.common.schema.core.factory.ForeignKeyFactory;
import com.rendyrobbani.latte.common.schema.core.factory.TableFactory;
import com.rendyrobbani.latte.common.schema.spec.base.AuditableTable;
import com.rendyrobbani.latte.common.schema.spec.base.LockableTable;
import com.rendyrobbani.latte.common.schema.spec.base.LoggableTable;
import com.rendyrobbani.latte.common.schema.spec.data.user.DataUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsUserTable {

	public static final String TABLE_NAME = "logs_user";

	public static final Table SUBJECT_TABLE = DataUserTable.getTable();

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createLog(TABLE_NAME, SUBJECT_TABLE);
		return table;
	}

	private static List<Constraint> checks;

	public static List<Constraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
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
			foreignKeys.add(ForeignKeyFactory.create(foreignKeys.size() + 1, getTable(), List.of(getTable().findColumn("subject_id")), SUBJECT_TABLE, List.of(SUBJECT_TABLE.getId())));
			foreignKeys.addAll(LockableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.addAll(AuditableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.addAll(LoggableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
		}
		return foreignKeys;
	}

}