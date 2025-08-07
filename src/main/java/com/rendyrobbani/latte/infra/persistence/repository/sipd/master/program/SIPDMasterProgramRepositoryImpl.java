package com.rendyrobbani.latte.infra.persistence.repository.sipd.master.program;

import com.rendyrobbani.latte.domain.entity.sipd.master.program.SIPDMasterProgram;
import com.rendyrobbani.latte.domain.repository.sipd.master.program.SIPDMasterProgramRepository;
import com.rendyrobbani.latte.infra.persistence.entity.sipd.master.program.SIPDMasterProgramEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SIPDMasterProgramRepositoryImpl extends BaseRepositoryImpl<Long, SIPDMasterProgram, SIPDMasterProgramEntity> implements SIPDMasterProgramRepository {

	protected final SIPDMasterProgramJpaRepository repository;

	public SIPDMasterProgramRepositoryImpl(SIPDMasterProgramJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<SIPDMasterProgramEntity, Long> getRepository() {
		return repository;
	}

}