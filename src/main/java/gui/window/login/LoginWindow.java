package gui.window.login;

import gui.button.login.CreateUserButton;
import gui.button.login.LoginButton;
import gui.input.GeneralInput;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginWindow extends JFrame {
    private static final Integer WIDTH = 330;
    private static final Integer HEIGHT = 150;

    public LoginWindow() throws HeadlessException {
        setTitle("Please Log In");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box loginForm = Box.createVerticalBox();

        GeneralInput userName = new GeneralInput("Username: ", false);
        GeneralInput password = new GeneralInput("Password: ", false);
        JButton loginButton = new LoginButton(this, userName, password);
        JButton createUserButton = new CreateUserButton();

        loginForm.add(userName);
        loginForm.add(password);
        loginForm.add(loginButton);
        loginForm.add(createUserButton);

        add(loginForm);
    }
}