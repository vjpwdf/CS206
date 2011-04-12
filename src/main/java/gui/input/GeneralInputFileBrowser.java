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
 */
public class GeneralInputFileBrowser extends Box {
    private JTextField input;

    /**
     * General input file browser
     * @param name name of file browser
     */
    public GeneralInputFileBrowser(String name) {
        super(0);

        JLabel label = new JLabel(name);
        label.setMaximumSize(new Dimension(100, 20));

        input = new JTextField();
        input.setMaximumSize(new Dimension(200, 20));

        JButton browseButton = new JButton("Browse");
        browseButton.addActionListener(new GenericBrowseButtonActionListener(input, new ImageFileFilter()));

        add(label);
        add(input);
        add(browseButton);
    }

    /**
     * Gets the input for selected file
     * @return the input for the selected file
     */
    public JTextField getInput() {
        return input;
    }
}