package com.example.demo1fx.controladores;

import com.example.demo1fx.Main;
import com.example.demo1fx.registro.RegistroPass;
import com.example.demo1fx.registro.RegistroPassJDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladorTabla implements Initializable {
    @FXML
    private Button botonCrearContra;

    @FXML
    private Button botonEditarContra;

    @FXML
    private Button botonEliminarContra;

    @FXML
    private Button botonVerContra;

    @FXML
    private TableColumn<RegistroPass, String> columnaId;

    @FXML
    private TableColumn<RegistroPass, String> columnaNombre;

    @FXML
    private TableColumn<RegistroPass, String> columnaSitio;

    @FXML
    private Pane panelMain;

    @FXML
    private TableView<RegistroPass> tablaView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("HelloController -> initialize()..."); // LOG

        columnaId.setCellValueFactory(new PropertyValueFactory<RegistroPass, String>("id"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<RegistroPass, String>("nombre"));
        columnaSitio.setCellValueFactory(new PropertyValueFactory<RegistroPass, String>("sitio"));

        ArrayList<RegistroPass> array = Main.conexionJDBC.selectAll();
        tablaView.getItems().addAll(array);
    }

    @FXML
    void onClickCrearContra(ActionEvent event) throws IOException {
        // Cambiamos de escena
        Stage stage = (Stage) botonEditarContra.getScene().getWindow();
        Parent root = FXMLLoader.load(Main.class.getResource("crear.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(430);
        stage.setHeight(300);
        stage.show();
    }

    @FXML
    void onClickEditarContra(ActionEvent event) throws IOException {
        // Cambiamos de escena
        Stage stage = (Stage) botonEditarContra.getScene().getWindow();
        Parent root = FXMLLoader.load(Main.class.getResource("editar.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(435);
        stage.setHeight(350);
        stage.show();
    }

    @FXML
    void onClickEliminarContra(ActionEvent event) throws IOException {
        if (tablaView.getSelectionModel().getSelectedItem() != null) {
            RegistroPass registroABorrar = (RegistroPass) tablaView.getSelectionModel().getSelectedItem();
            Main.conexionJDBC.deleteById(registroABorrar.id);

            // Recargamos la misma escena
            Stage stage = (Stage) botonEditarContra.getScene().getWindow();
            Parent root = FXMLLoader.load(Main.class.getResource("tabla.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setWidth(500);
            stage.setHeight(420);
            stage.show();
        }
    }

    @FXML
    void onClickVerContra(ActionEvent event) throws IOException {
        // Seleccionamos el registro que queremos mostrar
        Main.registroActual = (RegistroPass) tablaView.getSelectionModel().getSelectedItem();

        // Cambiamos de escena
        Stage stage = (Stage) botonEditarContra.getScene().getWindow();
        Parent root = FXMLLoader.load(Main.class.getResource("ver.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(280);
        stage.setHeight(200);
        stage.show();
    }


}