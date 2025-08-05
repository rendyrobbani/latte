package com.rendyrobbani.latte.domain.model.entity.logs.user;

import com.rendyrobbani.latte.domain.model.entity.base.user.User;
import com.rendyrobbani.latte.domain.model.marker.audit.Loggable;
import com.rendyrobbani.latte.domain.model.marker.has.HasId;

public interface LogsUser extends HasId<Long>, User, Loggable {

}