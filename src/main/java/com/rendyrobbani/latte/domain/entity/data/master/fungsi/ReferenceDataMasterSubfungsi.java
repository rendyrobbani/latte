package com.rendyrobbani.latte.domain.entity.data.master.fungsi;

import com.rendyrobbani.latte.domain.entity.base.master.fungsi.ReferenceMasterSubfungsi;

public interface ReferenceDataMasterSubfungsi extends ReferenceMasterSubfungsi {

	String getSubfungsiId();

	@Override
	default String getSubfungsiCode() {
		return this.getSubfungsiId();
	}

}