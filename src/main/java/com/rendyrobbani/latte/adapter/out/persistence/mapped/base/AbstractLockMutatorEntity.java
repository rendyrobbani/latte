package com.rendyrobbani.latte.adapter.out.persistence.mapped.base;

import com.rendyrobbani.latte.domain.model.marker.audit.LockMutator;
import com.rendyrobbani.latte.domain.model.valueobject.NIP;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractLockMutatorEntity extends AbstractLockableEntity implements LockMutator {

	@Override
	public void lock(LocalDateTime lockedAt, NIP lockedBy) {
		this.isLocked = true;
		this.lockedAt = lockedAt;
		this.lockedBy = lockedBy;
	}

	@Override
	public void lock(NIP lockedBy) {
		this.lock(LocalDateTime.now(), lockedBy);
	}

	@Override
	public void unlock(LocalDateTime unlockedAt, NIP unlockedBy) {
		this.isLocked = false;
		this.lockedAt = null;
		this.lockedBy = null;
		this.updatedAt = unlockedAt;
		this.updatedBy = unlockedBy;
	}

	@Override
	public void unlock(NIP unlockedBy) {
		this.unlock(LocalDateTime.now(), unlockedBy);
	}

}