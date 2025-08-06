package com.rendyrobbani.latte.infra.persistence.repository.base;

import com.rendyrobbani.latte.domain.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public abstract class BaseRepositoryImpl<ID, DOMAIN, ENTITY> implements BaseRepository<ID, DOMAIN> {

	protected abstract JpaRepository<ENTITY, ID> getJpaRepository();

	@Override
	public List<DOMAIN> findAll() {
		var domains = new ArrayList<DOMAIN>();
		for (var entity : getJpaRepository().findAll()) domains.add((DOMAIN) entity);
		return domains;
	}

	@Override
	public Optional<DOMAIN> findById(ID id) {
		var entity = getJpaRepository().findById(id).orElse(null);
		return entity != null ? Optional.of((DOMAIN) entity) : Optional.empty();
	}

	@Override
	public DOMAIN save(DOMAIN domain) {
		return (DOMAIN) getJpaRepository().save((ENTITY) domain);
	}

}