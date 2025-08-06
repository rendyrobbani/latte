package com.rendyrobbani.latte.schema.factory;

import com.rendyrobbani.common.classification.fungsi.FungsiClassification;
import com.rendyrobbani.common.classification.fungsi.SubfungsiClassification;
import com.rendyrobbani.common.schema.Check;
import com.rendyrobbani.common.schema.CheckFactory;
import com.rendyrobbani.common.schema.Column;
import com.rendyrobbani.common.schema.Table;
import com.rendyrobbani.latte.common.vo.Gender;
import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.common.vo.Pangkat;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteCheckFactory {

	public static Check columnIsNIP(Integer index, Table table, Column column) {
		return CheckFactory.columnRegex(index, table, column, NIP.REGEX);
	}

	public static Check columnIsPangkatASN(Integer index, Table table, Column column) {
		return CheckFactory.columnRegex(index, table, column, Pangkat.REGEX_PNS + "|" + Pangkat.REGEX_P3K);
	}

	public static Check columnIsGender(Integer index, Table table, Column column) {
		return CheckFactory.columnIn(index, table, column, Arrays.stream(Gender.values()).map(Gender::getValue).toArray(Integer[]::new));
	}

	public static Check columnIsFungsiCode(Integer index, Table table, Column column) {
		return CheckFactory.columnRegex(index, table, column, FungsiClassification.REGEX);
	}

	public static Check columnIsSubfungsiCode(Integer index, Table table, Column column) {
		return CheckFactory.columnRegex(index, table, column, SubfungsiClassification.REGEX);
	}

}