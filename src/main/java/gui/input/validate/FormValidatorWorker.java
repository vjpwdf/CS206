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
 * To change this template use File | Settings | File Templates.
 */
public class FormValidatorWorker implements KeyListener {
    private List<FormValidator> formValidators = new ArrayList<FormValidator>();
    private JLabel errorLabel;
    private ImagePane imagePane;
    private List<JButton> buttons;

    public FormValidatorWorker(JLabel errorLabel, ImagePane imagePane) {
        this.errorLabel = errorLabel;
        this.imagePane = imagePane;
    }

    public void addNewFormValidator(FormValidator formValidator) {
        formValidators.add(formValidator);
    }

    public void monitorButtons(List<JButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        performValidation();
    }

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

    private void enableButtons() {
        if(buttons == null) {
            return;
        }
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
    }

    private void disableButtons() {
        if(buttons == null) {
            return;
        }
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
