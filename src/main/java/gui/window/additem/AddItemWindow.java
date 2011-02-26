package gui.window.additem;

import gui.input.GeneralInput;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 5:59:57 PM
 */
public class AddItemWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 330;

    public AddItemWindow() throws HeadlessException {
        setTitle("Add An Item");
        setSize(WIDTH, HEIGHT);
        Box inputs = Box.createVerticalBox();
        GeneralInput nameInput = new GeneralInput("Item Name");
        inputs.add(nameInput);
        GeneralInput priceInput = new GeneralInput("Price");
        inputs.add(priceInput);
        add(inputs);
    }
}
