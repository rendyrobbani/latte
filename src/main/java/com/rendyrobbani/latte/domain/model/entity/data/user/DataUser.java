package com.rendyrobbani.latte.domain.model.entity.data.user;

import com.rendyrobbani.latte.domain.model.entity.base.user.User;
import com.rendyrobbani.latte.domain.model.marker.audit.Auditable;
import com.rendyrobbani.latte.domain.model.marker.audit.Lockable;
import com.rendyrobbani.latte.domain.model.marker.has.HasId;

public interface DataUser extends HasId<String>, User, Lockable, Auditable {

}