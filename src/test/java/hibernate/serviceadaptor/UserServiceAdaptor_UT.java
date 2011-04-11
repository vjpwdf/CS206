package hibernate.serviceadaptor;

import hibernate.dao.UserDAOImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/7/11
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceAdaptor_UT {
    @Mock
    private UserDAOImpl userDao;

    @Before
    public void setup() {
        initMocks(this);
        UserServiceAdaptor userServiceAdaptor = new UserServiceAdaptor();
        assertNotNull(userServiceAdaptor);
        UserServiceAdaptor.setUserDao(userDao);
    }

    @Test
    public void testLoginWithCredentials() throws Exception {
        UserServiceAdaptor.loginWithCredentials("test", "0123456");
        verify(userDao).loginWithCredentials("test", "0123456");
    }

    @Test
    public void testUserNameAlreadyExists() throws Exception {
        UserServiceAdaptor.userNameAlreadyExists("test");
        verify(userDao).getUserByUserName("test");
    }

    @Test
    public void testCreateUserAccount() throws Exception {
        UserServiceAdaptor.createUserAccount("test", "0123456");
        verify(userDao).createUserAccount("test", "0123456");
    }
}
