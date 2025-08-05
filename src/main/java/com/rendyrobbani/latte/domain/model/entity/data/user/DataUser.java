package com.rendyrobbani.latte.domain.model.entity.data.user;

import com.rendyrobbani.latte.domain.model.entity.base.user.User;
import com.rendyrobbani.latte.domain.model.marker.audit.AuditMutator;
import com.rendyrobbani.latte.domain.model.marker.audit.LockMutator;
import com.rendyrobbani.latte.domain.model.marker.has.HasId;

public interface DataUser extends HasId<String>, User, LockMutator, AuditMutator {

}