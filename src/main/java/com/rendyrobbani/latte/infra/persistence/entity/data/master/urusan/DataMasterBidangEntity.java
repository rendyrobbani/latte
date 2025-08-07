package com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan;

import com.rendyrobbani.common.classification.urusan.BidangClassification;
import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.data.master.urusan.DataMasterBidang;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.urusan.MasterBidangEntity;
import com.rendyrobbani.latte.schema.specification.data.master.urusan.DataMasterBidangTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataMasterBidangTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterBidangEntity extends MasterBidangEntity implements DataMasterBidang {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "urusan_id")
	private String urusanId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "urusan_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DataMasterUrusanEntity urusan;

	public DataMasterBidangEntity(LocalDateTime createdAt, NIP createdBy, BidangClassification classification) {
		super(createdAt, createdBy);
		this.id = classification.getBidangCode().replaceAll("X", "0");
		this.code = classification.getBidangCode();
		this.isLocked = classification.getBidangCode().startsWith("X");
		if (this.isLocked) {
			this.lockedAt = createdAt;
			this.lockedBy = createdBy;
		}

		this.urusanId = classification.getUrusanCode().replaceAll("X", "0");
	}

}