package com.rendyrobbani.latte.infra.persistence.repository.logs.master.urusan;

import com.rendyrobbani.latte.domain.entity.logs.master.urusan.LogsMasterUrusan;
import com.rendyrobbani.latte.domain.repository.logs.master.urusan.LogsMasterUrusanRepository;
import com.rendyrobbani.latte.infra.persistence.entity.logs.master.urusan.LogsMasterUrusanEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LogsMasterUrusanRepositoryImpl extends BaseRepositoryImpl<Long, LogsMasterUrusan, LogsMasterUrusanEntity> implements LogsMasterUrusanRepository {

	protected final LogsMasterUrusanJpaRepository repository;

	public LogsMasterUrusanRepositoryImpl(LogsMasterUrusanJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<LogsMasterUrusanEntity, Long> getRepository() {
		return repository;
	}

}