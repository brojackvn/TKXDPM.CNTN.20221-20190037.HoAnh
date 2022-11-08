package kstn.tkxdpm.aims.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kstn.tkxdpm.aims.main.Main;
import kstn.tkxdpm.aims.models.Item;

public class ItemMarketController {

    @FXML
    private ImageView image;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    private Item item;

    public void setData(Item item) {
//        this.item = item;
//        nameLabel.setText(item.getName());
//        priceLabel.setText(Main.CURRENCY + item.getPrice());
//        Image img = new Image(getClass().getResourceAsStream(item.getImgSrc()));
//        image.setImage(img);
    }
}
