package ru.sapteh.daoiml;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.ClientService;

import java.util.List;

public class ClientServicedaoiml implements Dao<ClientService,Integer> {
    private SessionFactory factory;

    public ClientServicedaoiml(SessionFactory factory){
        this.factory=factory;
    }


    @Override
    public ClientService findById(Integer integer) {
        return null;
    }

    @Override
    public List<ClientService> findByAll() {
        try (Session session = factory.openSession()) {
            Query<ClientService> query= session.createQuery("FROM ClientService");
            return query.list();

        }
    }

    @Override
    public void create(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(clientService);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(ClientService clientService) {
        try (Session session =  factory.openSession()){
            session.beginTransaction();
            session.update(clientService);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(clientService);
            session.getTransaction().commit();
        }
    }
}
