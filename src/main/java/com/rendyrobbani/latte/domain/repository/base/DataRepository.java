package com.rendyrobbani.latte.domain.repository.base;

import java.util.List;
import java.util.Optional;

public interface DataRepository<Entity, ID> {

	List<Entity> selectAll();

	Optional<Entity> selectById(ID id);

	Entity save(Entity entity);

	Entity updateById(ID id, Entity entity);

	void deleteById(ID id);

}