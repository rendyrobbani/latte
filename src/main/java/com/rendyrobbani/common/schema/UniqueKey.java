package com.rendyrobbani.common.schema;

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