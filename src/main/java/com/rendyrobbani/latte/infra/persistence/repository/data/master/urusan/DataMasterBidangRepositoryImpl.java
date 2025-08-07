package com.rendyrobbani.latte.infra.persistence.repository.data.master.urusan;

import com.rendyrobbani.latte.domain.entity.data.master.urusan.DataMasterBidang;
import com.rendyrobbani.latte.domain.repository.data.master.urusan.DataMasterBidangRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan.DataMasterBidangEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataMasterBidangRepositoryImpl extends BaseRepositoryImpl<String, DataMasterBidang, DataMasterBidangEntity> implements DataMasterBidangRepository {

	private final DataMasterBidangJpaRepository repository;

	public DataMasterBidangRepositoryImpl(DataMasterBidangJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataMasterBidangEntity, String> getRepository() {
		return repository;
	}

}