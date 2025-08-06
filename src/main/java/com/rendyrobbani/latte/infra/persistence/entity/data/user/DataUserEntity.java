package com.rendyrobbani.latte.infra.persistence.entity.data.user;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.common.vo.Pangkat;
import com.rendyrobbani.latte.domain.data.user.DataUser;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataUserEntity extends UserEntity implements DataUser {

	@Id
	@Column(name = "id")
	private String id;

	@Getter(AccessLevel.NONE)
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

	@Override
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	@Override
	public void setLockedAt(LocalDateTime lockedAt) {
		this.lockedAt = lockedAt;
	}

	@Override
	public void setLockedBy(NIP lockedBy) {
		this.lockedBy = lockedBy;
	}

	@Override
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public void setUpdatedBy(NIP updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public void setDeletedBy(NIP deletedBy) {
		this.deletedBy = deletedBy;
	}

	public DataUserEntity(NIP nip, LocalDateTime createdAt, NIP createdBy) {
		this.id = nip.getValue();
		this.nip = nip;
		this.birthDate = nip.getBirthDate();
		this.startDate = nip.getStartDate();
		this.gender = nip.getGender();
		this.number = nip.getNumber();
		this.isLocked = false;
		this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
		this.createdBy = createdBy;
		this.isDeleted = false;
	}

}