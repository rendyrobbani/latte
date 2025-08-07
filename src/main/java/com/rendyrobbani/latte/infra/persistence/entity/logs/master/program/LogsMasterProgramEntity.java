package com.rendyrobbani.latte.infra.persistence.entity.logs.master.program;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.logs.master.program.LogsMasterProgram;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.program.MasterProgramEntity;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.program.DataMasterProgramEntity;
import com.rendyrobbani.latte.schema.specification.logs.master.program.LogsMasterProgramTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = LogsMasterProgramTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LogsMasterProgramEntity extends MasterProgramEntity implements LogsMasterProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private DataMasterProgramEntity subject;

	@Column(name = "logged_at")
	private LocalDateTime loggedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "logged_by")
	private NIP loggedBy;

	public LogsMasterProgramEntity(LocalDateTime loggedAt, NIP loggedBy, DataMasterProgramEntity subject) {
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