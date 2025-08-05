package com.rendyrobbani.latte.adapter.out.persistence.mapped.data.user;

import com.rendyrobbani.latte.adapter.out.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.adapter.out.persistence.mapped.base.user.AbstractUserEntity;
import com.rendyrobbani.latte.domain.meta.PangkatASN;
import com.rendyrobbani.latte.domain.model.entity.data.user.DataUser;
import com.rendyrobbani.latte.domain.model.valueobject.NIP;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractDataUserEntity extends AbstractUserEntity implements DataUser {

	@Id
	@Getter
	@Column(name = "id")
	protected String id;

	@Convert(converter = NIPConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	protected NIP nip;

	@Override
	public NIP getNIP() {
		return this.nip;
	}

	public void setPangkat(PangkatASN pangkat) {
		this.pangkat = pangkat;
		this.isPNS = pangkat.isPNS();
		this.isP3K = pangkat.isP3K();
	}

	public void setStartDate(LocalDate startDate) {
		if (this.isPNS) return;
		this.startDate = startDate;
	}

	protected AbstractDataUserEntity(NIP nip, LocalDateTime createdAt, NIP createdBy) {
		super(createdAt, createdBy);
		this.id = nip.getValue();
		this.nip = nip;
		this.birthDate = nip.getBirthDate();
		this.startDate = nip.getStartDate();
		this.gender = nip.getGender();
		this.number = nip.getNumber();
	}

	protected AbstractDataUserEntity(NIP nip, NIP createdBy) {
		super(createdBy);
		this.id = nip.getValue();
		this.nip = nip;
		this.birthDate = nip.getBirthDate();
		this.startDate = nip.getStartDate();
		this.gender = nip.getGender();
		this.number = nip.getNumber();
	}

	protected AbstractDataUserEntity() {
		super();
	}

}