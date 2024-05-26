package com.example.demo1fx.registro;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegistroPassJDBC implements IRegistroPassDAO {
    private static String TABLE_NAME = "registroPass";
    private static String CONSULTA_ALL = "select * from " + TABLE_NAME;
    private static String CONSULTA_DELETE = "delete from " + TABLE_NAME + " where id = ?";
    private static String CONSULTA_ADD = "insert into " + TABLE_NAME + " (nombre, sitio, contraCif) values (?, ?, ?)";

    private Connection connection;

    public RegistroPassJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<RegistroPass> selectAll() {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_ALL);
            ResultSet resultados = prepared.executeQuery();
            ArrayList<RegistroPass> retorno = new ArrayList<RegistroPass>();
            while (resultados.next()) {
                retorno.add(new RegistroPass(resultados.getInt("id"), resultados.getString("nombre"),
                        resultados.getString("sitio"), resultados.getString("contraCif")));
            }
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public RegistroPass selectById(int buscando) {
        return null;
    }

    @Override
    public boolean insertNew(RegistroPass registro) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_ADD);
            prepared.setString(1, registro.nombre);
            prepared.setString(2, registro.sitio);
            prepared.setString(3, registro.contraCifrada);
            prepared.executeUpdate();
            System.out.println("NUEVOOO!!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(int buscando) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_DELETE);
            prepared.setInt(1, buscando);
            prepared.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateById(RegistroPass datosNuevos, int id) {
        System.out.println("DATOS:");
        System.out.println(datosNuevos);
        return false;
    }
}
