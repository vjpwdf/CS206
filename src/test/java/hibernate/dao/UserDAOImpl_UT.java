package hibernate.dao;

import common.LoggedInUser;
import hibernate.User;
import hibernate.factory.DBClient;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 3/13/11
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl_UT extends DaoTest {
    private UserDao userDao;

    @Before
    public void setUp() {
        userDao = new UserDAOImpl();
        testSessionFactoryIsNotNull();
    }

    @Test
    public void testAddUser() {
        userDao.createUserAccount("Test", "0123456");
        User user = new User();
        user.setUserName("Test");
        user.setUserPassword("0123456");
        List<User> userList = DBClient.INSTANCE.getListOfObjects("from User");
        assertNotNull(userList);
        assertTrue(userList.size() > 0);
        assertTrue(userList.contains(user));
    }

    @Test
    public void testGetUserByUserName() {
        User user = addUser("Test", "0123456");
        User dbUser = (User) DBClient.INSTANCE.getObject("from User user where user.userName = " + "'" + user.getUserName() + "'");
        assertNotNull(dbUser);
        assertTrue(dbUser.equals(dbUser));
    }

    @Test
    public void testUserLoginWithCredentials() {
        User user = addUser("Test", "0123456");
        assertTrue(userDao.loginWithCredentials(user.getUserName(), user.getUserPassword()));
        assertTrue(LoggedInUser.loggedInUser.equals(user));
        assertFalse(userDao.loginWithCredentials(user.getUserName(), "fakePassword"));
        assertFalse(userDao.loginWithCredentials("fakeUser", "fakePassword"));
    }
}
