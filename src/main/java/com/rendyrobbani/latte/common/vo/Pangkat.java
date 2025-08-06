package com.rendyrobbani.latte.common.vo;

import com.rendyrobbani.latte.common.util.number.NumberUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Pangkat {
	PNS_1A("1A", "Juru Muda"),
	PNS_1B("1B", "Juru Muda Tingkat I"),
	PNS_1C("1C", "Juru"),
	PNS_1D("1D", "Juru Tingkat I"),
	PNS_2A("2A", "Pengatur Muda"),
	PNS_2B("2B", "Pengatur Muda Tingkat I"),
	PNS_2C("2C", "Pengatur"),
	PNS_2D("2D", "Pengatur Tingkat I"),
	PNS_3A("3A", "Penata Muda"),
	PNS_3B("3B", "Penata Muda Tingkat I"),
	PNS_3C("3C", "Penata"),
	PNS_3D("3D", "Penata Tingkat I"),
	PNS_4A("4A", "Pembina"),
	PNS_4B("4B", "Pembina Tingkat I"),
	PNS_4C("4C", "Pembina Utama Muda"),
	PNS_4D("4D", "Pembina Utama Madya"),
	PNS_4E("4E", "Pembina Utama"),
	P3K_01("01", "Golongan I"),
	P3K_02("02", "Golongan II"),
	P3K_03("03", "Golongan III"),
	P3K_04("04", "Golongan IV"),
	P3K_05("05", "Golongan V"),
	P3K_06("06", "Golongan VI"),
	P3K_07("07", "Golongan VII"),
	P3K_08("08", "Golongan VIII"),
	P3K_09("09", "Golongan IX"),
	P3K_10("10", "Golongan X"),
	P3K_11("11", "Golongan XI"),
	P3K_12("12", "Golongan XII"),
	P3K_13("13", "Golongan XIII"),
	P3K_14("14", "Golongan XIV"),
	P3K_15("15", "Golongan XV"),
	P3K_16("16", "Golongan XVI"),
	P3K_17("17", "Golongan XVII");

	private final String value;

	private final String label;

	public static final String REGEX_PNS = "[1-4][A-D]|4E";

	public static final String REGEX_P3K = "0[1-9]|1[0-7]";

	private static final String DEFAULT_SEPARATOR = "/";

	public boolean isPNS() {
		return this.value.matches(REGEX_PNS);
	}

	public boolean isP3K() {
		return this.value.matches(REGEX_P3K);
	}

	private String getRoman(String separator) {
		if (this.isP3K()) return "";
		separator = separator != null ? separator : DEFAULT_SEPARATOR;
		return " (" + NumberUtil.toRoman(this.getValue().substring(0, 1)) + separator + this.getValue().substring(1).toLowerCase() + ")";
	}

	public String getTitle(String separator) {
		return this.getLabel() + this.getRoman(separator);
	}

	public String getTitle() {
		return this.getTitle(null);
	}

	public static Pangkat fromValue(String value) {
		if (value != null) for (var e : values()) if (e.getValue().equals(value)) return e;
		return null;
	}
}