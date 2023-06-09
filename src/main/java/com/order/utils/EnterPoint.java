package com.order.utils;

import com.order.model.Account;
import org.hibernate.Session;

public class EnterPoint {

    public void enter() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Account account = new Account();
        account.setId(39932l);
        account.setAccountName("ad");
        account.setPhoneNumber("+10101010101010");

        session.save(account);
        session.getTransaction().commit();
    }

}