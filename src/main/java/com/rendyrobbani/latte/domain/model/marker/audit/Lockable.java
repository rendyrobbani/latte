package com.rendyrobbani.latte.domain.model.marker.audit;

import com.rendyrobbani.latte.domain.model.valueobject.NIP;

import java.time.LocalDateTime;

public interface Lockable {

	LocalDateTime getLockedAt();

	NIP getLockedBy();

}