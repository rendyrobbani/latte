package com.rendyrobbani.latte.infra.persistence.repository.data.master.fungsi;

import com.rendyrobbani.latte.domain.entity.data.master.fungsi.DataMasterSubfungsi;
import com.rendyrobbani.latte.domain.repository.data.master.fungsi.DataMasterSubfungsiRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.fungsi.DataMasterSubfungsiEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataMasterSubfungsiRepositoryImpl extends BaseRepositoryImpl<String, DataMasterSubfungsi, DataMasterSubfungsiEntity> implements DataMasterSubfungsiRepository {

	private final DataMasterSubfungsiJpaRepository repository;

	public DataMasterSubfungsiRepositoryImpl(DataMasterSubfungsiJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataMasterSubfungsiEntity, String> getRepository() {
		return repository;
	}

}