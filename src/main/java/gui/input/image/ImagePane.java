package gui.input.image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 10:26 AM
 */
public class ImagePane extends JPanel {
    private Image image;

    /**
     * Image pane for image icon
     * @param imageIcon image to be displayed
     * @param width width of image
     * @param height height of image
     */
    public ImagePane(Image imageIcon, int width, int height) {
        this.image = imageIcon;
        setMaximumSize(new Dimension(width, height));
    }

    /**
     * Sets the image for image pane
     * @param image image to be set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Paints the image pane
     * @param g graphics to fill
     */
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        int x = (getWidth() - image.getWidth(null)) / 2;
        int y = (getHeight() - image.getHeight(null)) / 2;
        if (((BufferedImage) image).getType() != BufferedImage.BITMASK) {
            g.drawImage(image, x, y, this);
        }
    }
}
