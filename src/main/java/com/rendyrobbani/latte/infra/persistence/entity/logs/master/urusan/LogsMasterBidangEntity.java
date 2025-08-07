package com.rendyrobbani.latte.infra.persistence.entity.logs.master.urusan;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.logs.master.urusan.LogsMasterBidang;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.urusan.MasterBidangEntity;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan.DataMasterBidangEntity;
import com.rendyrobbani.latte.schema.specification.logs.master.urusan.LogsMasterBidangTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = LogsMasterBidangTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LogsMasterBidangEntity extends MasterBidangEntity implements LogsMasterBidang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private DataMasterBidangEntity subject;

	@Column(name = "logged_at")
	private LocalDateTime loggedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "logged_by")
	private NIP loggedBy;

	public LogsMasterBidangEntity(LocalDateTime loggedAt, NIP loggedBy, DataMasterBidangEntity subject) {
		this.loggedAt = loggedAt;
		this.loggedBy = loggedBy;
		this.subject = subject;
		this.code = subject.getCode();
		this.name = subject.getName();
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