package com.mvgrass.Server.Dao;

import com.mvgrass.Server.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Component
public class UsersDaoImpl implements IUsersDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PasswordEncoder encoder;

    @Bean
    SessionFactory SessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Override
    public User createUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        transaction.begin();
        session.save(user);
        try {
            transaction.commit();
        }catch (PersistenceException exc){
            exc.printStackTrace();
            throw exc;
        }

        session.close();

        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = sessionFactory.openSession();

        User user = session.get(User.class, login);

        session.close();

        return user;
    }

    @Override
    public User updateUser(String login, User user) {

        Session session = sessionFactory.openSession();

        User user1 = session.get(User.class, login);

        if(user1!=null) {
            user1.setName(user.getName());
            user1.setLogin(user.getLogin());
            user1.setEmail(user.getEmail());
            user1.setPassword(encoder.encode(user.getPassword()));

            Transaction transaction = session.getTransaction();

            transaction.begin();
            session.update(user1);
            try {
                transaction.commit();
            } catch (PersistenceException exc) {
                throw exc;
            }
        }

        session.close();

        return user1;
    }

    @Override
    public void delete(String login) {
        Session session = sessionFactory.openSession();

        User user = session.get(User.class, login);

        if(user!=null) {

            Transaction transaction = session.getTransaction();

            transaction.begin();
            session.delete(user);
            try {
                transaction.commit();
            } catch (PersistenceException exc) {
                throw exc;
            }
        }

        session.close();
    }

    @Override
    public List<User> findAllUsers() {
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM users");

        return query.getResultList();
    }
}
