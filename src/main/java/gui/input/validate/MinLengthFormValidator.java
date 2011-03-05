package gui.input.validate;


import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class MinLengthFormValidator extends FormValidator {
    private int minLength;

    public MinLengthFormValidator(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public String toString() {
        return "Minimum length must be " + minLength;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

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

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
