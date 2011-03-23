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

    private JLabel label;
    private JTextField input;
    private JLabel errorLabel;
    private ImagePane imagePane;
    private Image errorIcon;
    private FormValidatorWorker formValidatorWorker;

    public JTextField getInput() {
        return input;
    }

    public GeneralInput(String name, boolean addValidation) {
        super(2);

        label = new JLabel(name);
        label.setMaximumSize(new Dimension(100, 20));
        input = new JTextField();
        input.setMaximumSize(new Dimension(200, 20));

        add(label);
        add(input);

        if (addValidation) {
            errorLabel = new JLabel();
            errorLabel.setMaximumSize(new Dimension(250, 20));
            errorIcon = new BufferedImage(20, 20, BufferedImage.BITMASK);
            imagePane = new ImagePane(errorIcon, 20, 20);
            formValidatorWorker = new FormValidatorWorker(errorLabel, imagePane);
            input.addKeyListener(formValidatorWorker);

            add(imagePane);
            add(errorLabel);
        }


    }

    public void addNewFormValidator(FormValidator formValidator) {
        formValidator.setFormValidatorWorker(formValidatorWorker);
        formValidatorWorker.addNewFormValidator(formValidator);
        input.addKeyListener(formValidator);
    }

    public FormValidatorWorker getFormValidatorWorker() {
        return formValidatorWorker;
    }
}
