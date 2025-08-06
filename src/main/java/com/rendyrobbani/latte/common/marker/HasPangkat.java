package com.rendyrobbani.latte.common.marker;

import com.rendyrobbani.latte.common.vo.Pangkat;

public interface HasPangkat {

	Pangkat getPangkat();

	default String getPangkatValue() {
		if (this.getPangkat() == null) return null;
		return this.getPangkat().getValue();
	}

	default String getPangkatTitle() {
		if (this.getPangkat() == null) return null;
		return this.getPangkat().getTitle();
	}

	default boolean isPNS() {
		if (this.getPangkat() == null) return false;
		return this.getPangkat().isPNS();
	}

	default boolean isP3K() {
		if (this.getPangkat() == null) return false;
		return this.getPangkat().isP3K();
	}

}