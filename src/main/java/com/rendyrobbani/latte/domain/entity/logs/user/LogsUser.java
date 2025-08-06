package com.rendyrobbani.latte.domain.entity.logs.user;

import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLoggable;
import com.rendyrobbani.latte.common.marker.HasSubject;
import com.rendyrobbani.latte.domain.entity.base.user.User;
import com.rendyrobbani.latte.domain.entity.data.user.DataUser;

public interface LogsUser extends User, HasId<Long>, HasSubject<DataUser>, HasLoggable {

}