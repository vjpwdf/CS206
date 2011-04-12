package gui.input.validate;

import java.awt.event.KeyListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 10:11 AM
 */
public abstract class FormValidator implements KeyListener {
    boolean valid = true;
    FormValidatorWorker formValidatorWorker;

    /**
     * returns if the form validator is in a valid state
     * @return true if the form validator is in a valid state
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Sets the form validator worker
     * @param formValidatorWorker form validator worker
     */
    public void setFormValidatorWorker(FormValidatorWorker formValidatorWorker) {
        this.formValidatorWorker = formValidatorWorker;
    }
}
