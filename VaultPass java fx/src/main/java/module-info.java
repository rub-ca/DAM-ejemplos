module com.example.demo1fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo1fx to javafx.fxml;
    exports com.example.demo1fx;
    exports com.example.demo1fx.controladores;
    opens com.example.demo1fx.controladores to javafx.fxml;
    exports com.example.demo1fx.registro;
    opens com.example.demo1fx.registro to javafx.fxml;
}