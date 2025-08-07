package com.rendyrobbani.latte.infra.persistence.entity.data.user;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.common.vo.Pangkat;
import com.rendyrobbani.latte.domain.entity.data.user.DataUser;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.user.UserEntity;
import com.rendyrobbani.latte.schema.specification.data.user.DataUserTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataUserTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataUserEntity extends UserEntity implements DataUser {

	@Id
	@Column(name = "id")
	private String id;

	@Convert(converter = NIPConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	private NIP nip;

	@Override
	public NIP getNIP() {
		return this.nip;
	}

	@Override
	public void setPangkat(Pangkat pangkat) {
		this.pangkat = pangkat;
		this.isPNS = pangkat.isPNS();
		this.isP3K = pangkat.isP3K();
	}

	@Override
	public void setStartDate(LocalDate startDate) {
		if (this.pangkat == null) return;
		if (this.pangkat.isPNS()) return;
		this.startDate = startDate;
	}

	public DataUserEntity(LocalDateTime createdAt, NIP createdBy, NIP nip) {
		super(createdAt, createdBy);
		this.id = nip.getValue();
		this.nip = nip;
		this.birthDate = nip.getBirthDate();
		this.startDate = nip.getStartDate();
		this.gender = nip.getGender();
		this.number = nip.getNumber();
		this.isLocked = false;
	}

}