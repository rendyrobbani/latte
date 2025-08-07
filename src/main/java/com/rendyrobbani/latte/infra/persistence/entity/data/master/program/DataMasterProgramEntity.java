package com.rendyrobbani.latte.infra.persistence.entity.data.master.program;

import com.rendyrobbani.common.classification.program.ProgramClassification;
import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.data.master.program.DataMasterProgram;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.program.MasterProgramEntity;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan.DataMasterBidangEntity;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan.DataMasterUrusanEntity;
import com.rendyrobbani.latte.schema.specification.data.master.program.DataMasterProgramTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataMasterProgramTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterProgramEntity extends MasterProgramEntity implements DataMasterProgram {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "urusan_id")
	private String urusanId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "urusan_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DataMasterUrusanEntity urusan;

	@Column(name = "bidang_id")
	private String bidangId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bidang_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DataMasterBidangEntity bidang;

	public DataMasterProgramEntity(LocalDateTime createdAt, NIP createdBy, ProgramClassification classification) {
		super(createdAt, createdBy);
		this.id = classification.getProgramCode().replaceAll("X", "0");
		this.code = classification.getProgramCode();
		this.isLocked = classification.getProgramCode().startsWith("X");
		if (this.isLocked) {
			this.lockedAt = createdAt;
			this.lockedBy = createdBy;
		}
		this.urusanId = classification.getUrusanCode().replaceAll("X", "0");
		this.bidangId = classification.getBidangCode().replaceAll("X", "0");
	}

}