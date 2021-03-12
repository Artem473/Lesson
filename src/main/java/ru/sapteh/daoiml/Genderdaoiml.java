package ru.sapteh.daoiml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.Gender;

import java.util.List;

public class Genderdaoiml implements Dao<Gender, Integer> {
    private SessionFactory factory;
    public Genderdaoiml(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Gender findById(Integer code) {
        try (Session session = factory.openSession()){
        Gender entity = session.get(Gender.class, code);
        return entity;
    }
    }


    @Override
    public List<Gender> findByAll() {
        return null;
    }

    @Override
    public void create(Gender gender) {

    }

    @Override
    public void update(Gender gender) {

    }

    @Override
    public void delete(Gender gender) {

    }
}
