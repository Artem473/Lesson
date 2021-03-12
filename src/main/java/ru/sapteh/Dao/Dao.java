package ru.sapteh.Dao;

import java.util.List;

public interface Dao<Entity,Key>{
    Entity findById(Key key);
    List<Entity> findByAll();
    void create(Entity entity);
    void update(Entity entity);
    void delete(Entity entity);
}
