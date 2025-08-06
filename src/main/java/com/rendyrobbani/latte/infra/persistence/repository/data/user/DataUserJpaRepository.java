package com.rendyrobbani.latte.infra.persistence.repository.data.user;

import com.rendyrobbani.latte.infra.persistence.entity.data.user.DataUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataUserJpaRepository extends JpaRepository<DataUserEntity, String> {

}