package com.example.demo1fx.controladores;

import com.example.demo1fx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import java.io.IOException;

public class ControladorLogin {
    @FXML
    private Button botonVolver;

    @FXML
    private PasswordField campoPass;

    @FXML
    void onClickBotonVolver(ActionEvent event) throws IOException {
        Main.name = campoPass.getText();
        Stage stage = (Stage) botonVolver.getScene().getWindow();
        Parent root = FXMLLoader.load(Main.class.getResource("tabla.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(420);
        stage.show();
    }
}
