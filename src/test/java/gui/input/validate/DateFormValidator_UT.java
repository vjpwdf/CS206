package gui.input.validate;

import gui.input.image.ImagePane;
import org.junit.Test;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/7/11
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateFormValidator_UT {

    @Test
    public void testDateValidator() {
        DateFormValidator dateFormValidator = new DateFormValidator();
        dateFormValidator.setFormValidatorWorker(new FormValidatorWorker(new JLabel(), new ImagePane(new BufferedImage(1,1, BufferedImage.TYPE_3BYTE_BGR), 1,1)));
        JTextField textField = new JTextField();
        textField.addKeyListener(dateFormValidator);
        textField.setText("TEST");
        KeyEvent backSpace = new KeyEvent(textField, 0, 0, 0, 0, KeyEvent.CHAR_UNDEFINED);
        backSpace.setKeyCode(KeyEvent.VK_BACK_SPACE);
        dateFormValidator.keyTyped(backSpace);
        assertFalse(dateFormValidator.isValid());
        textField.setText("12/12/2010");
        dateFormValidator.keyTyped(new KeyEvent(textField, 0, 0, 0, 0, KeyEvent.CHAR_UNDEFINED));
        assertTrue(dateFormValidator.isValid());
    }

    @Test
    public void testToString() {
        DateFormValidator dateFormValidator = new DateFormValidator();
        assertNotNull(dateFormValidator.toString());
        assert(dateFormValidator.toString().equals("Valid Format: dd/mm/yyyy"));
    }
}
