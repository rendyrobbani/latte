package com.rendyrobbani.latte.infra.persistence.entity.sipd.master.program;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.sipd.master.program.SIPDMasterProgram;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.program.MasterProgramEntity;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.program.DataMasterProgramEntity;
import com.rendyrobbani.latte.schema.specification.sipd.master.program.SIPDMasterProgramTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = SIPDMasterProgramTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SIPDMasterProgramEntity extends MasterProgramEntity implements SIPDMasterProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private DataMasterProgramEntity subject;

	public SIPDMasterProgramEntity(LocalDateTime createdAt, NIP createdBy, DataMasterProgramEntity subject) {
		super(createdAt, createdBy);
		this.subject = subject;
		this.isLocked = false;
	}

}