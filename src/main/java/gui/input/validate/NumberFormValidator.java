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
    @Override
    public String toString() {
        return "Value is not a valid number";
    }

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

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    private boolean canConvertTextToFloat(String currentText) {
        try {
            Float.valueOf(currentText);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
