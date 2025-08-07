package com.rendyrobbani.latte.infra.persistence.entity.data.master.fungsi;

import com.rendyrobbani.common.classification.fungsi.SubfungsiClassification;
import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.data.master.fungsi.DataMasterSubfungsi;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.fungsi.MasterSubfungsiEntity;
import com.rendyrobbani.latte.schema.specification.data.master.fungsi.DataMasterSubfungsiTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataMasterSubfungsiTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterSubfungsiEntity extends MasterSubfungsiEntity implements DataMasterSubfungsi {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "fungsi_id")
	private String fungsiId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fungsi_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DataMasterFungsiEntity fungsi;

	public DataMasterSubfungsiEntity(LocalDateTime createdAt, NIP createdBy, SubfungsiClassification classification) {
		super(createdAt, createdBy);
		this.id = classification.getSubfungsiCode();
		this.code = classification.getSubfungsiCode();
		this.isLocked = classification.getSubfungsiCode().startsWith("00");
		if (this.isLocked) {
			this.lockedAt = createdAt;
			this.lockedBy = createdBy;
		}

		this.fungsiId = classification.getFungsiCode();
	}

}