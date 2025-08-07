package com.rendyrobbani.latte.domain.entity.data.master.fungsi;

import com.rendyrobbani.latte.domain.entity.base.master.fungsi.ReferenceMasterFungsi;

public interface ReferenceDataMasterFungsi extends ReferenceMasterFungsi {

	String getFungsiId();

	@Override
	default String getFungsiCode() {
		return this.getFungsiId();
	}

}