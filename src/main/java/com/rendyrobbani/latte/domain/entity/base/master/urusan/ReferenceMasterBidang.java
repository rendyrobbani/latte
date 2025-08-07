package com.rendyrobbani.latte.domain.entity.base.master.urusan;

public interface ReferenceMasterBidang {

	MasterBidang getBidang();

	default String getBidangCode() {
		if (this.getBidang() == null) return null;
		return this.getBidang().getCode();
	}

	default String getBidangName() {
		if (this.getBidang() == null) return null;
		return this.getBidang().getName();
	}

	default String getBidangName(boolean uppercase) {
		if (this.getBidang() == null) return null;
		return this.getBidang().getName();
	}

}