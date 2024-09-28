package org.geogenius.utils.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionManager {
    private static Session sessionInstance;

    private SessionManager() {
    }

    public static Session getSession() {
        synchronized (SessionManager.class) {
            if (sessionInstance == null) {
                sessionInstance = HibernateUtils.getSessionFactory().openSession();
                return sessionInstance;
            }
            return sessionInstance;
        }
    }
}
