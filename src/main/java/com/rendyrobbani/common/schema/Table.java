package com.rendyrobbani.common.schema;

import java.util.ArrayList;
import java.util.List;

public interface Table {

	String ENGINE = "innodb";

	String CHARSET = "utf8mb4";

	String COLLATE = "utf8mb4_unicode_ci";

	String getName();

	Column getId();

	List<Column> getColumns();

	default Column findColumn(String name) {
		return this.getColumns().stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
	}

	default String getDeleteDDL(boolean useIfExists) {
		return String.join(" ", "drop table" + (useIfExists ? " if exists" : ""), this.getName()) + ";";
	}

	default String getDeleteDDL() {
		return this.getDeleteDDL(true);
	}

	default String getCreateDDL(boolean useOrReplace, boolean format) {
		List<String> ddl = new ArrayList<>();
		ddl.add("create " + (useOrReplace ? "or replace " : "") + "table " + this.getName() + " (");
		if (format) {
			int maxName = 0;
			int maxType = 0;
			for (var column : this.getColumns()) {
				maxName = Math.max(maxName, column.getName().length());
				maxType = Math.max(maxType, column.getTypeAndSize().length());
			}
			for (var column : this.getColumns()) {
				var name = column.getName() + " ".repeat(maxName - column.getName().length());
				var type = column.getTypeAndSize() + " ".repeat(maxType - column.getTypeAndSize().length());
				var attr = column.isNullable() ? "null" : "not null";
				if (column.isAutoIncrement()) attr += " auto_increment";
				ddl.add("\t" + String.join(" ", name, type, attr) + ",");
			}
			ddl.add("\t" + String.join(" ", List.of("primary key", "(" + this.getId().getName() + ")")));
			ddl.add(") engine = " + ENGINE);
			ddl.add("  charset = " + CHARSET);
			ddl.add("  collate = " + COLLATE + ";");
		} else {
			for (var column : this.getColumns()) {
				var name = column.getName();
				var type = column.getTypeAndSize();
				var attr = column.isNullable() ? "null" : "not null";
				if (column.isAutoIncrement()) attr += " auto_increment";
				ddl.add((" ".repeat(Math.min(1, ddl.size() - 1))) + String.join(" ", name, type, attr) + ",");
			}
			ddl.add("primary key(" + this.getId().getName() + ")");
			ddl.add(") engine = " + ENGINE + " charset = " + CHARSET + " collate = " + COLLATE + ";");
		}
		return String.join(format ? "\n" : "", ddl);
	}

	default String getCreateDDL(boolean useOrReplace) {
		return this.getCreateDDL(useOrReplace, true);
	}

	default String getCreateDDL() {
		return this.getCreateDDL(true, true);
	}

}