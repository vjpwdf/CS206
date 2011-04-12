package gui.action.login;

import gui.window.login.CreateUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 22/03/11
 * Time: 10:01 PM
 */
public class CreateUserAction implements ActionListener {
    /**
     * Opens create user window
     * @param actionEvent ignored
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CreateUserWindow createUserWindow = new CreateUserWindow();
        createUserWindow.setVisible(true);
    }
}
