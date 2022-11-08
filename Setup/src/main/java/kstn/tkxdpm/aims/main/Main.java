package kstn.tkxdpm.aims.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static final String CURRENCY = "$";

    @Override
    public void start(Stage primaryStage) throws Exception {
//        System.out.println(Main.class.getResource("/kstn/tkxdpm/aims/views/HomeView.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/kstn/tkxdpm/aims/views/HomeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("AIMS System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
