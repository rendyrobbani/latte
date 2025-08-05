package com.rendyrobbani.latte.adapter.out.persistence.entity.data.user;

import com.rendyrobbani.latte.adapter.out.persistence.mapped.data.user.AbstractDataUserEntity;
import com.rendyrobbani.latte.domain.model.valueobject.NIP;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "data_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataUserEntity extends AbstractDataUserEntity {

	public DataUserEntity(NIP nip, LocalDateTime createdAt, NIP createdBy) {
		super(nip, createdAt, createdBy);
	}

	public DataUserEntity(NIP nip, NIP createdBy) {
		super(nip, createdBy);
	}

}