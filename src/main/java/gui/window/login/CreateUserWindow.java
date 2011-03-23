package gui.window.login;

import gui.button.login.AddNewUserButton;
import gui.input.GeneralInput;
import gui.input.validate.MaxLengthFormValidator;
import gui.input.validate.MinLengthFormValidator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 22/03/11
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateUserWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 150;

    public CreateUserWindow() throws HeadlessException {
        setTitle("Create A User Account");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box loginForm = Box.createVerticalBox();

        GeneralInput userName = new GeneralInput("Username: ", true);
        userName.addNewFormValidator(new MinLengthFormValidator(3));
        userName.addNewFormValidator(new MaxLengthFormValidator(30));
        GeneralInput password = new GeneralInput("Password: ", true);
        password.addNewFormValidator(new MinLengthFormValidator(3));
        password.addNewFormValidator(new MaxLengthFormValidator(30));
        JButton createUserButton = new AddNewUserButton(this, userName, password);

        loginForm.add(userName);
        loginForm.add(password);
        loginForm.add(createUserButton);

        add(loginForm);
    }
}