package gui.action.login;

import gui.window.login.CreateUserWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 22/03/11
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateUserAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CreateUserWindow createUserWindow = new CreateUserWindow();
        createUserWindow.setVisible(true);
    }
}
