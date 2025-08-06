package com.rendyrobbani.latte.common.marker;

import com.rendyrobbani.latte.common.vo.NIP;

import java.time.LocalDateTime;

public interface HasAuditable {

	LocalDateTime getCreatedAt();

	NIP getCreatedBy();

	LocalDateTime getUpdatedAt();

	NIP getUpdatedBy();

	boolean isDeleted();

	LocalDateTime getDeletedAt();

	NIP getDeletedBy();

}