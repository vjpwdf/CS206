package hibernate.serviceadaptor;

import hibernate.dao.UserDAOImpl;
import hibernate.dao.UserDao;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceAdaptor {
    private static UserDao userDao = new UserDAOImpl();

    public static boolean loginWithCredentials(String username, String password) {
        return userDao.loginWithCredentials(username, password);
    }

    public static boolean userNameAlreadyExists(String userName) {
        return userDao.getUserByUserName(userName) != null;
    }

    public static void createUserAccount(String userName, String password) {
        userDao.createUserAccount(userName, password);
    }

    public static void setUserDao(UserDAOImpl userDao) {
        UserServiceAdaptor.userDao = userDao;
    }
}
