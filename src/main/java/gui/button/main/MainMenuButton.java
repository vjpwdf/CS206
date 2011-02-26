package gui.button.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 2/26/11
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class MainMenuButton extends JButton {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 40;

    public MainMenuButton(){
        //asdf
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }

}
