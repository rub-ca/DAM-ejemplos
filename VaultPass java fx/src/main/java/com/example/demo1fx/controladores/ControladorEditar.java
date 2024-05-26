package com.example.demo1fx.controladores;

import borrarAlFinal.CifradorAES;
import com.example.demo1fx.Main;
import com.example.demo1fx.registro.RegistroPass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorEditar {

    @FXML
    private Button botonCrear;

    @FXML
    private Button botonVolver;

    @FXML
    private TextField cajaNombre;

    @FXML
    private TextField cajaPass;

    @FXML
    private TextField cajaSitio;

    @FXML
    private Text textoId;

    @FXML
    void onClickModificar(ActionEvent event) throws IOException {
        String contraNuevaCifrada = "";
        if (!cajaPass.getText().isEmpty()) {
            contraNuevaCifrada = new CifradorAES().encrypt(cajaPass.getText(), Main.name);
        }

        RegistroPass regDatos = new RegistroPass(-1, cajaNombre.getText(), cajaSitio.getText(), contraNuevaCifrada);
        Main.conexionJDBC.updateById(regDatos,1);

        Stage stage = (Stage) botonCrear.getScene().getWindow();
        Parent root = FXMLLoader.load(Main.class.getResource("tabla.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(420);
        stage.show();
    }

    @FXML
    void onClickVolver(ActionEvent event) throws IOException {
        Stage stage = (Stage) botonVolver.getScene().getWindow();
        Parent root = FXMLLoader.load(Main.class.getResource("tabla.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(420);
        stage.show();
    }
}
