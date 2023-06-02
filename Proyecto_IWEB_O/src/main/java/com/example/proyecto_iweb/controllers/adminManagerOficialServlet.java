package com.example.proyecto_iweb.controllers;

import com.example.proyecto_iweb.models.daos.CuentasDaos;
import com.example.proyecto_iweb.models.daos.EmpleadosTablaDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EmpleadosServlet", value = "/empleados")
public class adminManagerOficialServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        EmpleadosTablaDaos employeeDao = new EmpleadosTablaDaos();
        request.setAttribute("listaEmpleados",employeeDao.listarEmpleados());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/adminManagerOficial.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}