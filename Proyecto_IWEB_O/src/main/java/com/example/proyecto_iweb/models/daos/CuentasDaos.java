package com.example.proyecto_iweb.models.daos;

import com.example.proyecto_iweb.models.beans.Cuentas;

import java.sql.*;
import java.util.ArrayList;

public class CuentasDaos {
    public ArrayList<Cuentas> listarCuentas(){
        ArrayList<Cuentas> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cuentas";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Cuentas cuentas = new Cuentas();
                cuentas.setIdCuentas(resultSet.getInt(1));
                cuentas.setNombre(resultSet.getString(2));
                cuentas.setApellido(resultSet.getString(3));
                cuentas.setNickname(resultSet.getString(4));
                cuentas.setDirecion(resultSet.getString(5));
                cuentas.setCorreo(resultSet.getString(6));
                cuentas.setContrasenia(resultSet.getString(7));
                cuentas.setFoto(resultSet.getBlob(8));
                cuentas.setDescripcion(resultSet.getString(9));
                cuentas.setDesabilitado(resultSet.getBoolean(10));
                lista.add(cuentas);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public ArrayList<Cuentas> listarCuentasEmpleados(){
        ArrayList<Cuentas> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cuentas where Roles_idRoles = '2';";
        String url = "jdbc:mysql://localhost:3306/sys";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Cuentas cuentas = new Cuentas();
                cuentas.setIdCuentas(resultSet.getInt(1));
                cuentas.setNombre(resultSet.getString(2));
                cuentas.setApellido(resultSet.getString(3));
                cuentas.setNickname(resultSet.getString(4));
                cuentas.setDirecion(resultSet.getString(5));
                cuentas.setCorreo(resultSet.getString(6));
                cuentas.setContrasenia(resultSet.getString(7));
                cuentas.setFoto(resultSet.getBlob(8));
                cuentas.setDescripcion(resultSet.getString(9));
                cuentas.setDesabilitado(resultSet.getBoolean(10));
                lista.add(cuentas);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public ArrayList<Cuentas> listarCuentasUsuarios(){
        ArrayList<Cuentas> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cuentas where Roles_idRoles = '3'";
        String url = "jdbc:mysql://localhost:3306/sys";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Cuentas cuentas = new Cuentas();
                cuentas.setIdCuentas(resultSet.getInt(1));
                cuentas.setNombre(resultSet.getString(2));
                cuentas.setApellido(resultSet.getString(3));
                cuentas.setNickname(resultSet.getString(4));
                cuentas.setDirecion(resultSet.getString(5));
                cuentas.setCorreo(resultSet.getString(6));
                cuentas.setContrasenia(resultSet.getString(7));
                cuentas.setFoto(resultSet.getBlob(8));
                cuentas.setDescripcion(resultSet.getString(9));
                cuentas.setDesabilitado(resultSet.getBoolean(10));
                lista.add(cuentas);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    // Listar los usuarios desde los admin
    public ArrayList<Cuentas> compradosAndReservados(){
        ArrayList<Cuentas> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql1 = "select * from cuentas where Roles_idRoles = 3";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql1)) {

            while(resultSet.next()){
                // Creación un nuevo objeto
                Cuentas usuarioRandV = new Cuentas();

                // Obtenemos los valores
                usuarioRandV.setIdCuentas(resultSet.getInt(1));
                usuarioRandV.setNombre(resultSet.getString(2));
                usuarioRandV.setApellido(resultSet.getString(3));
                usuarioRandV.setNickname(resultSet.getString(4));
                usuarioRandV.setDirecion(resultSet.getString(5));
                usuarioRandV.setCorreo(resultSet.getString(6));     // Correo
                usuarioRandV.setContrasenia(resultSet.getString(7));
                usuarioRandV.setFoto(resultSet.getBlob(8));
                usuarioRandV.setDescripcion(resultSet.getString(9));
                usuarioRandV.setDesabilitado(resultSet.getBoolean(10));
                lista.add(usuarioRandV);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public Cuentas listar(String id) {
        Cuentas cuentas = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cuentas where idCuentas = ?";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    cuentas = new Cuentas();
                    cuentas.setIdCuentas(rs.getInt(1));
                    cuentas.setNombre(rs.getString(2));
                    cuentas.setApellido(rs.getString(3));
                    cuentas.setDescripcion(rs.getString(9));
                    cuentas.setDirecion(rs.getString(5));
                    cuentas.setCorreo(rs.getString(6));
                    cuentas.setNickname(rs.getString(4));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cuentas;
    }

    public void actualizar(Cuentas cuentas) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "UPDATE cuentas SET descripcion= ?,direcion = ?,correo = ? WHERE idCuentas = ?";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, cuentas.getDescripcion());
            pstmt.setString(2, cuentas.getDirecion());
            pstmt.setString(3,cuentas.getCorreo());
            pstmt.setInt(4, cuentas.getIdCuentas());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Cuentas> perfil(){
        ArrayList<Cuentas> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM cuentas where idCuentas = 101 and Roles_idRoles = 3";
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Cuentas cuentas = new Cuentas();
                cuentas.setIdCuentas(resultSet.getInt(1));
                cuentas.setNombre(resultSet.getString(2));
                cuentas.setApellido(resultSet.getString(3));
                cuentas.setNickname(resultSet.getString(4));
                cuentas.setDirecion(resultSet.getString(5));
                cuentas.setCorreo(resultSet.getString(6));
                cuentas.setContrasenia(resultSet.getString(7));
                cuentas.setFoto(resultSet.getBlob(8));
                cuentas.setDescripcion(resultSet.getString(9));
                cuentas.setDesabilitado(resultSet.getBoolean(10));
                lista.add(cuentas);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }
}

