package com.rendyrobbani.latte.app.migration.master.fungsi;

import com.rendyrobbani.common.classification.fungsi.SubfungsiClassificationFactory;
import com.rendyrobbani.latte.app.migration.Migration;
import com.rendyrobbani.latte.domain.entity.data.master.fungsi.DataMasterSubfungsi;
import com.rendyrobbani.latte.domain.entity.data.user.DataUser;
import com.rendyrobbani.latte.domain.repository.data.master.fungsi.DataMasterSubfungsiRepository;
import com.rendyrobbani.latte.domain.repository.logs.master.fungsi.LogsMasterSubfungsiRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.fungsi.DataMasterSubfungsiEntity;
import com.rendyrobbani.latte.infra.persistence.entity.logs.master.fungsi.LogsMasterSubfungsiEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MasterSubfungsiMigration extends Migration {

	private final DataUser admin;

	private final JdbcTemplate template;

	private final DataMasterSubfungsiRepository dataRepository;

	private final LogsMasterSubfungsiRepository logsRepository;

	public MasterSubfungsiMigration(DataUser admin,
	                                JdbcTemplate template,
	                                DataMasterSubfungsiRepository dataRepository,
	                                LogsMasterSubfungsiRepository logsRepository) {
		this.admin = admin;
		this.template = template;
		this.dataRepository = dataRepository;
		this.logsRepository = logsRepository;
	}

	@Override
	public void migrateData(String fromSchema, String fromTable) {
		fromSchema = fromSchema != null ? fromSchema : FROM_SCHEMA;
		var sql = "select * from " + fromSchema + "." + fromTable;
		var now = LocalDateTime.now();
		var nip = admin.getNIP();

		var listData = dataRepository.findAll().stream().collect(Collectors.toMap(DataMasterSubfungsi::getCode, Function.identity()));

		template.query(sql, (rs, rowNum) -> {
			var code = rs.getString("id");
			var name = rs.getString("nama");

			var classification = SubfungsiClassificationFactory.classify(code);
			if (classification.isPresent() && !listData.containsKey(code)) {
				var data = new DataMasterSubfungsiEntity(now, nip, classification.get());
				data.setName(name);
				dataRepository.save(data);
				logsRepository.save(new LogsMasterSubfungsiEntity(now, nip, data));
			}
			return null;
		});
	}

}