package com.rendyrobbani.latte.infra.persistence.entity.base;

import com.rendyrobbani.latte.common.marker.HasAuditable;
import com.rendyrobbani.latte.common.vo.NIP;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntity implements Serializable, HasAuditable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "created_at")
	protected LocalDateTime createdAt;

	@Column(name = "created_by")
	protected NIP createdBy;

	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;

	@Column(name = "updated_by")
	protected NIP updatedBy;

	@Column(name = "is_deleted")
	protected boolean isDeleted;

	@Column(name = "deleted_at")
	protected LocalDateTime deletedAt;

	@Column(name = "deleted_by")
	protected NIP deletedBy;

	public BaseEntity(LocalDateTime createdAt, NIP createdBy) {
		this.createdAt = createdAt != null ? createdAt : LocalDateTime.now() ;
		this.createdBy = createdBy;
		this.updatedAt = null;
		this.updatedBy = null;
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
	}

}