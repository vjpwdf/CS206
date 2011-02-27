package gui.action.login;

import gui.GUIBuilder;
import gui.input.GeneralInput;
import gui.window.login.LoginWindow;
import gui.window.main.MainWindow;
import hibernate.serviceadaptor.UserServiceAdaptor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginButtonAction implements ActionListener {
    GUIBuilder guiBuilder = new GUIBuilder();
    private LoginWindow loginWindow;
    private GeneralInput password;
    private GeneralInput userName;

    public LoginButtonAction(LoginWindow loginWindow, GeneralInput userName, GeneralInput password) {
        this.loginWindow = loginWindow;
        this.userName = userName;
        this.password = password;
    }

    public void setGuiBuilder(GUIBuilder guiBuilder) {
        this.guiBuilder = guiBuilder;
    }

    public void actionPerformed(ActionEvent e) {
        UserServiceAdaptor userServiceAdaptor = new UserServiceAdaptor();
        if (userServiceAdaptor.loginWithCredentials(userName.getInput().getText(), password.getInput().getText())) {
            Main.loggedInUser = userName.getInput().getText();
            loginWindow.setVisible(false);
            MainWindow mainWindow = guiBuilder.buildUserInterface();
            mainWindow.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,"Login Failed", "Unable to login.  Please check the credentials provided", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
