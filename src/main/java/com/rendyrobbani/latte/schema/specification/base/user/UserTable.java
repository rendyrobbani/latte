package com.rendyrobbani.latte.schema.specification.base.user;

import com.rendyrobbani.common.schema.Column;
import com.rendyrobbani.common.schema.ColumnFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createChar("pangkat", 2, false));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.add(ColumnFactory.createVarChar("title_prefix", true));
			columns.add(ColumnFactory.createVarChar("title_suffix", true));
			columns.add(ColumnFactory.createVarChar("password", false));
			columns.add(ColumnFactory.createDateOnly("birth_date", false));
			columns.add(ColumnFactory.createDateOnly("start_date", true));
			columns.add(ColumnFactory.createTinyInt("gender", false));
			columns.add(ColumnFactory.createSmallInt("number", false));
			columns.add(ColumnFactory.createBoolean("is_pns", false));
			columns.add(ColumnFactory.createBoolean("is_p3k", false));
		}
		return columns;
	}

}