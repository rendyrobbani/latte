package com.rendyrobbani.latte.infra.persistence.repository.data.master.program;

import com.rendyrobbani.latte.domain.entity.data.master.program.DataMasterProgram;
import com.rendyrobbani.latte.domain.repository.data.master.program.DataMasterProgramRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.program.DataMasterProgramEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataMasterProgramRepositoryImpl extends BaseRepositoryImpl<String, DataMasterProgram, DataMasterProgramEntity> implements DataMasterProgramRepository {

	private final DataMasterProgramJpaRepository repository;

	public DataMasterProgramRepositoryImpl(DataMasterProgramJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataMasterProgramEntity, String> getRepository() {
		return repository;
	}

}