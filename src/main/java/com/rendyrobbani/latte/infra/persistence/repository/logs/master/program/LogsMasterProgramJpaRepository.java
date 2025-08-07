package com.rendyrobbani.latte.infra.persistence.repository.logs.master.program;

import com.rendyrobbani.latte.infra.persistence.entity.logs.master.program.LogsMasterProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsMasterProgramJpaRepository extends JpaRepository<LogsMasterProgramEntity, Long> {

}