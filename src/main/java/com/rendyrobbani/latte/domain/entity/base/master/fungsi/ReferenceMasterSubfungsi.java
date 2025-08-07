package com.rendyrobbani.latte.domain.entity.base.master.fungsi;

public interface ReferenceMasterSubfungsi {

	MasterSubfungsi getSubfungsi();

	default String getSubfungsiCode() {
		if (this.getSubfungsi() == null) return null;
		return this.getSubfungsi().getCode();
	}

	default String getSubfungsiName() {
		if (this.getSubfungsi() == null) return null;
		return this.getSubfungsi().getName();
	}

	default String getSubfungsiName(boolean uppercase) {
		if (this.getSubfungsi() == null) return null;
		return this.getSubfungsi().getName();
	}

}