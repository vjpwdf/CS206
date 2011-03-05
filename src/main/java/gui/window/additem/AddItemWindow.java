package gui.window.additem;

import gui.button.general.AddItemButton;
import gui.input.GeneralInput;
import gui.input.GeneralInputFileBrowser;
import gui.input.image.ImagePreviewPanel;
import gui.input.validate.MaxLengthFormValidator;
import gui.input.validate.MinLengthFormValidator;
import gui.input.validate.NumberFormValidator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 5:59:57 PM
 */
public class AddItemWindow extends JFrame {
    private static final Integer WIDTH = 600;
    private static final Integer HEIGHT = 330;

    public AddItemWindow() throws HeadlessException {
        setTitle("Add An Item");
        setSize(WIDTH, HEIGHT);
        Box itemForm = Box.createVerticalBox();

        GeneralInput nameInput = new GeneralInput("Item Name", true);
        nameInput.addNewFormValidator(new MinLengthFormValidator(3));
        nameInput.addNewFormValidator(new MaxLengthFormValidator(30));
        itemForm.add(nameInput);

        GeneralInput priceInput = new GeneralInput("Price", true);
        priceInput.addNewFormValidator(new NumberFormValidator());
        itemForm.add(priceInput);

        GeneralInput upc = new GeneralInput("UPC", true);
        upc.addNewFormValidator(new MinLengthFormValidator(14));
        upc.addNewFormValidator(new MaxLengthFormValidator(14));
        itemForm.add(upc);

        GeneralInput description = new GeneralInput("Description", true);
        description.addNewFormValidator(new MaxLengthFormValidator(500));
        itemForm.add(description);

        GeneralInput manufacturer = new GeneralInput("Manufacturer", true);
        manufacturer.addNewFormValidator(new MinLengthFormValidator(3));
        manufacturer.addNewFormValidator(new MaxLengthFormValidator(100));
        itemForm.add(manufacturer);


        GeneralInputFileBrowser fileBrowser = new GeneralInputFileBrowser("Select Image");
        itemForm.add(fileBrowser);
        ImagePreviewPanel imagePreviewPanel = new ImagePreviewPanel(120, 120);
        itemForm.add(imagePreviewPanel);
        fileBrowser.getInput().addPropertyChangeListener(imagePreviewPanel);

        JButton addItem = new AddItemButton("Add Item", nameInput, priceInput, upc, description, manufacturer, fileBrowser);
        itemForm.add(addItem);

        add(itemForm);
    }
}
