package hibernate.dao;

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
    @Override
    public boolean loginWithCredentials(String userName, String password) {
        User user = getUserByUserName(userName);
        return user != null && user.getUserPassword().equals(password);
    }

    @Override
    public User getUserByUserName(String userName) {
        return (User)DBClient.INSTANCE.getObject("from User where userName='" + userName + "'");
    }
}
