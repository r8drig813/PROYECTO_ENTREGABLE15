package com.example.proyecto_iweb.controllers;

import com.example.proyecto_iweb.models.daos.CuentasDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "UsuarioAdminServlet", value = {"/UsuarioAdminServlet"})
public class UsuarioAdminServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        CuentasDaos usuarioRandV = new CuentasDaos();

        request.setAttribute("lista",usuarioRandV.compradosAndReservados());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/reservasYcomprados.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
