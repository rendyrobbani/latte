package com.rendyrobbani.latte.infra.persistence.repository.data.master.program;

import com.rendyrobbani.latte.infra.persistence.entity.data.master.program.DataMasterProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataMasterProgramJpaRepository extends JpaRepository<DataMasterProgramEntity, String> {

}