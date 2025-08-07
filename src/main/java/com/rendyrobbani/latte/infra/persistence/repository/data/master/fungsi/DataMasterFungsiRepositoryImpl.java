package com.rendyrobbani.latte.infra.persistence.repository.data.master.fungsi;

import com.rendyrobbani.latte.domain.entity.data.master.fungsi.DataMasterFungsi;
import com.rendyrobbani.latte.domain.repository.data.master.fungsi.DataMasterFungsiRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.fungsi.DataMasterFungsiEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataMasterFungsiRepositoryImpl extends BaseRepositoryImpl<String, DataMasterFungsi, DataMasterFungsiEntity> implements DataMasterFungsiRepository {

	private final DataMasterFungsiJpaRepository repository;

	public DataMasterFungsiRepositoryImpl(DataMasterFungsiJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataMasterFungsiEntity, String> getRepository() {
		return repository;
	}

}