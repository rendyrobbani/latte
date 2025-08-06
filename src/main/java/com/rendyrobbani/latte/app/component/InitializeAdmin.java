package com.rendyrobbani.latte.app.component;

import com.rendyrobbani.latte.common.vo.NIPFactory;
import com.rendyrobbani.latte.common.vo.Pangkat;
import com.rendyrobbani.latte.domain.entity.data.user.DataUser;
import com.rendyrobbani.latte.domain.repository.data.user.DataUserRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.user.DataUserEntity;
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

	public InitializeAdmin(DataUserRepository dataUserRepository) {
		this.dataUserRepository = dataUserRepository;
	}

	@Bean
	@Transactional
	public DataUser admin() {
		var admin = dataUserRepository.findById(ADMIN_ID).orElse(null);
		if (admin == null) {
			var nip = NIPFactory.parse(ADMIN_ID);
			admin = new DataUserEntity(nip, LocalDateTime.now(), nip);
			admin.setPangkat(ADMIN_PANGKAT);
			admin.setName(ADMIN_NAME);
			admin.setTitlePrefix(ADMIN_TITLE_PREFIX);
			admin.setTitleSuffix(ADMIN_TITLE_SUFFIX);
			admin.setPassword(ADMIN_PASSWORD);
			admin = dataUserRepository.save(admin);
		}
		return admin;
	}

}