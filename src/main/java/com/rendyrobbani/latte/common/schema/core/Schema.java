package com.rendyrobbani.latte.common.schema.core;

import java.util.ArrayList;
import java.util.List;

public interface Schema {

	String getName();

	List<Table> getTables();

	List<Constraint> getChecks();

	List<Constraint> getForeignKeys();

	List<Constraint> getUniqueKeys();

	default String getDeleteDDL() {
		return String.join(System.lineSeparator(), this.getTables().reversed().stream().map(Table::getDeleteDDL).toList());
	}

	default String getCreateDDL() {
		var value = new ArrayList<String>();

		if (!this.getTables().isEmpty()) value.add(String.join(System.lineSeparator(), this.getTables().stream().map(Table::getCreateDDL).toList()));
		if (!this.getChecks().isEmpty()) value.add(String.join(System.lineSeparator(), this.getChecks().stream().map(Constraint::getCreateDDL).toList()));
		if (!this.getForeignKeys().isEmpty()) value.add(String.join(System.lineSeparator(), this.getForeignKeys().stream().map(Constraint::getCreateDDL).toList()));
		if (!this.getUniqueKeys().isEmpty()) value.add(String.join(System.lineSeparator(), this.getUniqueKeys().stream().map(Constraint::getCreateDDL).toList()));

		return String.join(System.lineSeparator().repeat(2), value);
	}

}