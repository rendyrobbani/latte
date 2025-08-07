package com.rendyrobbani.latte.infra.persistence.entity.data.master.fungsi;

import com.rendyrobbani.common.classification.fungsi.FungsiClassification;
import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.data.master.fungsi.DataMasterFungsi;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.fungsi.MasterFungsiEntity;
import com.rendyrobbani.latte.schema.specification.data.master.fungsi.DataMasterFungsiTable;
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
@Table(name = DataMasterFungsiTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterFungsiEntity extends MasterFungsiEntity implements DataMasterFungsi {

	@Id
	@Column(name = "id")
	private String id;

	public DataMasterFungsiEntity(LocalDateTime createdAt, NIP createdBy, FungsiClassification classification) {
		super(createdAt, createdBy);
		this.id = classification.getFungsiCode();
		this.code = classification.getFungsiCode();
		this.isLocked = classification.getFungsiCode().startsWith("00");
	}

}