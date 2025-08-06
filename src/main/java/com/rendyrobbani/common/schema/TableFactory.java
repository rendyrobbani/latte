package com.rendyrobbani.common.schema;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TableFactory {

	@Getter
	private static final class TableImpl implements Table {

		private final String name;

		private final Column id;

		private final List<Column> columns;

		private TableImpl(String name, List<Column> columns, String columnIdName) {
			this.id = columns.stream().filter(c -> c.getName().equals(columnIdName)).findFirst().orElseThrow(() -> new IllegalArgumentException("Id column not found"));
			this.name = name;
			this.columns = columns;
		}

	}

	public static Table create(String name, List<Column> columns, String columnIdName) {
		return new TableImpl(name, columns, columnIdName);
	}

	public static Table create(String name, List<Column> columns) {
		return create(name, columns, "id");
	}

	public static Table createLog(String name, Table subject) {
		var columns = new ArrayList<Column>();
		columns.add(ColumnFactory.createBigInt("id", false, true, true));
		for (var column : subject.getColumns()) {
			if (column.isPrimaryKey()) columns.add(ColumnFactory.copyOf("subject_id", column, false));
			else columns.add(column);
		}
		return create(name, columns);
	}

}