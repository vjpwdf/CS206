package gui.input.validate;

import gui.input.image.ImagePane;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import static junit.framework.Assert.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/15/11
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormValidatorWorker_UT {
    @Mock
    MaxLengthFormValidator maxLengthFormValidator;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testPerformValidation() throws Exception {
        //Makes a form validator and force it to false.
        JTextField textField = new JTextField();
        textField.setText("123456");
        KeyEvent keyEvent = new KeyEvent(textField, 0, 0, 0, 0, KeyEvent.CHAR_UNDEFINED);
        maxLengthFormValidator.setMaxLength(5);
        maxLengthFormValidator.keyPressed(keyEvent);

        JButton testButton = new JButton();
        Image test = new BufferedImage(1,1,BufferedImage.BITMASK);
        ImagePane imagePane = new ImagePane(test, 10, 10);
        FormValidatorWorker formValidatorWorker = new FormValidatorWorker(new JLabel(), imagePane);
        formValidatorWorker.addNewFormValidator(maxLengthFormValidator);
        formValidatorWorker.monitorButtons(Arrays.asList(testButton));
        formValidatorWorker.keyTyped(keyEvent);
        verify(maxLengthFormValidator).isValid();
        assertFalse(testButton.isEnabled());
    }
}
