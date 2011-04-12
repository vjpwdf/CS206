package gui.input.validate;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/13/11
 * Time: 3:13 PM
 */
public class DateFormValidator extends FormValidator {
    /**
     * Validates date input type
     * @param keyEvent trigged when key is typed
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        JTextField source = (JTextField) keyEvent.getSource();
        String currentText = source.getText();
        if (keyEvent.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            currentText += keyEvent.getKeyChar();
        }
        valid = canConvertTextToDate(currentText);
        if (keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE && source.getText().length() != 0) {
            currentText = source.getText().substring(0, source.getText().length() - 1);
            valid = canConvertTextToDate(currentText);
        }
        formValidatorWorker.performValidation();
    }

    /**
     * Checks to see if it can convert the input to a date type
     * @param currentText text to convert
     * @return true if it could be successfully converted
     */
    private boolean canConvertTextToDate(String currentText) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try {
            df.parse(currentText);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Ignored
     * @param keyEvent ignored
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    /**
     * Ignored
     * @param keyEvent ignored
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    /**
     * Error message
     * @return error message
     */
    @Override
    public String toString() {
        return "Valid Format: dd/mm/yyyy";
    }
}
