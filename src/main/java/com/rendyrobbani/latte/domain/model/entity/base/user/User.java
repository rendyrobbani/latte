package com.rendyrobbani.latte.domain.model.entity.base.user;

import com.rendyrobbani.latte.domain.meta.Gender;
import com.rendyrobbani.latte.domain.meta.PangkatASN;
import com.rendyrobbani.latte.domain.model.marker.audit.Auditable;
import com.rendyrobbani.latte.domain.model.marker.audit.Lockable;
import com.rendyrobbani.latte.domain.model.marker.has.HasNameAndTitle;
import com.rendyrobbani.latte.domain.model.valueobject.NIP;

import java.time.LocalDate;

public interface User extends HasNameAndTitle, Lockable, Auditable {

	NIP getNIP();

	PangkatASN getPangkat();

	LocalDate getBirthDate();

	LocalDate getStartDate();

	String getPassword();

	Gender getGender();

	Integer getNumber();

	boolean isPNS();

	boolean isP3K();

}