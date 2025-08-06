package com.rendyrobbani.common.schema;

import com.rendyrobbani.common.util.number.NumberUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CheckFactory {

	@Getter
	@SuppressWarnings("ClassCanBeRecord")
	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	private static final class CheckImpl implements Check {

		private final String name;

		private final Table table;

		private final String logic;

	}

	public static Check create(String name, Table table, String logic) {
		return new CheckImpl(name, table, logic);
	}

	public static Check create(Integer index, Table table, String logic) {
		return create(String.join("_", "ck", table.getName().substring(0, Math.min(58, table.getName().length())), NumberUtil.lpadZero(index, 2)), table, logic);
	}

	public static Check columnRegex(Integer index, Table table, Column column, String regex) {
		var logic = column.getName() + " regexp '" + regex + "'";
		return create(index, table, logic);
	}

	public static Check columnIn(Integer index, Table table, Column column, String[] values) {
		var inValues = String.join(", ", Stream.of(values).map(value -> "'" + value + "'").toArray(String[]::new));
		var logic = column.getName() + " in (" + inValues + ")";
		return create(index, table, logic);
	}

	public static Check columnIn(Integer index, Table table, Column column, Integer[] values) {
		var inValues = String.join(", ", Stream.of(values).map(String::valueOf).toArray(String[]::new));
		var logic = column.getName() + " in (" + inValues + ")";
		return create(index, table, logic);
	}

	public static Check columnBetween(Integer index, Table table, Column column, Integer min, Integer max) {
		var logic = column.getName() + " between " + min + " and " + max;
		return create(index, table, logic);
	}

}