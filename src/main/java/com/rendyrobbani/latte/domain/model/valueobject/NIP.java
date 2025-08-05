package com.rendyrobbani.latte.domain.model.valueobject;

import com.rendyrobbani.latte.domain.meta.Gender;

import java.time.LocalDate;

public interface NIP {

	String REGEX = "^(19\\d{2}|20\\d{2})(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(19\\d{2}|20\\d{2})(0[1-9]|1[0-2])([12])((?!0{3}$)\\d{3})$";

	String getValue();

	String getFormattedValue();

	LocalDate getBirthDate();

	LocalDate getStartDate();

	Gender getGender();

	Integer getNumber();

}