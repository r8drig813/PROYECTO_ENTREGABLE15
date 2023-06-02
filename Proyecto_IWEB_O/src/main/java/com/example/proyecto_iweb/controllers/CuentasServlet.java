package com.example.proyecto_iweb.controllers;

import java.io.*;

import com.example.proyecto_iweb.models.beans.Cuentas;
import com.example.proyecto_iweb.models.daos.CuentasDaos;
import com.example.proyecto_iweb.models.daos.JuegosDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CuentasServlet", value = "/CuentasServlet")
public class CuentasServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        CuentasDaos cuentasDaos = new CuentasDaos();
        JuegosDaos juegosDaos = new JuegosDaos();

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch (action) {
            case  "perfil" :
                String id = request.getParameter("id");
                request.setAttribute("cuentas",cuentasDaos.listar(id));
                request.getRequestDispatcher("usuario/miPerfilOficial.jsp").forward(request, response);
                break;
            case "listar":
                request.setAttribute("listar1", juegosDaos.listarJuegos());
                request.setAttribute("perfil", cuentasDaos.perfil());

                request.getRequestDispatcher("usuario/indexUsuarioOficial.jsp").forward(request, response);
                break;
            case "vendidos":
                request.setAttribute("listar2", juegosDaos.listarVendidos());
                request.setAttribute("perfil", cuentasDaos.perfil());

                request.getRequestDispatcher("usuario/vendidosUsuariosOficial.jsp").forward(request, response);
                break;
            case "comprados":
                request.setAttribute("listar3", juegosDaos.listarComprados());
                request.setAttribute("perfil", cuentasDaos.perfil());

                request.getRequestDispatcher("usuario/compradosUsuariosOficial.jsp").forward(request, response);
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("p") == null ? "crear" : request.getParameter("p");

        CuentasDaos cuentasDaos = new CuentasDaos();

        switch (action) {
            case "a":
                Cuentas cuentas = parseCuentas(request);
                cuentasDaos.actualizar(cuentas);
                response.sendRedirect(request.getContextPath() + "/JuegosServlet");
                break;
        }
    }

    public Cuentas parseCuentas(HttpServletRequest request) {

        Cuentas cuentas = new Cuentas();
        String idCuentas = request.getParameter("idCuentas") != null ? request.getParameter("idCuentas") : "";
        String descripcion = request.getParameter("descripcion");
        String direcion = request.getParameter("direcion");
        String correo = request.getParameter("correo");

        try {

            int id = Integer.parseInt(idCuentas);

            cuentas.setIdCuentas(id);
            cuentas.setDescripcion(descripcion);
            cuentas.setDirecion(direcion);
            cuentas.setCorreo(correo);

            return cuentas;

        } catch (NumberFormatException e) {

        }
        return cuentas;
    }
}
