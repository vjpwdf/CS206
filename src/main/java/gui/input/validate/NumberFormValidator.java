package gui.input.validate;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class NumberFormValidator extends FormValidator {
    /**
     * Error message
     * @return error message
     */
    @Override
    public String toString() {
        return "Value is not a valid number";
    }

    /**
     * Checks the input to make sure it is a number
     * @param keyEvent event to get key code of number typed
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        JTextField source = (JTextField) keyEvent.getSource();
        String currentText = source.getText();
        if(keyEvent.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            currentText += keyEvent.getKeyChar();
        }
        valid = canConvertTextToFloat(currentText);
        if(keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE && source.getText().length() != 0) {
            currentText = source.getText().substring(0, source.getText().length()-1);
            valid = canConvertTextToFloat(currentText);
        }
        formValidatorWorker.performValidation();
    }

    /**
     * Ignored
     * @param keyEvent ignored
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    /**
     * Checks to see if text input can be converted to a float
     * @param currentText text input to see if can be converted to a float
     * @return true if text input can be converted to a float
     */
    private boolean canConvertTextToFloat(String currentText) {
        try {
            Float.valueOf(currentText);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Ignored
     * @param keyEvent ignored
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
