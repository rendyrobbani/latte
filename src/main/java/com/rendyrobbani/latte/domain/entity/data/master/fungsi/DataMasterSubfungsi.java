package com.rendyrobbani.latte.domain.entity.data.master.fungsi;

import com.rendyrobbani.latte.common.marker.HasAuditMutator;
import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLockMutator;
import com.rendyrobbani.latte.domain.entity.base.master.fungsi.MasterSubfungsi;

public interface DataMasterSubfungsi extends MasterSubfungsi, HasId<String>, HasLockMutator, HasAuditMutator, ReferenceDataMasterFungsi {

	void setName(String name);

	@Override
	default String getCode() {
		return this.getId();
	}

}