package com.rendyrobbani.latte.app.component;

import com.rendyrobbani.latte.common.vo.NIPFactory;
import com.rendyrobbani.latte.common.vo.Pangkat;
import com.rendyrobbani.latte.domain.entity.data.user.DataUser;
import com.rendyrobbani.latte.domain.repository.data.user.DataUserRepository;
import com.rendyrobbani.latte.domain.repository.logs.user.LogsUserRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.user.DataUserEntity;
import com.rendyrobbani.latte.infra.persistence.entity.logs.user.LogsUserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class InitializeAdmin {

	private static final String ADMIN_ID = "199510172019031003";

	private static final Pangkat ADMIN_PANGKAT = Pangkat.PNS_2C;

	private static final String ADMIN_NAME = "Rendy Robbani";

	private static final String ADMIN_TITLE_PREFIX = null;

	private static final String ADMIN_TITLE_SUFFIX = "A.Md.";

	private static final String ADMIN_PASSWORD = "$2a$12$vrC9MirbIo.oGunJ1OYrvebmTLQBkFQcQGzpXy5av8lTfyyED242W";

	private final DataUserRepository dataUserRepository;

	private final LogsUserRepository logsUserRepository;

	public InitializeAdmin(DataUserRepository dataUserRepository, LogsUserRepository logsUserRepository) {
		this.dataUserRepository = dataUserRepository;
		this.logsUserRepository = logsUserRepository;
	}

	@Bean
	@Transactional
	public DataUser admin() {
		var admin = dataUserRepository.findById(ADMIN_ID).orElse(null);
		if (admin == null) {
			var now = LocalDateTime.now();
			var nip = NIPFactory.parse(ADMIN_ID);
			var data = new DataUserEntity(nip, now, nip);
			data.setPangkat(ADMIN_PANGKAT);
			data.setName(ADMIN_NAME);
			data.setTitlePrefix(ADMIN_TITLE_PREFIX);
			data.setTitleSuffix(ADMIN_TITLE_SUFFIX);
			data.setPassword(ADMIN_PASSWORD);
			dataUserRepository.save(data);
			logsUserRepository.save(new LogsUserEntity(data, now, nip));
			admin = data;
		}
		return admin;
	}

}