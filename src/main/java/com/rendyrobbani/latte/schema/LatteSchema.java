package com.rendyrobbani.latte.schema;

import com.rendyrobbani.common.schema.Schema;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteSchema {

	private static Map<String, Schema> schemas;

	public static Map<String, Schema> getSchemas() {
		if (schemas == null) {
			schemas = new HashMap<>();
			schemas.put("User", LatteSchemaOfUser.getSchema());
			schemas.put("MasterFungsi", LatteSchemaOfMasterFungsi.getSchema());
		}
		return schemas;
	}

}