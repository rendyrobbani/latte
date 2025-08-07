package com.rendyrobbani.latte.domain.entity.data.master.urusan;

import com.rendyrobbani.latte.domain.entity.base.master.urusan.ReferenceMasterBidang;

public interface ReferenceDataMasterBidang extends ReferenceMasterBidang {

	String getBidangId();

	@Override
	default String getBidangCode() {
		return this.getBidangId();
	}

}