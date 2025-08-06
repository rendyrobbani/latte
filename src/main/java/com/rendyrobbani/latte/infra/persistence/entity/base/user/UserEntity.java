package com.rendyrobbani.latte.infra.persistence.entity.base.user;

import com.rendyrobbani.latte.common.vo.Gender;
import com.rendyrobbani.latte.common.vo.NIP;
import com.rendyrobbani.latte.common.vo.Pangkat;
import com.rendyrobbani.latte.domain.base.user.User;
import com.rendyrobbani.latte.infra.persistence.converter.GenderConverter;
import com.rendyrobbani.latte.infra.persistence.converter.NIPConverter;
import com.rendyrobbani.latte.infra.persistence.converter.PangkatConverter;
import com.rendyrobbani.latte.infra.persistence.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class UserEntity extends BaseEntity implements User {

	@Convert(converter = PangkatConverter.class)
	@Column(name = "pangkat")
	protected Pangkat pangkat;

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

	@Column(name = "is_locked")
	protected boolean isLocked;

	@Column(name = "locked_at")
	protected LocalDateTime lockedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "locked_by")
	protected NIP lockedBy;

}