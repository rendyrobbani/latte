package com.rendyrobbani.latte.common.marker;

import com.rendyrobbani.latte.common.vo.NIP;

import java.time.LocalDateTime;

public interface HasLockMutator extends HasAuditMutator {

	void setLocked(boolean isLocked);

	void setLockedAt(LocalDateTime lockedAt);

	void setLockedBy(NIP lockedBy);

	default void lock(LocalDateTime lockeddAt, NIP lockeddBy) {
		this.setLocked(true);
		this.setLockedAt(lockeddAt != null ? lockeddAt : LocalDateTime.now());
		this.setLockedBy(lockeddBy);
	}

	default void lock(NIP lockeddBy) {
		this.lock(null, lockeddBy);
	}

	default void unlock(LocalDateTime unlockedAt, NIP unlockeddBy) {
		this.setLocked(false);
		this.setLockedAt(null);
		this.setLockedBy(null);
		this.update(unlockedAt != null ? unlockedAt : LocalDateTime.now(), unlockeddBy);
	}

	default void unlock(NIP unlockeddBy) {
		this.unlock(null, unlockeddBy);
	}

}