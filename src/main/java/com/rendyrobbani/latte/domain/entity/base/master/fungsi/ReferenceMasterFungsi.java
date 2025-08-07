package com.rendyrobbani.latte.domain.entity.base.master.fungsi;

public interface ReferenceMasterFungsi {

	MasterFungsi getFungsi();

	default String getFungsiCode() {
		if (this.getFungsi() == null) return null;
		return this.getFungsi().getCode();
	}

	default String getFungsiName() {
		if (this.getFungsi() == null) return null;
		return this.getFungsi().getName();
	}

	default String getFungsiName(boolean uppercase) {
		if (this.getFungsi() == null) return null;
		return this.getFungsi().getName();
	}

}