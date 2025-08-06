package com.rendyrobbani.common.util.regex;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegexUtil {

	public static List<String> matches(String value, String regex) {
		var matcher = Pattern.compile(regex).matcher(value);
		if (!matcher.matches()) return null;
		var results = new ArrayList<String>();
		for (int i = 1; i <= matcher.groupCount(); i++) results.add(matcher.group(i));
		return results;
	}

}