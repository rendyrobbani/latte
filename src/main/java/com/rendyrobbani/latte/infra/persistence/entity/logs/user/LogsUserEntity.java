package com.rendyrobbani.latte.infra.persistence.entity.logs.user;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.logs.user.LogsUser;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.user.UserEntity;
import com.rendyrobbani.latte.infra.persistence.entity.data.user.DataUserEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "logs_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LogsUserEntity extends UserEntity implements LogsUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id")
	private DataUserEntity subject;

	@Column(name = "logged_at")
	private LocalDateTime loggedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "logged_by")
	private NIP loggedBy;

	@Override
	public NIP getNIP() {
		if (this.getSubject() == null) return null;
		return this.getSubject().getNIP();
	}

	public LogsUserEntity(DataUserEntity subject, LocalDateTime loggedAt, NIP loggedBy) {
		this.subject = subject;
		this.loggedAt = loggedAt;
		this.loggedBy = loggedBy;

		this.pangkat = subject.getPangkat();
		this.name = subject.getName();
		this.titlePrefix = subject.getTitlePrefix();
		this.titleSuffix = subject.getTitleSuffix();
		this.password = subject.getPassword();
		this.birthDate = subject.getBirthDate();
		this.startDate = subject.getStartDate();
		this.gender = subject.getGender();
		this.number = subject.getNumber();
		this.isPNS = subject.isPNS();
		this.isP3K = subject.isP3K();
		this.isLocked = subject.isLocked();
		this.lockedAt = subject.getLockedAt();
		this.lockedBy = subject.getLockedBy();
		this.createdAt = subject.getCreatedAt();
		this.createdBy = subject.getCreatedBy();
		this.updatedAt = subject.getUpdatedAt();
		this.updatedBy = subject.getUpdatedBy();
		this.isDeleted = subject.isDeleted();
		this.deletedAt = subject.getDeletedAt();
		this.deletedBy = subject.getDeletedBy();
	}

}