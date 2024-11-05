module com.example.Controllers {
    exports org.finalProyect.models; // Export the models package
    exports org.finalProyect.enums;  // Export the enums package

    // Open the models package to both Jackson and Gson
    opens org.finalProyect.models to com.fasterxml.jackson.databind, com.google.gson;

    requires com.fasterxml.jackson.databind;
    requires com.google.gson; // Require Gson
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens com.example.Controllers to javafx.fxml;
    exports com.example.Controllers;
}