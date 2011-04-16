package gui.window.login;

import common.LoggedInUser;
import gui.window.WindowTest;
import hibernate.User;
import hibernate.dao.UserDAOImpl;
import hibernate.serviceadaptor.UserServiceAdaptor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import utility.TestUtils;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/13/11
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginWindow_UT extends WindowTest {
    private LoginWindow loginWindow;
    private final int WIDTH = 500;
    private final int HEIGHT = 150;

    @Mock
    UserDAOImpl userDAO;

    @Before
    public void setUp() {
        initMocks(this);
        UserServiceAdaptor.setUserDao(userDAO);
        loginWindow = new LoginWindow();
    }

    @Test
    public void testLoginWindowParametersAreCorrect() {
        assertEquals("Please Log In", loginWindow.getTitle());
        assertEquals(WIDTH, loginWindow.getWidth());
        assertEquals(HEIGHT, loginWindow.getHeight());
    }

    @Test
    public void userLogin() {
        LoggedInUser loggedInUser = new LoggedInUser();
        LoggedInUser.loggedInUser = new User();
    }
}
