package com.rendyrobbani.latte.common.marker;

import com.rendyrobbani.latte.common.vo.NIP;

import java.time.LocalDateTime;

public interface HasLockable {

	boolean isLocked();

	LocalDateTime getLockedAt();

	NIP getLockedBy();

}