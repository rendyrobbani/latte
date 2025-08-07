package com.rendyrobbani.latte.schema.specification.base;

import com.rendyrobbani.common.schema.Column;
import com.rendyrobbani.common.schema.Constraint;
import com.rendyrobbani.common.schema.ForeignKeyFactory;
import com.rendyrobbani.common.schema.Table;
import com.rendyrobbani.latte.schema.factory.LatteColumnFactory;
import com.rendyrobbani.latte.schema.specification.data.user.DataUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AuditableTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createDateTime("created_at", true));
			columns.add(LatteColumnFactory.createNIP("created_by", true));
			columns.add(LatteColumnFactory.createDateTime("updated_at", true));
			columns.add(LatteColumnFactory.createNIP("updated_by", true));
			columns.add(LatteColumnFactory.createBoolean("is_deleted", false));
			columns.add(LatteColumnFactory.createDateTime("deleted_at", true));
			columns.add(LatteColumnFactory.createNIP("deleted_by", true));
		}
		return columns;
	}

	public static List<Constraint> getForeignKeys(Integer index, Table table) {
		var foreignKeys = new ArrayList<Constraint>();
		foreignKeys.add(ForeignKeyFactory.create(
				foreignKeys.size() + index,
				table,
				table.getColumns().stream().filter(c -> c.getName().equals("created_by")).toList(),
				DataUserTable.getTable(),
				List.of(DataUserTable.getTable().getId())
		));
		foreignKeys.add(ForeignKeyFactory.create(
				foreignKeys.size() + index,
				table,
				table.getColumns().stream().filter(c -> c.getName().equals("updated_by")).toList(),
				DataUserTable.getTable(),
				List.of(DataUserTable.getTable().getId())
		));
		foreignKeys.add(ForeignKeyFactory.create(
				foreignKeys.size() + index,
				table,
				table.getColumns().stream().filter(c -> c.getName().equals("deleted_by")).toList(),
				DataUserTable.getTable(),
				List.of(DataUserTable.getTable().getId())
		));
		return foreignKeys;
	}

}