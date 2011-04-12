package gui.input.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 5:30 PM
 */
public class ImageFileFilter extends FileFilter {
    /**
     * Image file filter
     * @param file file to filter if necessary
     * @return true if should accept file as valid
     */
    @Override
    public boolean accept(File file) {
        String fileName = file.getName();
        return file.isDirectory() || fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg") || fileName.endsWith(".bmp");
    }

    /**
     * Gets the file type accepted
     * @return the file type accepted
     */
    @Override
    public String getDescription() {
        return "*.jpg, *.png, *.jpeg, *.bmp";
    }
}
