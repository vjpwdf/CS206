package gui.input.image;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 5:36 PM
 */
public class ImagePreviewPanel extends JPanel implements PropertyChangeListener {
    private int width, height;
    private Image image;
    private int scaleSize;
    private Color bg;

    /**
     * Image preview panel constructor
     * @param panelWidth width of panel
     * @param panelHeight height of panel
     */
    public ImagePreviewPanel(int panelWidth, int panelHeight) {
        scaleSize = panelWidth;
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setMaximumSize(new Dimension(panelWidth, panelHeight));
        setMinimumSize(new Dimension(panelWidth, panelHeight));
        bg = getBackground();
        setBorder(new BevelBorder ( BevelBorder.RAISED ));
    }

    /**
     * When selected file is selected, draw image in preview panel
     * @param e makes sure event is selected file changed property
     */
    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();

        if (propertyName.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
            String name = ((JTextField) e.getSource()).getText();


            if (name != null && (
                    name.toLowerCase().endsWith(".jpg") ||
                    name.toLowerCase().endsWith(".jpeg") ||
                    name.toLowerCase().endsWith(".gif") ||
                    name.toLowerCase().endsWith(".png"))) {
                ImageIcon icon = new ImageIcon(name);
                image = icon.getImage();
                scaleImage();
                repaint();
            }
        }
    }

    public void scaleImage() {
        width = image.getWidth(this);
        height = image.getHeight(this);
        double ratio;

        if (width >= height) {
            ratio = (double) (scaleSize - 5) / width;
            width = scaleSize - 5;
            height = (int) (height * ratio);
        } else {
            if (getHeight() > 150) {
                ratio = (double) (scaleSize - 5) / height;
                height = scaleSize - 5;
                width = (int) (width * ratio);
            } else {
                ratio = (double) getHeight() / height;
                height = getHeight();
                width = (int) (width * ratio);
            }
        }

        image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

    public void paintComponent(Graphics g) {
        g.setColor(bg);
        g.fillRect(0, 0, scaleSize, getHeight());
        g.drawImage(image, getWidth() / 2 - width / 2 + 5,
                getHeight() / 2 - height / 2, this);
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
