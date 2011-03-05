package gui.action.general;

import gui.input.GeneralInput;
import gui.input.GeneralInputFileBrowser;
import hibernate.serviceadaptor.ItemServiceAdaptor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 2/27/11
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddItemActionListener implements ActionListener {
    private GeneralInput nameInput;
    private GeneralInput priceInput;
    private GeneralInput upc;
    private GeneralInput description;
    private GeneralInput manufacturer;
    private GeneralInputFileBrowser fileBrowser;

    public AddItemActionListener(GeneralInput nameInput, GeneralInput priceInput, GeneralInput upc, GeneralInput description, GeneralInput manufacturer, GeneralInputFileBrowser fileBrowser) {
        this.nameInput = nameInput;
        this.priceInput = priceInput;
        this.upc = upc;
        this.description = description;
        this.manufacturer = manufacturer;
        this.fileBrowser = fileBrowser;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String name = nameInput.getInput().getText();
        String price = priceInput.getInput().getText();
        String upcVal = upc.getInput().getText();
        String descriptionVal = description.getInput().getText();
        String manufacturerVal = manufacturer.getInput().getText();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(fileBrowser.getInput().getText()));
        } catch (IOException e) {}
        ItemServiceAdaptor itemServiceAdaptor = new ItemServiceAdaptor();
        itemServiceAdaptor.saveItem(name, price, upcVal, descriptionVal, manufacturerVal, image);

    }
}
