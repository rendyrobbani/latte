package com.rendyrobbani.latte.adapter.out.persistence.mapped.base;

import com.rendyrobbani.latte.adapter.out.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.domain.model.marker.audit.Lockable;
import com.rendyrobbani.latte.domain.model.valueobject.NIP;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class AbstractLockableEntity extends AbstractAuditableEntity implements Lockable {

	@Column(name = "is_locked")
	protected boolean isLocked;

	@Column(name = "locked_at")
	protected LocalDateTime lockedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "locked_by")
	protected NIP lockedBy;

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

	protected AbstractLockableEntity(LocalDateTime createdAt, NIP createdBy) {
		super(createdAt, createdBy);
		this.isLocked = false;
	}

	protected AbstractLockableEntity(NIP createdBy) {
		this(LocalDateTime.now(), createdBy);
	}

	protected AbstractLockableEntity() {
		this(LocalDateTime.now(), null);
	}

}