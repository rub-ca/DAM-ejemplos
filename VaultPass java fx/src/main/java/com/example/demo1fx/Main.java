package com.example.demo1fx;

import com.example.demo1fx.registro.RegistroPass;
import com.example.demo1fx.registro.RegistroPassJDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL2 = "jdbc:mysql://192.168.56.101:3306/vault?allowPublicKeyRetrieval=true&useSSL=false";
    public static final String USER = "admin";
    public static final String PASS = "admin";

    public static String name = "";

    public static RegistroPass registroActual = null;

    public static RegistroPassJDBC conexionJDBC;

    @Override
    public void start(Stage stage) throws IOException {
        conexionJDBC = new RegistroPassJDBC(Main.getConnectionToDB());
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 368, 245);
        stage.setTitle("PassValt!");
        stage.setScene(scene);
        stage.show();
        stage.setWidth(368);
        stage.setHeight(245);
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

    public static Connection getConnectionToDB() {
        try {
            return DriverManager.getConnection(DB_URL2, USER, PASS);
        } catch (SQLException e) {
            System.out.println("ERROR CREANDO LA CONEXION A LA BD");
            throw new RuntimeException(e);
        }
    }

}