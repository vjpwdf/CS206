package hibernate.dao;

import common.LoggedInUser;
import hibernate.User;
import hibernate.factory.DBClient;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 3:31 PM
 */
public class UserDAOImpl implements UserDao {
    /**
     * Logs the user into the system with a user name and password
     * @param userName user name string
     * @param password password string
     * @return true if the user name and password combination is valid
     */
    @Override
    public boolean loginWithCredentials(String userName, String password) {
        User user = getUserByUserName(userName);
        LoggedInUser.loggedInUser = user;
        return user != null && user.getUserPassword().equals(password);
    }

    /**
     * Gets a user from the database based upon a name
     * @param userName name of user object to get from the database
     * @return  the user object with the specified user name
     */
    @Override
    public User getUserByUserName(String userName) {
        return (User)DBClient.INSTANCE.getObject("from User where userName='" + userName + "'");
    }

    /**
     * Creates a user account
     * @param userName user name of the account to create
     * @param password password of the new account
     */
    @Override
    public void createUserAccount(String userName, String password) {
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setUserPassword(password);
        DBClient.INSTANCE.saveObject(newUser);
    }
}
