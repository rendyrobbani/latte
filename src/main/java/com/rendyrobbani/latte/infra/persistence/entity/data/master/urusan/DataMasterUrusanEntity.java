package com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan;

import com.rendyrobbani.common.classification.urusan.UrusanClassification;
import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.data.master.urusan.DataMasterUrusan;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.urusan.MasterUrusanEntity;
import com.rendyrobbani.latte.schema.specification.data.master.urusan.DataMasterUrusanTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = DataMasterUrusanTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterUrusanEntity extends MasterUrusanEntity implements DataMasterUrusan {

	@Id
	@Column(name = "id")
	private String id;

	public DataMasterUrusanEntity(LocalDateTime createdAt, NIP createdBy, UrusanClassification classification) {
		super(createdAt, createdBy);
		this.id = classification.getUrusanCode().replaceAll("X", "0");
		this.code = classification.getUrusanCode();
		this.isLocked = classification.getUrusanCode().startsWith("X");
		if (this.isLocked) {
			this.lockedAt = createdAt;
			this.lockedBy = createdBy;
		}
	}

}