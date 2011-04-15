package hibernate.factory;

import org.hibernate.SessionFactory;
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

    /**
     * Sets hibernate session factory on the dbclient instance
     * @param sessionFactory hibernate session factory object
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        databaseSession = sessionFactory;
    }

    /**
     * Gets a list of objects from the database based upon an HQL query
     * @param query HQL query to get a list of objects back from the database
     * @return a list of objects from the database
     */
    @Transactional
    public List getListOfObjects(String query) {
        return databaseSession.getCurrentSession().createQuery(query).list();
    }

    /**
     * Gets an object from the database based upon an HQL query
     * @param query HQL query
     * @return an object from the database
     */
    @Transactional
    public Object getObject(String query) {
        return databaseSession.getCurrentSession().createQuery(query).uniqueResult();
    }

    /**
     * Saves an object to the database
     * @param object object to save to the database
     */
    @Transactional
    public void saveObject(Object object) {
        databaseSession.getCurrentSession().saveOrUpdate(object);
    }

    /**
     * Removes and item from the database
     * @param object item to be removed from the database
     */
    @Transactional
    public void deleteObject(Object object) {
        databaseSession.getCurrentSession().delete(object);
    }
}
