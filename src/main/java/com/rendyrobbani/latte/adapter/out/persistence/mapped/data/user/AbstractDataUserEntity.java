package com.rendyrobbani.latte.adapter.out.persistence.mapped.data.user;

import com.rendyrobbani.latte.adapter.out.persistence.mapped.base.user.AbstractUserEntity;
import com.rendyrobbani.latte.domain.model.entity.data.user.DataUser;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractDataUserEntity extends AbstractUserEntity implements DataUser {

	@Id
	@Getter
	@Column(name = "id")
	protected String id;

	@Column(name = "id", insertable = false, updatable = false)
	protected String nip;



}