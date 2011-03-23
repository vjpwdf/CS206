package gui.action.login;

import gui.input.GeneralInput;
import gui.window.login.CreateUserWindow;
import hibernate.serviceadaptor.UserServiceAdaptor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 22/03/11
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddNewUserAction implements ActionListener {
    private CreateUserWindow createUserWindow;
    private GeneralInput userName;
    private GeneralInput password;

    public AddNewUserAction(CreateUserWindow createUserWindow, GeneralInput userName, GeneralInput password) {
        this.createUserWindow = createUserWindow;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        UserServiceAdaptor userServiceAdapter = new UserServiceAdaptor();
        if(userServiceAdapter.userNameAlreadyExists(userName.getInput().getText())) {
            JOptionPane.showMessageDialog(null, "Username Already Exists", "There was a problem", JOptionPane.OK_OPTION);
            return;
        }
        userServiceAdapter.createUserAccount(userName.getInput().getText(), password.getInput().getText());
        JOptionPane.showMessageDialog(null, "Username Created Successfully", "Success", JOptionPane.DEFAULT_OPTION);
        createUserWindow.setVisible(false);
    }
}
