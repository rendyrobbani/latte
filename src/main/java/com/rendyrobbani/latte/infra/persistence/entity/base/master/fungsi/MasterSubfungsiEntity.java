package com.rendyrobbani.latte.infra.persistence.entity.base.master.fungsi;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.base.master.fungsi.MasterSubfungsi;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class MasterSubfungsiEntity extends BaseEntity implements MasterSubfungsi {

	@Column(name = "code")
	protected String code;

	@Column(name = "name")
	protected String name;

	@Column(name = "is_locked")
	protected boolean isLocked;

	@Column(name = "locked_at")
	protected LocalDateTime lockedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "locked_by")
	protected NIP lockedBy;

	protected MasterSubfungsiEntity(LocalDateTime createdAt, NIP createdBy) {
		super(createdAt, createdBy);
	}

}