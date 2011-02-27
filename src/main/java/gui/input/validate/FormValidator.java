package gui.input.validate;

import java.awt.event.KeyListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 27/02/11
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class FormValidator implements KeyListener {
    boolean valid = true;
    FormValidatorWorker formValidatorWorker;

    public boolean isValid() {
        return valid;
    }

    public void setFormValidatorWorker(FormValidatorWorker formValidatorWorker) {
        this.formValidatorWorker = formValidatorWorker;
    }
}
