package com.rendyrobbani.latte.domain.model.marker.audit;

import com.rendyrobbani.latte.domain.model.valueobject.NIP;

import java.time.LocalDateTime;

public interface AuditMutator {

	void update(LocalDateTime updatedAt, NIP updatedBy);

	void update(NIP updatedBy);

	void delete(LocalDateTime deletedAt, NIP deletedBy);

	void delete(NIP deletedBy);

	void restore(LocalDateTime restoreAt, NIP restoredBy);

	void restore(NIP restoredBy);

}