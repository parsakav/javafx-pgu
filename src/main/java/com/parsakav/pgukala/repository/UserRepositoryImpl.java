package com.parsakav.pgukala.repository;

import com.parsakav.pgukala.entity.User;
import com.parsakav.pgukala.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public int save(User u) {
        Integer i=-1;
        try(Session se= HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = se.beginTransaction();
             i = (Integer) se.save(u);
            tx.commit();
        }
return i;

    }

    @Override
    public boolean exist(String username) {

if(username==null){
    return false;
}

        return find(username)!=null;

    }

    @Override
    public User find(String username) {
        User u=null;
        try(Session se= HibernateUtil.getSessionFactory().openSession()) {
            se.beginTransaction();
            Query<User> userQuery = se.createQuery("from User u where u.username= :uname", User.class);
            userQuery.setParameter("uname", username);
             u = userQuery.getResultList().stream().findFirst().orElse(null);
            se.getTransaction().commit();
        }
        return u;

    }

    @Override
    public void remove(String username) {
       try(Session se= HibernateUtil.getSessionFactory().openSession()) {
           se.beginTransaction();
           se.remove(find(username));
           se.getTransaction().commit();
       }

    }
}
