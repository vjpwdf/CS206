package gui.input.validate;

import gui.input.image.ImagePane;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/8/11
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class NumberFormValidator_UT {
    @Test
    public void testToString() throws Exception {
        NumberFormValidator numberFormValidator = new NumberFormValidator();
        assertNotNull(numberFormValidator.toString());
        assert(numberFormValidator.toString().equals("Value is not a valid number"));
    }

    @Test
    public void testKeyTyped() throws Exception {
        JTextField textField = new JTextField();
        NumberFormValidator numberFormValidator = new NumberFormValidator();
        numberFormValidator.setFormValidatorWorker(new FormValidatorWorker(new JLabel(), new ImagePane(new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR), 1, 1)));
        KeyEvent keyEvent = new KeyEvent(textField, 0, 0, 0, 0, KeyEvent.CHAR_UNDEFINED);
        textField.setText("abcdef");
        numberFormValidator.keyTyped(keyEvent);
        assertFalse(numberFormValidator.isValid());
        keyEvent.setKeyCode(KeyEvent.VK_BACK_SPACE);
        textField.setText("10");
        numberFormValidator.keyTyped(keyEvent);
        assertTrue(numberFormValidator.isValid());
    }
}
