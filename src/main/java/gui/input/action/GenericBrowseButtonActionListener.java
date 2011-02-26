package gui.input.action;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenericBrowseButtonActionListener implements ActionListener {
    private JTextField input;
    private FileFilter fileFilter;

    public GenericBrowseButtonActionListener(JTextField input, FileFilter fileFilter) {
        this.input = input;
        this.fileFilter = fileFilter;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileFilter != null) {
            fileChooser.setFileFilter(fileFilter);
        }
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            input.setText(file.getAbsolutePath());
            input.firePropertyChange(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, 0, 1);
        }
    }
}
