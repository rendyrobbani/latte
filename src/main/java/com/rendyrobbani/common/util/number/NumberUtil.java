package com.rendyrobbani.common.util.number;

import com.rendyrobbani.common.util.number.pad.NumberPadUtil;
import com.rendyrobbani.common.util.number.roman.RomanNumberUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NumberUtil {

	public static String lpadZero(Integer number, int length) {
		return NumberPadUtil.lpadZero(number, length);
	}

	public static String lpadZero(Long number, int length) {
		return NumberPadUtil.lpadZero(number, length);
	}

	public static String toRoman(Integer number) {
		return RomanNumberUtil.toRoman(number);
	}

	public static String toRoman(Long number) {
		return RomanNumberUtil.toRoman(number);
	}

	public static String toRoman(String number) {
		return RomanNumberUtil.toRoman(number);
	}

	public static int fromRoman(String roman) {
		return RomanNumberUtil.fromRoman(roman);
	}

}