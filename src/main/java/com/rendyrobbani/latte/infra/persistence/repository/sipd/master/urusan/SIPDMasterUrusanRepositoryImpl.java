package com.rendyrobbani.latte.infra.persistence.repository.sipd.master.urusan;

import com.rendyrobbani.latte.domain.entity.sipd.master.urusan.SIPDMasterUrusan;
import com.rendyrobbani.latte.domain.repository.sipd.master.urusan.SIPDMasterUrusanRepository;
import com.rendyrobbani.latte.infra.persistence.entity.sipd.master.urusan.SIPDMasterUrusanEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SIPDMasterUrusanRepositoryImpl extends BaseRepositoryImpl<Long, SIPDMasterUrusan, SIPDMasterUrusanEntity> implements SIPDMasterUrusanRepository {

	protected final SIPDMasterUrusanJpaRepository repository;

	public SIPDMasterUrusanRepositoryImpl(SIPDMasterUrusanJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<SIPDMasterUrusanEntity, Long> getRepository() {
		return repository;
	}

}