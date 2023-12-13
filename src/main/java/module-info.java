module com.example.warenkorb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.warenkorb to javafx.fxml;
    exports com.example.warenkorb;
}