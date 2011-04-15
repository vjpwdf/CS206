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

    /**
     * Logs the user into the system with a user name and password
     * @param username user name string
     * @param password password string
     * @return true if the user name and password combination is valid
     */
    public static boolean loginWithCredentials(String username, String password) {
        return userDao.loginWithCredentials(username, password);
    }

    /**
     * Checks to see if the user name already exists in the database
     * @param userName user name ot check to see if it exists in the database
     * @return true if the user name already exists
     */
    public static boolean userNameAlreadyExists(String userName) {
        return userDao.getUserByUserName(userName) != null;
    }

    /**
     * Creates a user account
     * @param userName user name of the account to create
     * @param password password of the new account
     */
    public static void createUserAccount(String userName, String password) {
        userDao.createUserAccount(userName, password);
    }

    /**
     * Sets the static user dao on the user service adaptor for static usage
     * @param userDao user dao to set
     */
    public static void setUserDao(UserDAOImpl userDao) {
        UserServiceAdaptor.userDao = userDao;
    }
}
