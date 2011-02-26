package hibernate.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: vincent
 * Date: 22-Feb-2011
 * Time: 1:26:32 PM
 */
public class DBClient {
    public static DBClient INSTANCE;
    public static SessionFactory databaseSession;

    public void setSessionFactory(SessionFactory sessionFactory) {
        databaseSession = sessionFactory;
    }

    @Transactional
    public List getListOfObjects(String query) {
        return databaseSession.getCurrentSession().createQuery(query).list();
    }

    @Transactional
    public List getListOfObjectsByClass(Class clazz) {
        return databaseSession.getCurrentSession().createCriteria(clazz).list();
    }

    @Transactional
    public Object getObject(String query) {
        return databaseSession.getCurrentSession().createQuery(query).uniqueResult();
    }
}
