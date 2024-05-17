module es.etg.daw.prog.mercadaw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.poi.ooxml;
    requires javafx.graphics;

    opens es.etg.daw.prog.mercadaw to javafx.fxml;
    exports es.etg.daw.prog.mercadaw;
}
