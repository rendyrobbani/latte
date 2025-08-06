package com.rendyrobbani.latte.common.marker;

import com.rendyrobbani.latte.common.vo.NIP;

import java.time.LocalDateTime;

public interface HasAuditMutator {

	void setUpdatedAt(LocalDateTime updatedAt);

	void setUpdatedBy(NIP updatedBy);

	default void update(LocalDateTime updatedAt, NIP updatedBy) {
		this.setUpdatedAt(updatedAt != null ? updatedAt : LocalDateTime.now());
		this.setUpdatedBy(updatedBy);
	}

	default void update(NIP updatedBy) {
		this.update(null, updatedBy);
	}

	void setDeleted(boolean isDeleted);

	void setDeletedAt(LocalDateTime deletedAt);

	void setDeletedBy(NIP deletedBy);

	default void delete(LocalDateTime deletedAt, NIP deletedBy) {
		this.setDeleted(true);
		this.setDeletedAt(deletedAt != null ? deletedAt : LocalDateTime.now());
		this.setDeletedBy(deletedBy);
	}

	default void delete(NIP deletedBy) {
		this.delete(null, deletedBy);
	}

	default void restore(LocalDateTime restoreAt, NIP restoredBy) {
		this.setDeleted(false);
		this.setDeletedAt(null);
		this.setDeletedBy(null);
		this.update(restoreAt != null ? restoreAt : LocalDateTime.now(), restoredBy);
	}

	default void restore(NIP restoredBy) {
		this.restore(null, restoredBy);
	}

}