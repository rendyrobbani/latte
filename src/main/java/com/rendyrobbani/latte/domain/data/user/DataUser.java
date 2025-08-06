package com.rendyrobbani.latte.domain.data.user;

import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLockMutator;
import com.rendyrobbani.latte.common.vo.Pangkat;
import com.rendyrobbani.latte.domain.base.user.User;

import java.time.LocalDate;

public interface DataUser extends User, HasId<String>, HasLockMutator {

	void setPangkat(Pangkat pangkat);

	void setName(String name);

	void setTitlePrefix(String titlePrefix);

	void setTitleSuffix(String titleSuffix);

	void setStartDate(LocalDate startDate);

	void setPassword(String password);

}