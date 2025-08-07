package com.rendyrobbani.latte.infra.persistence.repository.sipd.master.urusan;

import com.rendyrobbani.latte.domain.entity.sipd.master.urusan.SIPDMasterBidang;
import com.rendyrobbani.latte.domain.repository.sipd.master.urusan.SIPDMasterBidangRepository;
import com.rendyrobbani.latte.infra.persistence.entity.sipd.master.urusan.SIPDMasterBidangEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SIPDMasterBidangRepositoryImpl extends BaseRepositoryImpl<Long, SIPDMasterBidang, SIPDMasterBidangEntity> implements SIPDMasterBidangRepository {

	protected final SIPDMasterBidangJpaRepository repository;

	public SIPDMasterBidangRepositoryImpl(SIPDMasterBidangJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<SIPDMasterBidangEntity, Long> getRepository() {
		return repository;
	}

}