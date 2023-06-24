package com.order.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class EnterPoint {
    HibernateUtil hibernateUtil = new HibernateUtil();
    public void createInDataBase(Object object) {
        try (Session session = hibernateUtil.buildSession();
             ){
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new HibernateException(e);
        }
    }

    public Object readFromDataBase(Object object, Integer id) {
        try (Session session = hibernateUtil.buildSession();
        ) {
            var newClass = object.getClass();
            session.beginTransaction();
            var n = session.get(newClass, id);
            System.out.println(n);
            session.getTransaction().commit();
            return n;
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public Object updateInDataBase(Object object){
        try(Session session = hibernateUtil.buildSession()){
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (HibernateException e){
            throw new HibernateException(e);
        }
        return object;
    }

    public void deleteInDataBase(Object object){
        try(Session session = hibernateUtil.buildSession()){
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (HibernateException e){
            throw new HibernateException(e);
        }
    }
    public List<Object> getAllObject(Object object){
        List objects = new ArrayList<>();
        try(Session session = hibernateUtil.buildSession()){
            session.beginTransaction();
            objects = session.createCriteria(object.getClass()).list();
            System.out.println(objects);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
        return objects;
    }


}