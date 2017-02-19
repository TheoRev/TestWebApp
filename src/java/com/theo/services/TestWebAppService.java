package com.theo.services;

import com.theo.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class TestWebAppService<T> implements ITestWebApp<T> {

    private Session session;

    @Override
    public boolean Create(T t) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean Update(T t) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean Delete(T t) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<T> findAll(String t) throws Exception {
        List<T> lista = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("select t from " + t + " t");
            lista = query.list();
            session.getTransaction().commit();
            session.clear();
        } catch (HibernateException e) {
        }
        return lista;
    }

    @Override
    public T findBy(String q) throws Exception {
        T t = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(q);
            t = (T) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            throw e;
        }

        return t;
    }

    @Override
    public List<T> findByQuery(String q) throws Exception {
        List<T> lista = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(q);
            lista = query.list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("ERROR HIBERNATE: " + e.getMessage());
            throw e;
        }

        return lista;
    }

}
