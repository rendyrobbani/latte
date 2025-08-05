package com.rendyrobbani.latte.domain.model.valueobject;

import com.rendyrobbani.latte.domain.meta.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NIPFactory {

	@Getter
	@SuppressWarnings("ClassCanBeRecord")
	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	private static final class NIPImpl implements NIP {

		private final String value;

		private final LocalDate birthDate;

		private final LocalDate startDate;

		private final Gender gender;

		private final Integer number;

	}

	public static NIP create(String value) {
		if (value == null) throw new IllegalArgumentException("value cannot be null");

		var matcher = Pattern.compile(NIP.REGEX).matcher(value);
		if (!matcher.matches()) throw new IllegalArgumentException("invalid value");

		return new NIPImpl(
				value,
				parseBirthDate(value),
				parseStartDate(value),
				parseGender(value),
				parseNumber(value)
		);
	}

	private static DateTimeFormatter formatter;

	private static DateTimeFormatter getFormatter() {
		if (formatter == null) formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return formatter;
	}

	private static LocalDate parseBirthDate(String value) {
		return LocalDate.parse(value.substring(0, 8), getFormatter());
	}

	private static LocalDate parseStartDate(String value) {
		if (value.substring(8, 14).endsWith("21")) return null;
		return LocalDate.parse(value.substring(8, 14) + "01", getFormatter());
	}

	private static Gender parseGender(String value) {
		return Gender.fromValue(value.substring(14, 15));
	}

	private static Integer parseNumber(String value) {
		return Integer.parseInt(value.substring(15, 18));
	}

}