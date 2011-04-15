package gui.window.login;

import gui.MessageBuilder;
import gui.action.login.AddNewUserAction;
import gui.window.WindowTest;
import hibernate.dao.UserDAOImpl;
import hibernate.serviceadaptor.UserServiceAdaptor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/12/11
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateUserWindow_UT extends WindowTest {
    private final int WIDTH = 500;
    private final int HEIGHT = 150;
    private CreateUserWindow createUserWindow;

    @Mock
    UserDAOImpl userDAO;

    @Mock
    MessageBuilder messageBuilder;

    @Before
    public void setUp() {
        initMocks(this);
        UserServiceAdaptor.setUserDao(userDAO);
        createUserWindow = new CreateUserWindow();
    }

    @Test
    public void testCreateUserWindowParametersAreCorrect() {
        assertEquals("Create A User Account", createUserWindow.getTitle());
        assertEquals(WIDTH, createUserWindow.getWidth());
        assertEquals(HEIGHT, createUserWindow.getHeight());
    }

    @Test
    public void testCreateNewUser() {
        intializeMockedMessageBuilder();
        createUserWindow.getUserName().getInput().setText("test-user");
        createUserWindow.getPassword().getInput().setText("0123456");
        createUserWindow.getCreateUserButton().doClick();
        verify(userDAO).createUserAccount("test-user", "0123456");
        verify(messageBuilder).displayMessage("Username Created Successfully", "Success", JOptionPane.DEFAULT_OPTION);
    }

    private void intializeMockedMessageBuilder() {
        AddNewUserAction addNewUserAction = (AddNewUserAction)createUserWindow.getCreateUserButton().getActionListeners()[0];
        addNewUserAction.setMessageBuilder(messageBuilder);
    }
}
