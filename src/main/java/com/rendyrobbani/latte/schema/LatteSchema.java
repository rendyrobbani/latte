package com.rendyrobbani.latte.schema;

import com.rendyrobbani.common.schema.Schema;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteSchema {

	private static List<Schema> schemas;

	public static List<Schema> getSchemas() {
		if (schemas == null) {
			schemas = new ArrayList<>();
			schemas.add(LatteSchemaOfUser.getSchema());
			schemas.add(LatteSchemaOfMasterFungsi.getSchema());
			schemas.add(LatteSchemaOfMasterUrusan.getSchema());
		}
		return schemas;
	}

}