package kstn.tkxdpm.aims.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import kstn.tkxdpm.aims.controllers.ItemMarketController;
import kstn.tkxdpm.aims.models.Item;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private VBox chosenItemCard;

    @FXML
    private GridPane gridpane;

    @FXML
    private ImageView itemImage;

    @FXML
    private Label itemNameLabel;

    @FXML
    private Label itemPriceLabel;

    @FXML
    private ScrollPane scrollpane;

    private List<Item> items = new ArrayList<>();

    private List<Item> getData() {
        List<Item> items = new ArrayList<>();
        Item item;

        for (int i = 0; i < 20; ++i) {
            item = new Item();
            item.setName("Novel");
            item.setPrice(3.00);
            item.setImgSrc("E:\\Programming language\\TKXDPM\\TKXDPM.CNTN.20221-20190037.HoAnh\\Setup\\src\\main\\resources\\imgs\\harry-potter-book.png");
            items.add(item);
        }
        return items;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        items.addAll(getData());

        int column = 0;
        int row = 1;

        try {
            for (int i = 0; i < items.size(); ++i) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/kstn/tkxdpm/aims/views/components/ItemMarket.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemMarketController itemMarketController = new ItemMarketController();
                itemMarketController.setData(items.get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridpane.add(anchorPane, column++, row);

                //set grid width
                gridpane.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridpane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridpane.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridpane.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridpane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridpane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
