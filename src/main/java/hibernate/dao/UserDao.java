package hibernate.dao;

import hibernate.User;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:05 PM
 */
public interface UserDao {
    /**
     * Logs the user into the system with a user name and password
     * @param userName user name string
     * @param password password string
     * @return true if the user name and password combination is valid
     */
    boolean loginWithCredentials(String userName, String password);

    /**
     * Gets a user from the database based upon a name
     * @param userName name of user object to get from the database
     * @return  the user object with the specified user name
     */
    User getUserByUserName(String userName);

    /**
     * Creates a user account
     * @param userName user name of the account to create
     * @param password password of the new account
     */
    void createUserAccount(String userName, String password);
}
