package com.rendyrobbani.latte.infra.persistence.entity.logs.master.urusan;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.logs.master.urusan.LogsMasterUrusan;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.urusan.MasterUrusanEntity;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan.DataMasterUrusanEntity;
import com.rendyrobbani.latte.schema.specification.logs.master.urusan.LogsMasterUrusanTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = LogsMasterUrusanTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LogsMasterUrusanEntity extends MasterUrusanEntity implements LogsMasterUrusan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private DataMasterUrusanEntity subject;

	@Column(name = "logged_at")
	private LocalDateTime loggedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "logged_by")
	private NIP loggedBy;

	public LogsMasterUrusanEntity(LocalDateTime loggedAt, NIP loggedBy, DataMasterUrusanEntity subject) {
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