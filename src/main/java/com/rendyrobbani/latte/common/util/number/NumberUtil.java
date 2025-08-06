package com.rendyrobbani.latte.common.util.number;

import com.rendyrobbani.latte.common.util.number.roman.RomanNumberUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NumberUtil {

	public static String toRoman(int number) {
		return RomanNumberUtil.toRoman(number);
	}

	public static String toRoman(String number) {
		return RomanNumberUtil.toRoman(number);
	}

	public static int fromRoman(String roman) {
		return RomanNumberUtil.fromRoman(roman);
	}

}