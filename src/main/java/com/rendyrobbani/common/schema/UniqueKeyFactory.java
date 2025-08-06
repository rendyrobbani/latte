package com.rendyrobbani.common.schema;

import com.rendyrobbani.common.util.number.NumberUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UniqueKeyFactory {

	@Getter
	@SuppressWarnings("ClassCanBeRecord")
	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	private static final class UniqueKeyImpl implements UniqueKey {

		private final String name;

		private final Table table;

		private final List<Column> columns;

	}

	public static UniqueKey create(String name, Table table, List<Column> columns) {
		return new UniqueKeyImpl(name, table, columns);
	}

	public static UniqueKey create(Integer index, Table table, List<Column> columns) {
		return create(String.join("_", "uk", table.getName().substring(0, Math.min(58, table.getName().length())), NumberUtil.lpadZero(index, 2)), table, columns);
	}

}