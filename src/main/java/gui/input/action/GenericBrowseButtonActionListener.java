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
 */
public class GenericBrowseButtonActionListener implements ActionListener {
    private JTextField input;
    private FileFilter fileFilter;
    private JFileChooser fileChooser = new JFileChooser();

    /**
     * Generic browse button action
     * @param input text field
     * @param fileFilter file filter
     */
    public GenericBrowseButtonActionListener(JTextField input, FileFilter fileFilter) {
        this.input = input;
        this.fileFilter = fileFilter;
    }

    /**
     * Opens a file chooser to select image and load it
     * @param actionEvent ignore
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //fileChooser = new JFileChooser();
        if (fileFilter != null) {
            fileChooser.setFileFilter(fileFilter);
        }
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            input.setText(file.getAbsolutePath());
            input.firePropertyChange(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, 0, 1);
        }
    }

    public void setFileChooser(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    public FileFilter getFileFilter() {
        return fileFilter;
    }
}
