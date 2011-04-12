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
 */
public class LoginButtonAction implements ActionListener {
    GUIBuilder guiBuilder = new GUIBuilder();
    private LoginWindow loginWindow;
    private GeneralInput password;
    private GeneralInput userName;

    /**
     * Action for login button
     * @param loginWindow window to display
     * @param userName user name
     * @param password password
     */
    public LoginButtonAction(LoginWindow loginWindow, GeneralInput userName, GeneralInput password) {
        this.loginWindow = loginWindow;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Used for UT's to set gui builder
     * @param guiBuilder gui builder
     */
    @SuppressWarnings("unused")
    public void setGuiBuilder(GUIBuilder guiBuilder) {
        this.guiBuilder = guiBuilder;
    }

    /**
     * Action to see if can log in
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        if (UserServiceAdaptor.loginWithCredentials(userName.getInput().getText(), password.getInput().getText())) {
            loginWindow.setVisible(false);
            MainWindow mainWindow = guiBuilder.buildUserInterface();
            mainWindow.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,"Login Failed", "Unable to login.  Please check the credentials provided", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
