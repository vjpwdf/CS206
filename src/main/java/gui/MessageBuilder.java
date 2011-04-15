package gui;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/15/11
 * Time: 12:10 PM
 */
public class MessageBuilder {
    private JOptionPane jOptionPane = new JOptionPane();

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    public void displayMessage(String code, String message, int messageEnum) {
        JOptionPane.showMessageDialog(null, code, message, messageEnum);
    }
}
