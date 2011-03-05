package gui.action.general;

import gui.input.GeneralInput;
import gui.input.GeneralInputFileBrowser;
import hibernate.serviceadaptor.ItemServiceAdaptor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

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
        byte[] imageBytes = null;
        try {
            imageBytes = convertFileToByteArray(new File(fileBrowser.getInput().getText()));
        } catch (FileNotFoundException e) {

        }
//        BufferedImage image = null;
//        try {
//            image = ImageIO.read(new File(fileBrowser.getInput().getText()));
//        } catch (IOException e) {}
        ItemServiceAdaptor itemServiceAdaptor = new ItemServiceAdaptor();
        itemServiceAdaptor.saveItem(name, price, upcVal, descriptionVal, manufacturerVal, imageBytes);

    }

    private byte[] convertFileToByteArray(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
        }

        return bos.toByteArray();
    }
}
