package com.rendyrobbani.latte.adapter.out.persistence.mapped.base;

import com.rendyrobbani.latte.adapter.out.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.domain.model.marker.audit.Lockable;
import com.rendyrobbani.latte.domain.model.valueobject.NIP;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractLockableEntity extends AbstractAuditableEntity implements Lockable {

	@Column(name = "is_locked")
	protected boolean isLocked;

	@Column(name = "locked_at")
	protected LocalDateTime lockedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "locked_by")
	protected NIP lockedBy;

	protected AbstractLockableEntity(LocalDateTime createdAt, NIP createdBy) {
		super(createdAt, createdBy);
		this.isLocked = false;
	}

	protected AbstractLockableEntity(NIP createdBy) {
		this(LocalDateTime.now(), createdBy);
	}

}