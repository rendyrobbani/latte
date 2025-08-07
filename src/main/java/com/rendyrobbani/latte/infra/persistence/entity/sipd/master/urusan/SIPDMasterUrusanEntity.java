package com.rendyrobbani.latte.infra.persistence.entity.sipd.master.urusan;

import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.domain.entity.sipd.master.urusan.SIPDMasterUrusan;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.master.urusan.MasterUrusanEntity;
import com.rendyrobbani.latte.infra.persistence.entity.data.master.urusan.DataMasterUrusanEntity;
import com.rendyrobbani.latte.schema.specification.sipd.master.urusan.SIPDMasterUrusanTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = SIPDMasterUrusanTable.NAME)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SIPDMasterUrusanEntity extends MasterUrusanEntity implements SIPDMasterUrusan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private DataMasterUrusanEntity subject;

	public SIPDMasterUrusanEntity(LocalDateTime createdAt, NIP createdBy, DataMasterUrusanEntity subject) {
		super(createdAt, createdBy);
		this.subject = subject;
		this.isLocked = false;
	}

}