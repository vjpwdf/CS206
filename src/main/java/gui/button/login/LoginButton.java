package gui.button.login;

import gui.action.login.LoginButtonAction;
import gui.input.GeneralInput;
import gui.window.login.LoginWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 3:13 PM
 */
public class LoginButton extends JButton {
    private static final Integer WIDTH = 190;
    private static final Integer HEIGHT = 35;

    /**
     * Login button constructor
     * @param loginWindow login window to close
     * @param userName user name
     * @param password password
     */
    public LoginButton(LoginWindow loginWindow, GeneralInput userName, GeneralInput password) {
        setText("Login");
        addActionListener(new LoginButtonAction(loginWindow, userName, password));
        setIcon(new ImageIcon("main/login/login.png"));

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }
}
