package hibernate.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: vincent
 * Date: 22-Feb-2011
 * Time: 1:26:32 PM
 */
public class DBClient {
    public static Session databaseSession = buildSessionFactoryFromApplicationContext();

    private static Session buildSessionFactoryFromApplicationContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"/hibernate/config.xml"});
        return ((SessionFactory)(applicationContext.getBean("sessionFactory"))).openSession();
    }

}
