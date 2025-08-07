package com.rendyrobbani.latte.infra.persistence.repository.logs.master.fungsi;

import com.rendyrobbani.latte.domain.entity.logs.master.fungsi.LogsMasterSubfungsi;
import com.rendyrobbani.latte.domain.repository.logs.master.fungsi.LogsMasterSubfungsiRepository;
import com.rendyrobbani.latte.infra.persistence.entity.logs.master.fungsi.LogsMasterSubfungsiEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LogsMasterSubfungsiRepositoryImpl extends BaseRepositoryImpl<Long, LogsMasterSubfungsi, LogsMasterSubfungsiEntity> implements LogsMasterSubfungsiRepository {

	protected final LogsMasterSubfungsiJpaRepository repository;

	public LogsMasterSubfungsiRepositoryImpl(LogsMasterSubfungsiJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<LogsMasterSubfungsiEntity, Long> getRepository() {
		return repository;
	}

}