package ru.sapteh.daoiml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.Service;

import java.util.List;

public class Servicedaoiml implements Dao<Service,Integer> {
    private SessionFactory factory;

    public Servicedaoiml(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Service findById(Integer integer) {
        return null;
    }

    @Override
    public List<Service> findByAll() {
        try (Session session = factory.openSession()) {
            Query<Service> query = session.createQuery("FROM Service");
            return query.list();
        }
    }

    @Override
    public void create(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(service);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(service);
            session.getTransaction().commit();
        }


    }

    @Override
    public void delete(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(service);
            session.getTransaction().commit();
        }
    }
}
