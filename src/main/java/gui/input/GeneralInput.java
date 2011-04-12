package gui.input;

import gui.input.image.ImagePane;
import gui.input.validate.FormValidator;
import gui.input.validate.FormValidatorWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 2/26/11
 * Time: 3:33 PM
 */
public class GeneralInput extends Box {
    private JTextField input;
    private FormValidatorWorker formValidatorWorker;

    /**
     * Gets input field
     * @return input field
     */
    public JTextField getInput() {
        return input;
    }

    /**
     * General input constructor
     * @param name name of input for label
     * @param addValidation whether to add validation to the general input
     */
    public GeneralInput(String name, boolean addValidation) {
        super(2);

        JLabel label = new JLabel(name);
        label.setMaximumSize(new Dimension(100, 20));
        input = new JTextField();
        input.setMaximumSize(new Dimension(200, 20));

        add(label);
        add(input);

        if (addValidation) {
            JLabel errorLabel = new JLabel();
            errorLabel.setMaximumSize(new Dimension(250, 20));
            Image errorIcon = new BufferedImage(20, 20, BufferedImage.BITMASK);
            ImagePane imagePane = new ImagePane(errorIcon, 20, 20);
            formValidatorWorker = new FormValidatorWorker(errorLabel, imagePane);
            input.addKeyListener(formValidatorWorker);

            add(imagePane);
            add(errorLabel);
        }
    }

    /**
     * Adds a new form validator to the general input
     * @param formValidator form validator to add to general input
     */
    public void addNewFormValidator(FormValidator formValidator) {
        formValidator.setFormValidatorWorker(formValidatorWorker);
        formValidatorWorker.addNewFormValidator(formValidator);
        input.addKeyListener(formValidator);
    }

    /**
     * Gets the form validator worker of the general input
     * @return the form validator worker of the general input
     */
    public FormValidatorWorker getFormValidatorWorker() {
        return formValidatorWorker;
    }
}
