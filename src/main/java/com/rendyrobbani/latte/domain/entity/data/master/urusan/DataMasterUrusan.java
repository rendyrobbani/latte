package com.rendyrobbani.latte.domain.entity.data.master.urusan;

import com.rendyrobbani.latte.common.marker.HasAuditMutator;
import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLockMutator;
import com.rendyrobbani.latte.domain.entity.base.master.urusan.MasterUrusan;

public interface DataMasterUrusan extends MasterUrusan, HasId<String>, HasLockMutator, HasAuditMutator {

	void setName(String name);

	@Override
	default String getCode() {
		return this.getId();
	}

}