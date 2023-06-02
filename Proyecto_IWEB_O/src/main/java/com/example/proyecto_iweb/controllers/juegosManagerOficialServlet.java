package com.example.proyecto_iweb.controllers;

import com.example.proyecto_iweb.models.daos.JuegosDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "JuegosManagerServlet", value = "/JuegosManager")
public class juegosManagerOficialServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        JuegosDaos juegosDaos = new JuegosDaos();

        request.setAttribute("juegosManager", juegosDaos.listarJuegos());
        request.getRequestDispatcher("manager/juegosManagerOficial.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
