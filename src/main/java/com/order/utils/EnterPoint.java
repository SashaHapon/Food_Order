package com.order.utils;
import com.order.model.Account;
import com.order.utils.HibernateUtil;
import org.hibernate.Session;

public class EnterPoint {

    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Account account = new Account();

        account.setAccountName("ad");
        account.setPhoneNumber("+10101010101010");

        session.save(account);
        session.getTransaction().commit();
    }

}