package gui.input.validate;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaxLengthFormValidator extends FormValidator {
    private int maxLength;

    public MaxLengthFormValidator(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String toString() {
        return "Maximum length is " + maxLength;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

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

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
