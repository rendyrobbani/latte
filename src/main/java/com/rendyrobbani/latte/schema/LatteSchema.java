package com.rendyrobbani.latte.schema;

import com.rendyrobbani.common.schema.Schema;
import com.rendyrobbani.common.util.number.NumberUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
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
			schemas.add(LatteSchemaOfMasterProgram.getSchema());
		}
		return schemas;
	}

	public static void writeDDL(File root) {
		try {
			if (root.exists() || root.mkdirs()) {
				for (int i = 0; i < getSchemas().size(); i++) {
					var schema = getSchemas().get(i);
					var number = NumberUtil.lpadZero(i + 1, 2);

					var path = number + ". " + schema.getName() + ".sql";
					var file = new File(root, path);

					try (var fos = new FileOutputStream(file)) {
						fos.write(schema.getDeleteDDL().getBytes(StandardCharsets.UTF_8));
						fos.write(System.lineSeparator().repeat(2).getBytes(StandardCharsets.UTF_8));
						fos.write(schema.getCreateDDL().getBytes(StandardCharsets.UTF_8));
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}