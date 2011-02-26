package gui.input;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 2/26/11
 * Time: 3:33 PM
 */
public class GeneralInput extends Box {

    public JLabel label;
    public JTextField input;

    public GeneralInput(String name) {
        super(2);
        label = new JLabel(name);
        label.setMaximumSize(new Dimension(100, 20));
        input = new JTextField();
        input.setMaximumSize(new Dimension(200, 20));
        super.add(label);
        super.add(input);
    }
}
