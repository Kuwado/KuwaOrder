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
    requires java.sql;

    // opens
    opens fx to javafx.fxml;
    opens fx.wh to javafx.fxml;
    opens fx.order to javafx.fxml;
    opens fx.makeorder to javafx.fxml;
    opens fx.site to javafx.base, javafx.fxml;
    opens fx.sale to javafx.fxml;
    opens fx.breadcrumb to javafx.fxml;
    opens fx.sidebar to javafx.fxml;
    opens fx.makerequest to javafx.fxml;
    opens application to javafx.fxml;

    // export
    exports fx;
    exports fx.makeorder;
    exports fx.breadcrumb;
    exports fx.sidebar;
    exports fx.makerequest;
    exports fx.wh;
    exports fx.site;
    exports fx.sale;
    exports application;
    exports model;
    exports solution;
    exports model.tabledata;
}
