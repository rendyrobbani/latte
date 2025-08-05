package com.rendyrobbani.latte.common.schema.core;

import java.util.List;

public interface UniqueKey extends Constraint {

	List<Column> getColumns();

	@Override
	default String getValue() {
		return String.join(" ",
				"unique key",
				"(" + String.join(", ", this.getColumns().stream().map(Column::getName).toList()) + ")"
		);
	}

}