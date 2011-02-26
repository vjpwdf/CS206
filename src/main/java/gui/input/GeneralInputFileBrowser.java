package gui.input;


import gui.input.action.GenericBrowseButtonActionListener;
import gui.input.filter.ImageFileFilter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeneralInputFileBrowser extends Box {

    private JLabel label;
    private JTextField input;
    private JButton browseButton;


    public GeneralInputFileBrowser(String name) {
        super(0);

        label = new JLabel(name);
        label.setMaximumSize(new Dimension(100, 20));

        input = new JTextField();
        input.setMaximumSize(new Dimension(200, 20));

        browseButton = new JButton("Browse");
        browseButton.addActionListener(new GenericBrowseButtonActionListener(input, new ImageFileFilter()));

        add(label);
        add(input);
        add(browseButton);
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getInput() {
        return input;
    }

    public JButton getBrowseButton() {
        return browseButton;
    }
}