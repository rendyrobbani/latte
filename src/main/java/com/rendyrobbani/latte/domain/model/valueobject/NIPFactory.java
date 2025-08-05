package com.rendyrobbani.latte.domain.model.valueobject;

import com.rendyrobbani.latte.domain.meta.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NIPFactory {

	@Getter
	@SuppressWarnings("ClassCanBeRecord")
	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	private static final class NIPImpl implements NIP {

		private final String value;

		private final String formattedValue;

		private final LocalDate birthDate;

		private final LocalDate startDate;

		private final Gender gender;

		private final Integer number;

	}

	public static NIP parse(String value) {
		if (value == null) throw new IllegalArgumentException("value cannot be null");

		if (!value.matches(NIP.REGEX)) throw new IllegalArgumentException("invalid value");

		var valueOfBirthDate = value.substring(getMapOfBirthDate()[0], getMapOfBirthDate()[1]);
		var valueOfStartDate = value.substring(getMapOfStartDate()[0], getMapOfStartDate()[1]);
		var valueOfGender = value.substring(getMapOfGender()[0], getMapOfGender()[1]);
		var valueOfNumber = value.substring(getMapOfNumber()[0], getMapOfNumber()[1]);

		return new NIPImpl(
				value,
				String.join(" ", valueOfBirthDate, valueOfStartDate, valueOfGender, valueOfNumber),
				LocalDate.parse(valueOfBirthDate, getFormatter()),
				valueOfStartDate.endsWith("21") ? null : LocalDate.parse(valueOfStartDate + "01", getFormatter()),
				Gender.fromValue(valueOfGender),
				Integer.valueOf(valueOfNumber)
		);
	}

	private static DateTimeFormatter formatter;

	private static DateTimeFormatter getFormatter() {
		if (formatter == null) formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return formatter;
	}

	private static int[] mapOfBirthDate;

	private static int[] getMapOfBirthDate() {
		if (mapOfBirthDate == null) mapOfBirthDate = new int[]{0, 8};
		return mapOfBirthDate;
	}

	private static int[] mapOfStartDate;

	private static int[] getMapOfStartDate() {
		if (mapOfStartDate == null) mapOfStartDate = new int[]{8, 14};
		return mapOfStartDate;
	}

	private static int[] mapOfGender;

	private static int[] getMapOfGender() {
		if (mapOfGender == null) mapOfGender = new int[]{14, 15};
		return mapOfGender;
	}

	private static int[] mapOfNumber;

	private static int[] getMapOfNumber() {
		if (mapOfNumber == null) mapOfNumber = new int[]{15, 18};
		return mapOfNumber;
	}

}