package com.example.proyecto_iweb.controllers;

import com.example.proyecto_iweb.models.daos.CuentasDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UsuarioManagerServlet", value = "/usuarioManager")
public class UsuarioManagerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        CuentasDaos employeeDao = new CuentasDaos();
        request.setAttribute("listaUsuarios",employeeDao.listarCuentasUsuarios());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("indexManagerOficial.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
