package com.snaplync.dao;

import com.snaplync.util.ApplicationContextProvider;
import java.io.PrintStream;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class BaseDAO {
    static Logger logger = LoggerFactory.getLogger(BaseDAO.class);
    private static SessionFactory sessionFactory = BaseDAO.buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            ApplicationContext springContext = ApplicationContextProvider.getApplicationContext();
            SessionFactory sessionFactory = (SessionFactory)springContext.getBean("sessionFactory");
            return sessionFactory;
        }
        catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            logger.info("buildSessionFactory :: Exception ::", new Object[]{ex.getMessage(), ex});
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutdown() {
        this.getSessionFactory().close();
    }

    public Session openSession() throws Exception {
        try {
            return this.getSessionFactory().openSession();
        }
        catch (Exception e) {
            throw new Exception();
        }
    }

    public void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void rollBackTransaction(Session session) throws Exception {
        Transaction tx;
        if (session != null && (tx = session.getTransaction()) != null && tx.isActive() && tx.isParticipating()) {
            tx.rollback();
        }
    }

    public void saveObject(Object obj) throws Exception {
        Session session = this.openSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();
    }

    public void updateObject(Object obj) throws Exception {
        Session session = this.openSession();
        Transaction tx = session.beginTransaction();
        session.update(obj);
        tx.commit();
        session.close();
    }

    public void deleteObject(Object obj) throws Exception {
        Session session = this.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public Object getObject(Session session, Class className, Integer id) {
        return session.get(className, (Serializable)id);
    }

    public Object getObject(Session session, Class className, String id) {
        return session.get(className, (Serializable)((Object)id));
    }

    public List getDataAccToQuery(Session session, String query) throws Exception {
        Query qry = session.createQuery(query);
        List list = qry.list();
        return list;
    }

    public Iterator findAll(String query) throws Exception {
        Session session = this.openSession();
        Query qry = session.createQuery(query);
        List list = qry.list();
        Iterator iterator = list.iterator();
        return iterator;
    }

    public List getDataAccToQuery(String query) throws Exception {
        Session session = this.openSession();
        Query qry = session.createQuery(query);
        List list = qry.list();
        return list;
    }

    public static List getDataAccToQuery(Session session, String query, List<Object> parameters) throws Exception {
        Query qry = session.createQuery(query);
        if (parameters != null && parameters.size() > 0) {
            for (int i = 0; i < parameters.size(); ++i) {
                qry.setParameter(i, parameters.get(i));
            }
        }
        List list = qry.list();
        return list;
    }

    public static List getDataAccToQuery(Session session, Query query) {
        List list = query.list();
        return list;
    }

    public static long countRecords(Session session, Query query) {
        long records = 0;
        records = (Long)query.uniqueResult();
        return records;
    }

    public static Object getUniqueResult(Query query) {
        Object data = query.uniqueResult();
        return data;
    }

    public SessionFactory getSessionfactory() {
        return sessionFactory;
    }

    public static long getUTCTime(long timeInMillis) {
        DateTime localTime = new DateTime(timeInMillis, DateTimeZone.UTC);
        return localTime.getMillis();
    }
}
