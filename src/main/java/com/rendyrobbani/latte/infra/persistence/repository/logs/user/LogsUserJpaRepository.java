package com.rendyrobbani.latte.infra.persistence.repository.logs.user;

import com.rendyrobbani.latte.infra.persistence.entity.logs.user.LogsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsUserJpaRepository extends JpaRepository<LogsUserEntity, Long> {

}