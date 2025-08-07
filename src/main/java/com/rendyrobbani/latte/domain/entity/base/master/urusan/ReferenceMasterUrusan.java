package com.rendyrobbani.latte.domain.entity.base.master.urusan;

public interface ReferenceMasterUrusan {

	MasterUrusan getUrusan();

	default String getUrusanCode() {
		if (this.getUrusan() == null) return null;
		return this.getUrusan().getCode();
	}

	default String getUrusanName() {
		if (this.getUrusan() == null) return null;
		return this.getUrusan().getName();
	}

	default String getUrusanName(boolean uppercase) {
		if (this.getUrusan() == null) return null;
		return this.getUrusan().getName();
	}

}