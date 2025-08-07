package com.rendyrobbani.latte.domain.entity.data.master.program;

import com.rendyrobbani.latte.common.marker.HasAuditMutator;
import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLockMutator;
import com.rendyrobbani.latte.domain.entity.base.master.program.MasterProgram;
import com.rendyrobbani.latte.domain.entity.data.master.urusan.ReferenceDataMasterBidang;

public interface DataMasterProgram extends MasterProgram, HasId<String>, HasLockMutator, HasAuditMutator, ReferenceDataMasterBidang {

	void setName(String name);

	@Override
	default String getCode() {
		return this.getId();
	}

}