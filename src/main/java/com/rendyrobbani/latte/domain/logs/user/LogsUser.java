package com.rendyrobbani.latte.domain.logs.user;

import com.rendyrobbani.latte.common.marker.HasId;
import com.rendyrobbani.latte.common.marker.HasLoggable;
import com.rendyrobbani.latte.domain.base.user.User;

public interface LogsUser extends User, HasId<Long>, HasLoggable {

}