package gui.input.validate;

import gui.input.image.ImagePane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 10:36 AM
 */
public class FormValidatorWorker implements KeyListener {
    private List<FormValidator> formValidators = new ArrayList<FormValidator>();
    private JLabel errorLabel;
    private ImagePane imagePane;
    private List<JButton> buttons;

    /**
     * form validator worker constructor
     * @param errorLabel error label to change
     * @param imagePane image pane for check mark or x mark
     */
    public FormValidatorWorker(JLabel errorLabel, ImagePane imagePane) {
        this.errorLabel = errorLabel;
        this.imagePane = imagePane;
    }

    /**
     * Add new form validator to worker
     * @param formValidator form validator to be added
     */
    public void addNewFormValidator(FormValidator formValidator) {
        formValidators.add(formValidator);
    }

    /**
     * Buttons to monitor for success and failure
     * @param buttons buttons to monitor
     */
    public void monitorButtons(List<JButton> buttons) {
        this.buttons = buttons;
    }

    /**
     * Performs validation when key is typed
     * @param keyEvent ignored
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        performValidation();
    }

    /**
     * Checks to see if any of the form validators are in an invalid state
     */
    public void performValidation() {
        try {
            errorLabel.setText("");
            imagePane.setImage(ImageIO.read(new File("images/check.png")));
            enableButtons();
            for (FormValidator formValidator : formValidators) {
                if (!formValidator.isValid()) {
                    disableButtons();
                    errorLabel.setText(formValidator.toString());
                    imagePane.setImage(ImageIO.read(new File("images/x.png")));
                    break;
                }
            }
            imagePane.update(imagePane.getGraphics());
        } catch (Exception e) {

        }
    }

    /**
     * Enables all buttons
     */
    private void enableButtons() {
        if(buttons == null) {
            return;
        }
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
    }

    /**
     * Disables all buttons
     */
    private void disableButtons() {
        if(buttons == null) {
            return;
        }
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
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
}
