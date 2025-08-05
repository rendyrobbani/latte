package com.rendyrobbani.latte.adapter.out.persistence.mapped.base.user;

import com.rendyrobbani.latte.adapter.out.persistence.converter.GenderConverter;
import com.rendyrobbani.latte.adapter.out.persistence.converter.PangkatASNConverter;
import com.rendyrobbani.latte.adapter.out.persistence.mapped.base.AbstractLockableEntity;
import com.rendyrobbani.latte.domain.meta.Gender;
import com.rendyrobbani.latte.domain.meta.PangkatASN;
import com.rendyrobbani.latte.domain.model.entity.base.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractUserEntity extends AbstractLockableEntity implements User {

	@Convert(converter = PangkatASNConverter.class)
	@Column(name = "pangkat")
	protected PangkatASN pangkat;

	@Setter
	@Column(name = "name")
	protected String name;

	@Setter
	@Column(name = "title_prefix")
	protected String titlePrefix;

	@Setter
	@Column(name = "title_suffix")
	protected String titleSuffix;

	@Setter
	@Column(name = "password")
	protected String password;

	@Column(name = "birth_date")
	protected LocalDate birthDate;

	@Column(name = "start_date")
	protected LocalDate startDate;

	@Convert(converter = GenderConverter.class)
	@Column(name = "gender")
	protected Gender gender;

	@Column(name = "number")
	protected Integer number;

	@Column(name = "is_pns")
	protected boolean isPNS;

	@Column(name = "is_p3k")
	protected boolean isP3K;

}