package gui.window.addcoupon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11-Feb-2011
 * Time: 5:09:14 PM
 */
public class AddCouponWindowBackgroundPicture extends JPanel {
    Image backgroundImage = null;

    public AddCouponWindowBackgroundPicture() {
        MediaTracker mt = new MediaTracker(this);
        backgroundImage = Toolkit.getDefaultToolkit().getImage("add_coupon/window/coupon.gif");
        mt.addImage(backgroundImage, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, null);
    }
}