package com.rendyrobbani.latte.common.vo;

import java.time.LocalDate;

public interface NIP {

	String REGEX = "^(19[0-9]{2}|20[0-9]{2})(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(19[0-9]{2}|20[0-9]{2})(0[1-9]|1[0-2]|21)([12])(00[1-9]|[0-9][1-9][0-9]|[1-9][0-9][0-9])$";

	String getValue();

	String getFormatted();

	LocalDate getBirthDate();

	LocalDate getStartDate();

	Gender getGender();

	Integer getNumber();

}