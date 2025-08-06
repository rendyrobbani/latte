package com.rendyrobbani.latte.common.marker;

import com.rendyrobbani.latte.common.vo.Gender;
import com.rendyrobbani.latte.common.vo.NIP;

import java.time.LocalDate;

public interface HasNIP {

	NIP getNIP();

	default LocalDate getBirthDate() {
		if (this.getNIP() == null) return null;
		return this.getNIP().getBirthDate();
	}

	default LocalDate getStartDate() {
		if (this.getNIP() == null) return null;
		return this.getNIP().getStartDate();
	}

	default Gender getGender() {
		if (this.getNIP() == null) return null;
		return this.getNIP().getGender();
	}

	default Integer getNumber() {
		if (this.getNIP() == null) return null;
		return this.getNIP().getNumber();
	}

}