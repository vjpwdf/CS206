package gui.input.validate;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 11:07 AM
 */
public class MaxLengthFormValidator extends FormValidator {
    private int maxLength;

    /**
     * Max form length validator
     * @param maxLength max text length
     */
    public MaxLengthFormValidator(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * Error message
     * @return error message
     */
    @Override
    public String toString() {
        return "Maximum length is " + maxLength;
    }

    /**
     * Ignored
     * @param keyEvent ignored
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    /**
     * Checks current text to get length
     * @param keyEvent ignored
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        JTextField source = (JTextField) keyEvent.getSource();
        String currentText = source.getText();
        valid = currentText.length()+1 <= maxLength;
        if(keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE && source.getText().length() != 0) {
            currentText = source.getText().substring(0, source.getText().length()-1);
            valid = currentText.length() <= maxLength;
        }
    }

    /**
     * Ignored
     * @param keyEvent ignored
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
