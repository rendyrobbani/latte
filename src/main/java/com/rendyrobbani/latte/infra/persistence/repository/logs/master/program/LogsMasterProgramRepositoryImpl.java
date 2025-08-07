package com.rendyrobbani.latte.infra.persistence.repository.logs.master.program;

import com.rendyrobbani.latte.domain.entity.logs.master.program.LogsMasterProgram;
import com.rendyrobbani.latte.domain.repository.logs.master.program.LogsMasterProgramRepository;
import com.rendyrobbani.latte.infra.persistence.entity.logs.master.program.LogsMasterProgramEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LogsMasterProgramRepositoryImpl extends BaseRepositoryImpl<Long, LogsMasterProgram, LogsMasterProgramEntity> implements LogsMasterProgramRepository {

	protected final LogsMasterProgramJpaRepository repository;

	public LogsMasterProgramRepositoryImpl(LogsMasterProgramJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<LogsMasterProgramEntity, Long> getRepository() {
		return repository;
	}

}