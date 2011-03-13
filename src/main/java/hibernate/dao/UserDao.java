package hibernate.dao;

import hibernate.User;
import hibernate.factory.DBClient;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    boolean loginWithCredentials(String userName, String password);
    User getUserByUserName(String userName);
    public void addUser(String userName, String password);
}
