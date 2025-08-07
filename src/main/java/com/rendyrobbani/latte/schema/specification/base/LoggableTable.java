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
public final class LoggableTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(LatteColumnFactory.createDateTime("logged_at", true));
			columns.add(LatteColumnFactory.createNIP("logged_by", true));
		}
		return columns;
	}

	public static List<Constraint> getForeignKeys(Integer index, Table table) {
		var foreignKeys = new ArrayList<Constraint>();
		foreignKeys.add(ForeignKeyFactory.create(
				foreignKeys.size() + index,
				table,
				table.getColumns().stream().filter(c -> c.getName().equals("logged_by")).toList(),
				DataUserTable.getTable(),
				List.of(DataUserTable.getTable().getId())
		));
		return foreignKeys;
	}

}