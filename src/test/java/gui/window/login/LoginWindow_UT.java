package gui.window.login;

import gui.window.WindowTest;
import org.junit.Before;
import org.junit.Test;
import utility.TestUtils;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

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

    @Before
    public void setUp() {
        loginWindow = new LoginWindow();
    }

    @Test
    public void testLoginWindowParametersAreCorrect() {
        assertEquals("Please Log In", loginWindow.getTitle());
        assertEquals(WIDTH, loginWindow.getWidth());
        assertEquals(HEIGHT, loginWindow.getHeight());
    }
}
