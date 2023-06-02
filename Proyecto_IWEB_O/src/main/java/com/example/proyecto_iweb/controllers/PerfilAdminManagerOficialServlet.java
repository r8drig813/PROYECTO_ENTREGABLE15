package com.example.proyecto_iweb.controllers;

import com.example.proyecto_iweb.models.daos.CuentasDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/Admin")
public class PerfilAdminManagerOficialServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        CuentasDaos employeeDao = new CuentasDaos();
        request.setAttribute("listaAdmin",employeeDao.listarCuentasEmpleados());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("perfilAdminManagerOficial.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
