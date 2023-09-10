module com.parsakav.pgukala {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;

    requires eu.hansolo.tilesfx;
    requires MaterialFX;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires lombok;
    requires java.naming;
    requires java.sql;
    opens com.parsakav.pgukala.entity to org.hibernate.orm.core;
    opens com.parsakav.pgukala to javafx.fxml;
    opens com.parsakav.pgukala.controller to javafx.fxml;
    exports com.parsakav.pgukala ;
    exports com.parsakav.pgukala.controller ;
}