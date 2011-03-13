package gui.input.validate;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/13/11
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateFormValidator extends FormValidator {
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

    private boolean canConvertTextToDate(String currentText) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try {
            df.parse(currentText);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public String toString() {
        return "Valid Format: dd/mm/yyyy";
    }
}
