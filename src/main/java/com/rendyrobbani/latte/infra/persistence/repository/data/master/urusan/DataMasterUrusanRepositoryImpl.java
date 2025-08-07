package com.rendyrobbani.latte.infra.persistence.repository.data.master.urusan;

import com.rendyrobbani.latte.domain.entity.data.master.urusan.DataMasterUrusan;
import com.rendyrobbani.latte.domain.repository.data.master.urusan.DataMasterUrusanRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan.DataMasterUrusanEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataMasterUrusanRepositoryImpl extends BaseRepositoryImpl<String, DataMasterUrusan, DataMasterUrusanEntity> implements DataMasterUrusanRepository {

	private final DataMasterUrusanJpaRepository repository;

	public DataMasterUrusanRepositoryImpl(DataMasterUrusanJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataMasterUrusanEntity, String> getRepository() {
		return repository;
	}

}