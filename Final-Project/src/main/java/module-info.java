module application {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens fx.warehouse to javafx.fxml;

    opens fx to javafx.fxml;
    opens application to javafx.fxml;
    opens org.example.final_project to javafx.fxml;
    exports application;
    exports org.example.final_project;
    exports fx;
    exports fx.make_order;
    opens fx.make_order to javafx.fxml;
    exports model;
    exports solution;
}

