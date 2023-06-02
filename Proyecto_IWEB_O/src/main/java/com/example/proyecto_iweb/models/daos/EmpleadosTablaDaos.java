package com.example.proyecto_iweb.models.daos;

import com.example.proyecto_iweb.models.beans.Cuentas;
import com.example.proyecto_iweb.models.beans.EmpleadosTabla;

import java.sql.*;
import java.util.ArrayList;

public class EmpleadosTablaDaos {
    public ArrayList<EmpleadosTabla> listarEmpleados(){
        ArrayList<EmpleadosTabla> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "SELECT concat(c.nombre, ' ', c.apellido) as Nombre_completo,\n" +
                "       COALESCE(v.juegos_vendidos, 0) AS juegos_vendidos,\n" +
                "       COALESCE(cj.juegos_comprados, 0) AS juegos_comprados,\n" +
                "       COALESCE(v.dinero_ganado, 0) AS dinero_ganado,\n" +
                "       COALESCE(cj.dinero_gastado, 0) AS dinero_gastado,\n" +
                "       (COALESCE(v.dinero_ganado, 0) - COALESCE(cj.dinero_gastado, 0)) AS Balance\n" +
                "FROM Cuentas c\n" +
                "LEFT JOIN (\n" +
                "    SELECT chc.Cuentas_idCuentas,\n" +
                "           COUNT(*) AS juegos_vendidos,\n" +
                "           SUM(cv.precio_total) AS dinero_ganado\n" +
                "    FROM Compras_ventas_has_Cuentas chc\n" +
                "    JOIN Compras_ventas cv ON chc.Compras_ventas_idCompras_ventas = cv.idCompras_ventas\n" +
                "    WHERE cv.compra_o_venta = 1 -- Ventas\n" +
                "      AND cv.Estados_idEstados = 2 -- Estados_idEstados = 2\n" +
                "    GROUP BY chc.Cuentas_idCuentas\n" +
                ") v ON c.idCuentas = v.Cuentas_idCuentas\n" +
                "LEFT JOIN (\n" +
                "    SELECT chc.Cuentas_idCuentas,\n" +
                "           COUNT(*) AS juegos_comprados,\n" +
                "           SUM(cv.precio_total) AS dinero_gastado\n" +
                "    FROM Compras_ventas_has_Cuentas chc\n" +
                "    JOIN Compras_ventas cv ON chc.Compras_ventas_idCompras_ventas = cv.idCompras_ventas\n" +
                "    WHERE cv.compra_o_venta = 0 -- Compras\n" +
                "      AND cv.Estados_idEstados = 2 -- Estados_idEstados = 2\n" +
                "    GROUP BY chc.Cuentas_idCuentas\n" +
                ") cj ON c.idCuentas = cj.Cuentas_idCuentas\n" +
                "WHERE c.Roles_idRoles = 2 -- id_roles = 2\n" +
                "ORDER BY Balance DESC;";

        String sql = query;
        String url = "jdbc:mysql://localhost:3306/mydb";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                EmpleadosTabla empleadosTabla = new EmpleadosTabla();
                empleadosTabla.setNombre(resultSet.getString(1));
                empleadosTabla.setJuegosVendidos(resultSet.getInt(2));
                empleadosTabla.setJuegosComprados(resultSet.getInt(3));
                empleadosTabla.setDineroGanado(resultSet.getDouble(4));
                empleadosTabla.setDineroGastado(resultSet.getDouble(5));
                empleadosTabla.setBalance(resultSet.getDouble(6));

                lista.add(empleadosTabla);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }


}

