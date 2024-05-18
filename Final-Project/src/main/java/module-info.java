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
    requires java.sql;
    opens fx.order to javafx.fxml;

    opens fx to javafx.fxml;
    opens application to javafx.fxml;
    opens org.example.final_project to javafx.fxml;
    exports application;
    exports org.example.final_project;
    exports fx;
    exports fx.makeorder;
    opens fx.makeorder to javafx.fxml;
    exports model;
    exports solution;
    exports fx.site;
    opens fx.site to javafx.base, javafx.fxml;
    exports fx.sale;
    opens fx.sale to javafx.fxml;
    opens fx.product to javafx.fxml;
    exports fx.product;
    exports model.tabledata;
    exports fx.breadcrumb;
    opens fx.breadcrumb to javafx.fxml;

    opens fx.sidebar to javafx.fxml;
    exports fx.sidebar;


}
