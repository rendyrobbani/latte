package com.rendyrobbani.latte.domain.entity.data.master.fungsi;

import com.rendyrobbani.latte.common.marker.HasAuditMutator;
import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLockMutator;
import com.rendyrobbani.latte.domain.entity.base.master.fungsi.MasterFungsi;

public interface DataMasterFungsi extends MasterFungsi, HasId<String>, HasLockMutator, HasAuditMutator {

	void setName(String name);

	@Override
	default String getCode() {
		return this.getId();
	}

}