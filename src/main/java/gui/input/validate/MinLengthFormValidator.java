package gui.input.validate;


import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 10:12 AM
 */
public class MinLengthFormValidator extends FormValidator {
    private int minLength;

    /**
     * Min form length validator
     * @param minLength min text length
     */
    public MinLengthFormValidator(int minLength) {
        this.minLength = minLength;
    }

    /**
     * Error message
     * @return error message
     */
    @Override
    public String toString() {
        return "Minimum length must be " + minLength;
    }

    /**
     * Ignored
     * @param keyEvent ignored
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    /**
     * Checks the text field for the min length requirement
     * @param keyEvent ignored
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        JTextField source = (JTextField) keyEvent.getSource();
        String currentText = source.getText();
        valid = currentText.length()+1>=minLength;
        if(keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE && source.getText().length() != 0) {
            currentText = source.getText().substring(0, source.getText().length()-1);
            valid = currentText.length()>=minLength;
        }
    }

    /**
     * Ignored
     * @param keyEvent ignored
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }
}
