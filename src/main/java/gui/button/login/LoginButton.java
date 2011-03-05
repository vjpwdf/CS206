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
 * To change this template use File | Settings | File Templates.
 */
public class LoginButton extends JButton {
    private static final Integer WIDTH = 120;
    private static final Integer HEIGHT = 35;

    public LoginButton(LoginWindow loginWindow, GeneralInput userName, GeneralInput password) {
        setText("Login");
        addActionListener(new LoginButtonAction(loginWindow, userName, password));
        setIcon(new ImageIcon("main/login/login.png"));

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }
}
