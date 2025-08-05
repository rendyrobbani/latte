package com.rendyrobbani.latte.common.schema.core.factory;

import com.rendyrobbani.latte.common.schema.core.Constraint;
import com.rendyrobbani.latte.common.schema.core.Schema;
import com.rendyrobbani.latte.common.schema.core.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SchemaFactory {

	@Getter
	@SuppressWarnings("ClassCanBeRecord")
	private static final class SchemaImpl implements Schema {

		private final String name;

		private final List<Table> tables;

		private final List<Constraint> checks;

		private final List<Constraint> foreignKeys;

		private final List<Constraint> uniqueKeys;

		public SchemaImpl(String name, List<Table> tables, List<Constraint> checks, List<Constraint> foreignKeys, List<Constraint> uniqueKeys) {
			this.name = name;
			this.tables = tables != null ? tables : List.of();
			this.checks = checks != null ? checks : List.of();
			this.foreignKeys = foreignKeys != null ? foreignKeys : List.of();
			this.uniqueKeys = uniqueKeys != null ? uniqueKeys : List.of();
		}

	}

	public static Schema create(String name, List<Table> tables, List<Constraint> checks, List<Constraint> foreignKeys, List<Constraint> uniqueKeys) {
		return new SchemaImpl(name, tables, checks, foreignKeys, uniqueKeys);
	}

}