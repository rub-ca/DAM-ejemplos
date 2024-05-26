package com.example.demo1fx.controladores;

import borrarAlFinal.DescifradorAES;
import com.example.demo1fx.Main;
import com.example.demo1fx.registro.RegistroPass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVer implements Initializable {
    @FXML
    private Button botonVolver;

    @FXML
    private Text textoContra;

    @FXML
    private Text textoId;

    @FXML
    private Text textoNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("ControladorVer -> initialize()..."); // LOG

        textoId.setText("Id: " + Main.registroActual.id);
        textoNombre.setText(Main.registroActual.nombre);
        textoContra.setText(new DescifradorAES().decrypt(Main.registroActual.contraCifrada, Main.name));
    }

    @FXML
    void botonVolverOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) botonVolver.getScene().getWindow();
        Parent root = FXMLLoader.load(Main.class.getResource("tabla.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(420);
        stage.show();
    }


}
