package com.rendyrobbani.latte.common.schema.spec.base;

import com.rendyrobbani.latte.common.schema.core.Column;
import com.rendyrobbani.latte.common.schema.core.Constraint;
import com.rendyrobbani.latte.common.schema.core.Table;
import com.rendyrobbani.latte.common.schema.core.factory.ColumnFactory;
import com.rendyrobbani.latte.common.schema.core.factory.ForeignKeyFactory;
import com.rendyrobbani.latte.common.schema.spec.data.user.DataUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AuditableTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createDateTime("created_at", true));
			columns.add(ColumnFactory.createChar("created_by", 18, true));
			columns.add(ColumnFactory.createDateTime("updated_at", true));
			columns.add(ColumnFactory.createChar("updated_by", 18, true));
			columns.add(ColumnFactory.createBoolean("is_deleted", false));
			columns.add(ColumnFactory.createDateTime("deleted_at", true));
			columns.add(ColumnFactory.createChar("deleted_by", 18, true));
		}
		return columns;
	}

	public static List<Constraint> getForeignKeys(Integer index, Table table) {
		var foreignKeys = new ArrayList<Constraint>();
		foreignKeys.add(ForeignKeyFactory.create(
				index,
				table,
				List.of(table.findColumn("created_by")),
				DataUserTable.getTable(),
				List.of(DataUserTable.getTable().getId())
		));
		foreignKeys.add(ForeignKeyFactory.create(
				index,
				table,
				List.of(table.findColumn("updated_by")),
				DataUserTable.getTable(),
				List.of(DataUserTable.getTable().getId())
		));
		foreignKeys.add(ForeignKeyFactory.create(
				index,
				table,
				List.of(table.findColumn("deleted_by")),
				DataUserTable.getTable(),
				List.of(DataUserTable.getTable().getId())
		));
		return foreignKeys;
	}

}