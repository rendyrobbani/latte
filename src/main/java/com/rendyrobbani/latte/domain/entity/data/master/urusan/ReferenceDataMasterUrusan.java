package com.rendyrobbani.latte.domain.entity.data.master.urusan;

import com.rendyrobbani.latte.domain.entity.base.master.urusan.ReferenceMasterUrusan;

public interface ReferenceDataMasterUrusan extends ReferenceMasterUrusan {

	String getUrusanId();

	@Override
	default String getUrusanCode() {
		return this.getUrusanId();
	}

}