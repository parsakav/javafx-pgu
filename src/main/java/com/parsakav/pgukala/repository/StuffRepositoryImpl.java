package com.parsakav.pgukala.repository;

import com.parsakav.pgukala.entity.Stuff;
import com.parsakav.pgukala.entity.User;
import com.parsakav.pgukala.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StuffRepositoryImpl implements StuffRepository {
    @Override
    public List<Stuff> getAllStuff() {
        List<Stuff> list=null;

        try(Session se= HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = se.beginTransaction();
list=se.createQuery("from Stuff ",Stuff.class).getResultList();
            tx.commit();
        }
        return list;
    }

    @Override
    public int save(Stuff user) {
        Integer i=-1;
        try(Session se= HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = se.beginTransaction();
            i = (Integer) se.save(user);

            tx.commit();
        }
        return i;
    }

    @Override
    public void remove(int id) {
        Stuff u = new Stuff();
        u.setId(id);
        try(Session se= HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = se.beginTransaction();
           se.remove(u);
            tx.commit();
        }



    }
}
