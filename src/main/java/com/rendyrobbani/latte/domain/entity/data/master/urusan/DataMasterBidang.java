package com.rendyrobbani.latte.domain.entity.data.master.urusan;

import com.rendyrobbani.latte.common.marker.HasAuditMutator;
import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLockMutator;
import com.rendyrobbani.latte.domain.entity.base.master.urusan.MasterBidang;

public interface DataMasterBidang extends MasterBidang, HasId<String>, HasLockMutator, HasAuditMutator, ReferenceDataMasterUrusan {

	void setName(String name);

	@Override
	default String getCode() {
		return this.getId();
	}

}