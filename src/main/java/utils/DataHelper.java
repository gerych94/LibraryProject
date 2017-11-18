package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Vitaliy on 16.11.2017.
 */
public class DataHelper {

    private SessionFactory sessionFactory;
    private static DataHelper dataHelper;

    public DataHelper() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static DataHelper getDataHelper() {
        return dataHelper == null ? new DataHelper() : dataHelper;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
