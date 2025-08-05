package com.rendyrobbani.latte.common.util.text;

import com.rendyrobbani.latte.common.util.text.cases.TextCaseUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TextUtil {

	public static String toTitleCase(String text, Map<String, String> replaceBefore, Map<String, String> replaceAfter) {
		return TextCaseUtil.toTitleCase(text, replaceBefore, replaceAfter);
	}

	public static String toTitleCase(String text, Map<String, String> replaceBefore) {
		return TextCaseUtil.toTitleCase(text, replaceBefore, null);
	}

	public static String toTitleCase(String text) {
		return TextCaseUtil.toTitleCase(text, null, null);
	}

	public static String toCamelCase(String text, Map<String, String> replaceBefore, Map<String, String> replaceAfter) {
		return TextCaseUtil.toCamelCase(text, replaceBefore, replaceAfter);
	}

	public static String toCamelCase(String text, Map<String, String> replaceBefore) {
		return TextCaseUtil.toCamelCase(text, replaceBefore, null);
	}

	public static String toCamelCase(String text) {
		return TextCaseUtil.toCamelCase(text, null, null);
	}

}