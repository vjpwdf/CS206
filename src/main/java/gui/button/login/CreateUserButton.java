package gui.button.login;

import gui.action.login.CreateUserAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 22/03/11
 * Time: 9:59 PM
 */
public class CreateUserButton extends JButton {
    private static final Integer WIDTH = 190;
    private static final Integer HEIGHT = 35;
    private final String name = "CreateUserButton";

    /**
     * Create user button constructor
     */
    public CreateUserButton() {
        setText("Create Account");
        addActionListener(new CreateUserAction());
        setIcon(new ImageIcon("main/window/add-button.png"));

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }
}