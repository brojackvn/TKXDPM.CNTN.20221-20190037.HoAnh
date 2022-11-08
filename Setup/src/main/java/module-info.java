module kstn.tkxdpm.aims {
    requires javafx.controls;
    requires javafx.fxml;

    opens kstn.tkxdpm.aims.main to javafx.fxml;
    exports kstn.tkxdpm.aims.main;

    opens kstn.tkxdpm.aims.controllers to javafx.fxml;
    exports kstn.tkxdpm.aims.controllers;
}