package com.rendyrobbani.latte.infra.persistence.entity.base;

import com.rendyrobbani.latte.common.marker.HasAuditable;
import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class BaseEntity implements Serializable, HasAuditable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "created_at")
	protected LocalDateTime createdAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "created_by")
	protected NIP createdBy;

	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "updated_by")
	protected NIP updatedBy;

	@Column(name = "is_deleted")
	protected boolean isDeleted;

	@Column(name = "deleted_at")
	protected LocalDateTime deletedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "deleted_by")
	protected NIP deletedBy;

	protected BaseEntity(LocalDateTime createdAt, NIP createdBy) {
		this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
		this.createdBy = createdBy;
		this.updatedAt = null;
		this.updatedBy = null;
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
	}

}