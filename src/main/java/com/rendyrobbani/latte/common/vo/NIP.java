package com.rendyrobbani.latte.common.vo;

import java.time.LocalDate;

public interface NIP {

	String REGEX = "^(19\\d{2}|20\\d{2})(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(19\\d{2}|20\\d{2})(0[1-9]|1[0-2])([12])((?!0{3}$)\\d{3})$";

	String getValue();

	String getFormatted();

	LocalDate getBirthDate();

	LocalDate getStartDate();

	Gender getGender();

	Integer getNumber();

}