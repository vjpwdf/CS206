package hibernate.dao;

import common.LoggedInUser;
import hibernate.User;
import hibernate.factory.DBClient;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl implements UserDao{

    public boolean loginWithCredentials(String userName, String password) {
        User user = getUserByUserName(userName);
        LoggedInUser.loggedInUser = user;
        return user != null && user.getUserPassword().equals(password);
    }

    public User getUserByUserName(String userName) {
        return (User)DBClient.INSTANCE.getObject("from User where userName='" + userName + "'");
    }

    public void addUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(password);
        user.setUserId(0);
        DBClient.INSTANCE.saveObject(user);
    }
}
