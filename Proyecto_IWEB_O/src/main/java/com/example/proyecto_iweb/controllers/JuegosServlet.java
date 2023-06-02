package com.example.proyecto_iweb.controllers;

import java.io.*;

import com.example.proyecto_iweb.models.beans.Juegos;
import com.example.proyecto_iweb.models.daos.CuentasDaos;
import com.example.proyecto_iweb.models.daos.JuegosDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "JuegosServlet", value = "/JuegosServlet")
public class JuegosServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        JuegosDaos juegosDaos = new JuegosDaos();
        CuentasDaos cuentasDaos = new CuentasDaos();


        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        switch (action) {
            case "listar":
                request.setAttribute("lista", juegosDaos.listarJuegos());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("usuario/indexUsuarioOficial.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "listar1":
                request.setAttribute("lista", juegosDaos.listarJuegos());
                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("usuario/postearUsuariosOficial.jsp");
                requestDispatcher1.forward(request, response);
                break;
            case "verjuego":
                int juegoId = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("juegos", juegosDaos.listar(juegoId));
                request.getRequestDispatcher("usuario/verJuego.jsp").forward(request, response);
                break;
            case "nuevos":
                request.setAttribute("nuevos", juegosDaos.listarnuevos());
                request.getRequestDispatcher("admin/juegosNuevosAdminOficial.jsp").forward(request, response);
                break;
            case "existentes":
                request.setAttribute("existentes", juegosDaos.listarexistentes());
                request.getRequestDispatcher("admin/juegosExistentesAdminOficial.jsp").forward(request, response);
                break;
            case "carrito":
                int juegoId1 = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("juegos", juegosDaos.listar(juegoId1));
                request.getRequestDispatcher("usuario/carrito.jsp").forward(request, response);
                break;
            case "listarcola":
                request.setAttribute("lista", juegosDaos.listarCola());
                RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("admin/juegosColaAdminOficial.jsp");
                requestDispatcher2.forward(request, response);
                break;
            case "vendidos":
                request.setAttribute("lista2", juegosDaos.listarVendidos());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.getRequestDispatcher("usuario/vendidosUsuariosOficial.jsp").forward(request, response);
                break;
            case "comprados":
                request.setAttribute("lista3", juegosDaos.listarComprados());
                request.setAttribute("perfil", cuentasDaos.perfil());
                request.getRequestDispatcher("usuario/compradosUsuariosOficial.jsp").forward(request, response);
                break;
            case  "perfil" :
                String id = request.getParameter("id");
                request.setAttribute("cuentas",cuentasDaos.listar(id));
                request.getRequestDispatcher("usuario/miPerfilOficial.jsp").forward(request, response);
                break;

            case "listarJuegos":
                request.setAttribute("lista",juegosDaos.listarJuegosDisponibles());
                request.getRequestDispatcher("admin/indexAdmin.jsp").forward(request,response);
                break;
            case "listarofertas":
                request.setAttribute("ofertas",juegosDaos.listarOfertas());
                request.getRequestDispatcher("admin/ofertasJuegos.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("p") == null ? "crear" : request.getParameter("p");

        JuegosDaos juegosDaos = new JuegosDaos();

        switch (action) {
            case "b":
                String textoBuscar = request.getParameter("textoBuscar");
                request.setAttribute("lista", juegosDaos.buscarPorTitle(textoBuscar));
                request.getRequestDispatcher("usuario/postearUsuariosOficial.jsp").forward(request, response);
                break;
            case "b1":
                String textoBuscar1 = request.getParameter("buscador");
                request.setAttribute("lista", juegosDaos.buscarPorTitle(textoBuscar1));
                request.getRequestDispatcher("usuario/indexUsuarioOficial.jsp").forward(request, response);
                break;

        }

    }
}
