package com.rendyrobbani.latte.schema.factory;

import com.rendyrobbani.common.classification.urusan.UrusanClassification;
import com.rendyrobbani.common.classification.urusan.BidangClassification;
import com.rendyrobbani.common.schema.Check;
import com.rendyrobbani.common.schema.CheckFactory;
import com.rendyrobbani.common.schema.Column;
import com.rendyrobbani.common.schema.Table;
import com.rendyrobbani.common.util.number.NumberUtil;
import com.rendyrobbani.latte.common.vo.Gender;
import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.common.vo.Pangkat;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteCheckFactory {

	public static Check create(String name, Table table, String logic) {
		return CheckFactory.create(name, table, logic);
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

	public static Check columnEquals(Integer index, Table table, Column column, String value) {
		var logic = column.getName() + " = " + value;
		return create(index, table, logic);
	}

	public static Check columnEquals(Integer index, Table table, Column column, Integer value) {
		return columnEquals(index, table, column, value.toString());
	}

	public static Check columnEqualsColumn(Integer index, Table table, Column column1, Column column2) {
		var logic = column1.getName() + " = " + column2.getName();
		return create(index, table, logic);
	}

	public static Check columnNotEquals(Integer index, Table table, Column column, Integer value) {
		var logic = column.getName() + " <> " + value;
		return create(index, table, logic);
	}

	public static Check columnNotEquals(Integer index, Table table, Column column, String value) {
		var logic = column.getName() + " <> '" + value + "'";
		return create(index, table, logic);
	}

	public static Check columnNotEqualsColumn(Integer index, Table table, Column column1, Column column2) {
		var logic = column1.getName() + " <> " + column2.getName();
		return create(index, table, logic);
	}

	public static Check columnStartsWithColumn(Integer index, Table table, Column column1, Column column2) {
		var logic = column2.getName() + " is null or (left(" + column1.getName() + ", length(" + column2.getName() + ")) = " + column2.getName() + ")";
		return create(index, table, logic);
	}

	// Latte

	public static Check columnIsNIP(Integer index, Table table, Column column) {
		return CheckFactory.columnRegex(index, table, column, NIP.REGEX);
	}

	public static Check columnIsPangkat(Integer index, Table table, Column column) {
		return CheckFactory.columnRegex(index, table, column, Pangkat.REGEX_PNS + "|" + Pangkat.REGEX_P3K);
	}

	public static Check columnIsGender(Integer index, Table table, Column column) {
		return CheckFactory.columnIn(index, table, column, Arrays.stream(Gender.values()).map(Gender::getValue).toArray(Integer[]::new));
	}

}