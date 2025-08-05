package com.rendyrobbani.latte.adapter.out.persistence.mapped.base;

import com.rendyrobbani.latte.adapter.out.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.domain.model.marker.audit.Auditable;
import com.rendyrobbani.latte.domain.model.valueobject.NIP;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class AbstractAuditableEntity extends AbstractEntity implements Auditable {

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

	@Override
	public void update(LocalDateTime updatedAt, NIP updatedBy) {
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	@Override
	public void update(NIP updatedBy) {
		this.update(LocalDateTime.now(), updatedBy);
	}

	@Override
	public void delete(LocalDateTime deletedAt, NIP deletedBy) {
		this.isDeleted = true;
		this.deletedAt = deletedAt;
		this.deletedBy = deletedBy;
	}

	@Override
	public void delete(NIP deletedBy) {
		this.delete(LocalDateTime.now(), deletedBy);
	}

	@Override
	public void restore(LocalDateTime restoreAt, NIP restoredBy) {
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
		this.updatedAt = restoreAt;
		this.updatedBy = restoredBy;
	}

	@Override
	public void restore(NIP restoredBy) {
		this.restore(LocalDateTime.now(), restoredBy);
	}

	protected AbstractAuditableEntity(LocalDateTime createdAt, NIP createdBy) {
		super();
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = null;
		this.updatedBy = null;
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
	}

	protected AbstractAuditableEntity(NIP createdBy) {
		this(LocalDateTime.now(), createdBy);
	}

	protected AbstractAuditableEntity() {
		this(LocalDateTime.now(), null);
	}

}