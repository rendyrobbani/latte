package com.rendyrobbani.latte.domain.model.marker.audit;

import com.rendyrobbani.latte.domain.model.valueobject.NIP;

import java.time.LocalDateTime;

public interface Lockable {

	LocalDateTime getLockedAt();

	NIP getLockedBy();

	void lock(LocalDateTime lockedAt, NIP lockedBy);

	void lock(NIP lockedBy);

	void unlock(LocalDateTime unlockedAt, NIP unlockedBy);

	void unlock(NIP unlockedBy);

}