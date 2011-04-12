package gui.button.login;

import gui.action.login.AddNewUserAction;
import gui.input.GeneralInput;
import gui.window.login.CreateUserWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 22/03/11
 * Time: 10:10 PM
 */
public class AddNewUserButton extends JButton {
    private static final Integer WIDTH = 190;
    private static final Integer HEIGHT = 35;


    /**
     * Add new user button
     * @param createUserWindow window to close upon completion
     * @param userName user name
     * @param password password
     */
    public AddNewUserButton(CreateUserWindow createUserWindow, GeneralInput userName, GeneralInput password) {
        setText("Create Account");
        addActionListener(new AddNewUserAction(createUserWindow, userName, password));
        setIcon(new ImageIcon("main/window/add-button.png"));

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }
}
