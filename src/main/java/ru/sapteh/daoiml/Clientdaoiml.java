package ru.sapteh.daoiml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.Client;

import java.util.List;

public class Clientdaoiml implements Dao<Client, Integer> {
    private SessionFactory factory;
    public Clientdaoiml(SessionFactory factory){
        this.factory = factory;
    }

    public Client findById(Integer integer) {
        return null;
    }

    public List<Client> findByAll() {
        try (Session session = factory.openSession()){
            Query<Client> clientQuery = session.createQuery("FROM Client");
            return clientQuery.list();
        }
    }

    public void create(Client client) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    public void update(Client client) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }

    }

    public void delete(Client client) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
    }
}
