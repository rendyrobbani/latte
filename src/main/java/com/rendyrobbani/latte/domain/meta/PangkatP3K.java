package com.rendyrobbani.latte.domain.meta;

import lombok.Getter;

@Getter
public enum PangkatP3K implements PangkatASN {
	GOLONGAN_01("01", "Golongan I"),
	GOLONGAN_02("02", "Golongan II"),
	GOLONGAN_03("03", "Golongan III"),
	GOLONGAN_04("04", "Golongan IV"),
	GOLONGAN_05("05", "Golongan V"),
	GOLONGAN_06("06", "Golongan VI"),
	GOLONGAN_07("07", "Golongan VII"),
	GOLONGAN_08("08", "Golongan VIII"),
	GOLONGAN_09("09", "Golongan IX"),
	GOLONGAN_10("10", "Golongan X"),
	GOLONGAN_11("11", "Golongan XI"),
	GOLONGAN_12("12", "Golongan XII"),
	GOLONGAN_13("13", "Golongan XIII"),
	GOLONGAN_14("14", "Golongan XIV"),
	GOLONGAN_15("15", "Golongan XV"),
	GOLONGAN_16("16", "Golongan XVI"),
	GOLONGAN_17("17", "Golongan XVII");

	public static final String REGEX = "0[1-9]|1[0-7]";

	private final String value;

	private final String label;

	private final String title;

	private final boolean isPNS;

	private final boolean isP3K;

	PangkatP3K(String value, String label) {
		this.value = value;
		this.label = label;
		this.title = label;
		this.isPNS = false;
		this.isP3K = true;
	}

	public static PangkatP3K fromValue(String value) {
		if (value != null) for (var e : values()) if (e.value.equals(value)) return e;
		return null;
	}
}