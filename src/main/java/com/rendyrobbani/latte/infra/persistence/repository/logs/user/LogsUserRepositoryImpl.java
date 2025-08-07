package com.rendyrobbani.latte.infra.persistence.repository.logs.user;

import com.rendyrobbani.latte.domain.entity.logs.user.LogsUser;
import com.rendyrobbani.latte.domain.repository.logs.user.LogsUserRepository;
import com.rendyrobbani.latte.infra.persistence.entity.logs.user.LogsUserEntity;
import com.rendyrobbani.latte.infra.persistence.repository.base.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LogsUserRepositoryImpl extends BaseRepositoryImpl<Long, LogsUser, LogsUserEntity> implements LogsUserRepository {

	private final LogsUserJpaRepository repository;

	public LogsUserRepositoryImpl(LogsUserJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected JpaRepository<LogsUserEntity, Long> getRepository() {
		return repository;
	}

}