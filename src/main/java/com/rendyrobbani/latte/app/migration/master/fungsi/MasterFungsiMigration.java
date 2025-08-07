package com.rendyrobbani.latte.app.migration.master.fungsi;

import com.rendyrobbani.common.classification.fungsi.FungsiClassificationFactory;
import com.rendyrobbani.latte.app.migration.Migration;
import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.domain.entity.data.master.fungsi.DataMasterFungsi;
import com.rendyrobbani.latte.domain.entity.data.user.DataUser;
import com.rendyrobbani.latte.domain.repository.data.master.fungsi.DataMasterFungsiRepository;
import com.rendyrobbani.latte.domain.repository.logs.master.fungsi.LogsMasterFungsiRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.fungsi.DataMasterFungsiEntity;
import com.rendyrobbani.latte.infra.persistence.entity.logs.master.fungsi.LogsMasterFungsiEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MasterFungsiMigration extends Migration {

	private final DataUser admin;

	private final JdbcTemplate template;

	private final DataMasterFungsiRepository dataRepository;

	private final LogsMasterFungsiRepository logsRepository;

	public MasterFungsiMigration(DataUser admin,
	                             JdbcTemplate template,
	                             DataMasterFungsiRepository dataRepository,
	                             LogsMasterFungsiRepository logsRepository) {
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

		var listData = dataRepository.findAll().stream().collect(Collectors.toMap(DataMasterFungsi::getCode, Function.identity()));

		template.query(sql, (rs, rowNum) -> {
			var code = rs.getString("id");
			var name = rs.getString("nama");

			var classification = FungsiClassificationFactory.classify(code);
			if (classification.isPresent() && !listData.containsKey(code)) {
				var data = new DataMasterFungsiEntity(now, nip, classification.get());
				data.setName(name);
				dataRepository.save(data);
				logsRepository.save(new LogsMasterFungsiEntity(now, nip, data));
			}
			return null;
		});
	}

}