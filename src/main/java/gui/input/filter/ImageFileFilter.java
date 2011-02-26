package gui.input.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 5:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        String fileName = file.getName();
        return file.isDirectory() || fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg") || fileName.endsWith(".bmp");
    }

    @Override
    public String getDescription() {
        return "*.jpg, *.png, *.jpeg, *.bmp";
    }
}
