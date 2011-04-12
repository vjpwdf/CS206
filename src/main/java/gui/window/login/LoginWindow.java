package gui.window.login;

import gui.button.login.CreateUserButton;
import gui.button.login.LoginButton;
import gui.input.GeneralInput;
import gui.input.validate.MaxLengthFormValidator;
import gui.input.validate.MinLengthFormValidator;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 3:09 PM
 */
public class LoginWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 150;

    /**
     * Shows the login window
     * @throws HeadlessException thrown if could not build window correctly
     */
    public LoginWindow() throws HeadlessException {
        setTitle("Please Log In");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box loginForm = Box.createVerticalBox();

        GeneralInput userName = new GeneralInput("Username: ", true);
        userName.addNewFormValidator(new MinLengthFormValidator(3));
        userName.addNewFormValidator(new MaxLengthFormValidator(30));
        GeneralInput password = new GeneralInput("Password: ", true);
        password.addNewFormValidator(new MinLengthFormValidator(3));
        password.addNewFormValidator(new MaxLengthFormValidator(30));
        JButton loginButton = new LoginButton(this, userName, password);
        JButton createUserButton = new CreateUserButton();
        userName.getFormValidatorWorker().monitorButtons(Arrays.asList(loginButton));
        password.getFormValidatorWorker().monitorButtons(Arrays.asList(loginButton));

        loginForm.add(userName);
        loginForm.add(password);
        loginForm.add(loginButton);
        loginForm.add(createUserButton);

        add(loginForm);
    }
}