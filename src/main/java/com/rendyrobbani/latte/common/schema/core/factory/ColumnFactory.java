package com.rendyrobbani.latte.common.schema.core.factory;

import com.rendyrobbani.latte.common.schema.core.Column;
import com.rendyrobbani.latte.common.schema.core.ColumnType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ColumnFactory {

	@Getter
	@SuppressWarnings("ClassCanBeRecord")
	private static final class ColumnImpl implements Column {

		private final String name;

		private final String size;

		private final ColumnType type;

		private final boolean isNullable;

		private final boolean isPrimaryKey;

		private final boolean isAutoIncrement;

		private ColumnImpl(String name, String size, ColumnType type, boolean isNullable, boolean isPrimaryKey, boolean isAutoIncrement) {
			this.name = name;
			this.size = size;
			this.type = type;
			this.isAutoIncrement = isAutoIncrement && type.getJavaType().equals(Long.class);
			this.isPrimaryKey = isPrimaryKey || this.isAutoIncrement;
			this.isNullable = isNullable && !this.isPrimaryKey;
		}

	}

	public static Column create(String name, String size, ColumnType type, boolean isNullable, boolean isPrimaryKey, boolean isAutoIncrement) {
		size = size == null ? "" : size.trim();
		if (size.startsWith("(")) size = size.substring(1);
		if (size.endsWith(")")) size = size.substring(0, size.length() - 1);
		return new ColumnImpl(name, size.isBlank() ? size : "(" + size + ")", type, isNullable, isPrimaryKey, isAutoIncrement);
	}

	public static Column copyOf(String name, Column column, boolean isNullable, boolean isPrimaryKey) {
		return create(name, column.getSize(), column.getType(), isNullable, isPrimaryKey, false);
	}

	public static Column copyOf(String name, Column column, boolean isNullable) {
		return copyOf(name, column, isNullable, false);
	}

	public static Column copyOf(String name, Column column) {
		return copyOf(name, column, true, false);
	}

	public static Column createVarChar(String name, Integer size, boolean isNullable, boolean isPrimaryKey) {
		size = size != null ? size : 255;
		return create(name, size.toString(), ColumnType.VARCHAR, isNullable, isPrimaryKey, false);
	}

	public static Column createVarChar(String name, Integer size, boolean isNullable) {
		return createVarChar(name, size, isNullable, false);
	}

	public static Column createVarChar(String name, Integer size) {
		return createVarChar(name, size, true, false);
	}

	public static Column createVarChar(String name, boolean isNullable, boolean isPrimaryKey) {
		return createVarChar(name, null, isNullable, isPrimaryKey);
	}

	public static Column createVarChar(String name, boolean isNullable) {
		return createVarChar(name, null, isNullable, false);
	}

	public static Column createVarChar(String name) {
		return createVarChar(name, null, true, false);
	}

	public static Column createChar(String name, Integer size, boolean isNullable, boolean isPrimaryKey) {
		size = size != null ? size : 255;
		return create(name, size.toString(), ColumnType.CHAR, isNullable, isPrimaryKey, false);
	}

	public static Column createChar(String name, Integer size, boolean isNullable) {
		return createChar(name, size, isNullable, false);
	}

	public static Column createChar(String name, Integer size) {
		return createChar(name, size, true, false);
	}

	public static Column createChar(String name, boolean isNullable, boolean isPrimaryKey) {
		return createChar(name, null, isNullable, isPrimaryKey);
	}

	public static Column createChar(String name, boolean isNullable) {
		return createChar(name, null, isNullable, false);
	}

	public static Column createChar(String name) {
		return createChar(name, null, true, false);
	}

	public static Column createBigInt(String name, boolean isNullable, boolean isPrimaryKey, boolean isAutoIncrement) {
		return create(name, "20", ColumnType.BIGINT, isNullable, isPrimaryKey, isAutoIncrement);
	}

	public static Column createBigInt(String name, boolean isNullable, boolean isPrimaryKey) {
		return createBigInt(name, isNullable, isPrimaryKey, false);
	}

	public static Column createBigInt(String name, boolean isNullable) {
		return createBigInt(name, isNullable, false, false);
	}

	public static Column createBigInt(String name) {
		return createBigInt(name, true, false, false);
	}

	public static Column createSmallInt(String name, boolean isNullable, boolean isPrimaryKey) {
		return create(name, "6", ColumnType.SMALLINT, isNullable, isPrimaryKey, false);
	}

	public static Column createSmallInt(String name, boolean isNullable) {
		return createSmallInt(name, isNullable, false);
	}

	public static Column createSmallInt(String name) {
		return createSmallInt(name, true, false);
	}

	public static Column createTinyInt(String name, boolean isNullable, boolean isPrimaryKey) {
		return create(name, "4", ColumnType.TINYINT, isNullable, isPrimaryKey, false);
	}

	public static Column createTinyInt(String name, boolean isNullable) {
		return createTinyInt(name, isNullable, false);
	}

	public static Column createTinyInt(String name) {
		return createTinyInt(name, true, false);
	}

	public static Column createBoolean(String name, boolean isNullable) {
		return create(name, "1", ColumnType.BOOLEAN, isNullable, false, false);
	}

	public static Column createBoolean(String name) {
		return createBoolean(name, true);
	}

	public static Column createDateOnly(String name, boolean isNullable) {
		return create(name, null, ColumnType.DATEONLY, isNullable, false, false);
	}

	public static Column createDateOnly(String name) {
		return createDateOnly(name, true);
	}

	public static Column createDateTime(String name, boolean isNullable) {
		return create(name, null, ColumnType.DATETIME, isNullable, false, false);
	}

	public static Column createDateTime(String name) {
		return createDateTime(name, true);
	}

}