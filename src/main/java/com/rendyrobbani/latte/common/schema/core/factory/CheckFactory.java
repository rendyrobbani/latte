package com.rendyrobbani.latte.common.schema.core.factory;

import com.rendyrobbani.latte.common.schema.core.Check;
import com.rendyrobbani.latte.common.schema.core.Column;
import com.rendyrobbani.latte.common.schema.core.Table;
import com.rendyrobbani.latte.common.util.number.NumberUtil;
import com.rendyrobbani.latte.domain.meta.Gender;
import com.rendyrobbani.latte.domain.meta.PangkatP3K;
import com.rendyrobbani.latte.domain.meta.PangkatPNS;
import com.rendyrobbani.latte.domain.model.valueobject.NIP;
import com.rendyrobbani.latte.domain.model.valueobject.classification.fungsi.FungsiClassification;
import com.rendyrobbani.latte.domain.model.valueobject.classification.fungsi.SubfungsiClassification;
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

	public static Check columnIsNIP(Integer index, Table table, Column column) {
		return columnRegex(index, table, column, NIP.REGEX);
	}

	public static Check columnIsPangkatASN(Integer index, Table table, Column column) {
		return columnRegex(index, table, column, PangkatPNS.REGEX + "|" + PangkatP3K.REGEX);
	}

	public static Check columnIsGender(Integer index, Table table, Column column) {
		return columnIn(index, table, column, Arrays.stream(Gender.values()).map(Gender::getValue).toArray(Integer[]::new));
	}

	public static Check columnIsFungsiCode(Integer index, Table table, Column column) {
		return columnRegex(index, table, column, FungsiClassification.REGEX);
	}

	public static Check columnIsSubfungsiCode(Integer index, Table table, Column column) {
		return columnRegex(index, table, column, SubfungsiClassification.REGEX);
	}


}