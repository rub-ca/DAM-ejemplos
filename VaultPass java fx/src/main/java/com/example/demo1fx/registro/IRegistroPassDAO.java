package com.example.demo1fx.registro;

import java.util.ArrayList;

public interface IRegistroPassDAO {
    ArrayList<RegistroPass> selectAll();

    RegistroPass selectById(int buscando);

    boolean insertNew(RegistroPass registro);

    boolean deleteById(int buscando);

    boolean updateById(RegistroPass datosNuevos, int id);

}
