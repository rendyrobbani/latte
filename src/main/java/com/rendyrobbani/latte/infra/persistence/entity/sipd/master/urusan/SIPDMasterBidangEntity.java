package com.rendyrobbani.latte.infra.persistence.entity.sipd.master.urusan;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.sipd.master.urusan.SIPDMasterBidang;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.urusan.MasterBidangEntity;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan.DataMasterBidangEntity;
import com.rendyrobbani.latte.schema.specification.sipd.master.urusan.SIPDMasterBidangTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = SIPDMasterBidangTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SIPDMasterBidangEntity extends MasterBidangEntity implements SIPDMasterBidang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private DataMasterBidangEntity subject;

	public SIPDMasterBidangEntity(LocalDateTime createdAt, NIP createdBy, DataMasterBidangEntity subject) {
		super(createdAt, createdBy);
		this.subject = subject;
		this.isLocked = false;
	}

}