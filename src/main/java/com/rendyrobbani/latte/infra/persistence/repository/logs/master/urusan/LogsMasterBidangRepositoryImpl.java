package com.rendyrobbani.latte.infra.persistence.repository.logs.master.urusan;

import com.rendyrobbani.latte.domain.entity.logs.master.urusan.LogsMasterBidang;
import com.rendyrobbani.latte.domain.repository.logs.master.urusan.LogsMasterBidangRepository;
import com.rendyrobbani.latte.infra.persistence.entity.logs.master.urusan.LogsMasterBidangEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LogsMasterBidangRepositoryImpl extends BaseRepositoryImpl<Long, LogsMasterBidang, LogsMasterBidangEntity> implements LogsMasterBidangRepository {

	protected final LogsMasterBidangJpaRepository repository;

	public LogsMasterBidangRepositoryImpl(LogsMasterBidangJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<LogsMasterBidangEntity, Long> getRepository() {
		return repository;
	}

}