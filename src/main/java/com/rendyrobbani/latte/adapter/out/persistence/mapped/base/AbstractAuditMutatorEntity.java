package com.rendyrobbani.latte.adapter.out.persistence.mapped.base;

import com.rendyrobbani.latte.domain.model.marker.audit.AuditMutator;
import com.rendyrobbani.latte.domain.model.valueobject.NIP;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractAuditMutatorEntity extends AbstractAuditableEntity implements AuditMutator {

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

}