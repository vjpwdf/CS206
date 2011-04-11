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
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaxLengthFormValidator_UT {
    @Test
    public void testToString() throws Exception {
        MaxLengthFormValidator maxLengthFormValidator = new MaxLengthFormValidator(10);
        assertNotNull(maxLengthFormValidator.toString());
        assert(maxLengthFormValidator.toString().equals("Maximum length is " + 10));
    }

    @Test
    public void testKeyPressed() throws Exception {
        JTextField textField = new JTextField();
        textField.setText("123456");
        MaxLengthFormValidator maxLengthFormValidator = new MaxLengthFormValidator(5);
        maxLengthFormValidator.setFormValidatorWorker(new FormValidatorWorker(new JLabel(), new ImagePane(new BufferedImage(1,1,BufferedImage.TYPE_3BYTE_BGR), 1, 1)));
        KeyEvent keyEvent = new KeyEvent(textField, 0, 0, 0, 0, KeyEvent.CHAR_UNDEFINED);
        maxLengthFormValidator.keyPressed(keyEvent);
        assertFalse(maxLengthFormValidator.isValid());
        keyEvent.setKeyCode(KeyEvent.VK_BACK_SPACE);
        textField.setText("1234");
        maxLengthFormValidator.keyPressed(keyEvent);
        assertTrue(maxLengthFormValidator.isValid());
    }
}
