package com.rendyrobbani.latte.infra.persistence.repository.logs.master.fungsi;

import com.rendyrobbani.latte.domain.entity.logs.master.fungsi.LogsMasterFungsi;
import com.rendyrobbani.latte.domain.repository.logs.master.fungsi.LogsMasterFungsiRepository;
import com.rendyrobbani.latte.infra.persistence.entity.logs.master.fungsi.LogsMasterFungsiEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LogsMasterFungsiRepositoryImpl extends BaseRepositoryImpl<Long, LogsMasterFungsi, LogsMasterFungsiEntity> implements LogsMasterFungsiRepository {

	protected final LogsMasterFungsiJpaRepository repository;

	public LogsMasterFungsiRepositoryImpl(LogsMasterFungsiJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<LogsMasterFungsiEntity, Long> getRepository() {
		return repository;
	}

}