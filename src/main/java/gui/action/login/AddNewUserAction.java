package gui.action.login;

import gui.MessageBuilder;
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
 */
public class AddNewUserAction implements ActionListener {
    private CreateUserWindow createUserWindow;
    private GeneralInput userName;
    private GeneralInput password;
    private MessageBuilder messageBuilder = new MessageBuilder();

    /**
     * Action for add new user button
     * @param createUserWindow window to close upon success
     * @param userName user name
     * @param password password
     */
    public AddNewUserAction(CreateUserWindow createUserWindow, GeneralInput userName, GeneralInput password) {
        this.createUserWindow = createUserWindow;
        this.userName = userName;
        this.password = password;
    }


    /**
     * Add new user action
     * @param actionEvent action event ignored
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(UserServiceAdaptor.userNameAlreadyExists(userName.getInput().getText())) {
            messageBuilder.displayMessage("Username Already Exists", "There was a problem", JOptionPane.OK_OPTION);
            return;
        }
        UserServiceAdaptor.createUserAccount(userName.getInput().getText(), password.getInput().getText());
        messageBuilder.displayMessage("Username Created Successfully", "Success", JOptionPane.DEFAULT_OPTION);
        createUserWindow.setVisible(false);
    }

    public void setMessageBuilder(MessageBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
    }
}
