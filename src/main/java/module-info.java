module es.etg.daw.prog.mercadaw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.poi.ooxml;
    requires javafx.graphics;
    requires javafx.base;

    exports es.etg.daw.prog.mercadaw;
    exports es.etg.daw.prog.mercadaw.model.entities.productos;
    exports es.etg.daw.prog.mercadaw.model.entities.compras;
    exports es.etg.daw.prog.mercadaw.model.entities.empleados;
    exports es.etg.daw.prog.mercadaw.controller;
    exports es.etg.daw.prog.mercadaw.view;

    opens es.etg.daw.prog.mercadaw.controller to javafx.fxml, javafx.graphics;
    opens es.etg.daw.prog.mercadaw.view to javafx.fxml;
    opens es.etg.daw.prog.mercadaw.model.entities.empleados to javafx.base;
    opens es.etg.daw.prog.mercadaw.model.entities.productos to javafx.base;
    opens es.etg.daw.prog.mercadaw.model.entities.compras to javafx.base;
    opens es.etg.daw.prog.mercadaw.view.producto to javafx.fxml;
    opens es.etg.daw.prog.mercadaw.view.empleado to javafx.fxml;
    opens es.etg.daw.prog.mercadaw.view.compra to javafx.fxml;
    opens es.etg.daw.prog.mercadaw.view.sistema to javafx.fxml;
}
