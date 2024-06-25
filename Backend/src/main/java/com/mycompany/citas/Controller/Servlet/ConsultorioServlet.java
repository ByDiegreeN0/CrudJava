package com.mycompany.citas.Controller.Servlet;

import com.mycompany.citas.Controller.ConsultorioDAO;
import com.mycompany.citas.Controller.PacienteDAO;
import com.mycompany.citas.Model.Consultorio;
import com.mycompany.citas.Model.MySQL;
import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/consultorios")

public class ConsultorioServlet  extends HttpServlet{

    private MySQL mysql;
    private ConsultorioDAO ConsultorioDAO;
    private Gson gson;
    
    // PA Q EL VIEJO JASON LA SIGA :D
}

