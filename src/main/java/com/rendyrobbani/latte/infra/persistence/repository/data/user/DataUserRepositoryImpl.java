package com.rendyrobbani.latte.infra.persistence.repository.data.user;

import com.rendyrobbani.latte.domain.entity.data.user.DataUser;
import com.rendyrobbani.latte.domain.repository.data.user.DataUserRepository;
import com.rendyrobbani.latte.infra.persistence.entity.data.user.DataUserEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataUserRepositoryImpl extends BaseRepositoryImpl<String, DataUser, DataUserEntity> implements DataUserRepository {

	private final DataUserJpaRepository repository;

	public DataUserRepositoryImpl(DataUserJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<DataUserEntity, String> getJpaRepository() {
		return this.repository;
	}

}