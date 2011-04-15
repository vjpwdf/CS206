package gui.window.login;

import gui.button.login.AddNewUserButton;
import gui.input.GeneralInput;
import gui.input.validate.MaxLengthFormValidator;
import gui.input.validate.MinLengthFormValidator;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 22/03/11
 * Time: 10:05 PM
 */
public class CreateUserWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 150;
    private GeneralInput userName;
    private GeneralInput password;
    private JButton createUserButton;

    /**
     * Create user window
     * @throws HeadlessException thrown if could not create window
     */
    public CreateUserWindow() throws HeadlessException {
        setTitle("Create A User Account");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box loginForm = Box.createVerticalBox();

        userName = new GeneralInput("Username: ", true);
        userName.addNewFormValidator(new MinLengthFormValidator(3));
        userName.addNewFormValidator(new MaxLengthFormValidator(30));
        password = new GeneralInput("Password: ", true);
        password.addNewFormValidator(new MinLengthFormValidator(3));
        password.addNewFormValidator(new MaxLengthFormValidator(30));
        createUserButton = new AddNewUserButton(this, userName, password);
        userName.getFormValidatorWorker().monitorButtons(Arrays.asList(createUserButton));
        password.getFormValidatorWorker().monitorButtons(Arrays.asList(createUserButton));

        loginForm.add(userName);
        loginForm.add(password);
        loginForm.add(createUserButton);

        add(loginForm);
    }

    public GeneralInput getUserName() {
        return userName;
    }

    public GeneralInput getPassword() {
        return password;
    }

    public JButton getCreateUserButton() {
        return createUserButton;
    }
}