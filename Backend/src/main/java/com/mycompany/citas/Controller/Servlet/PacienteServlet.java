package com.mycompany.citas.Controller.Servlet;

import com.mycompany.citas.Controller.PacienteDAO;
import com.mycompany.citas.Model.Paciente;
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

@WebServlet("/pacientes")
public class PacienteServlet extends HttpServlet {

    private MySQL mysql;
    private PacienteDAO pacienteDAO;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        mysql = new MySQL();
        pacienteDAO = new PacienteDAO(mysql.getConnection());
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Paciente> pacientes = pacienteDAO.getAll();
        String pacientesJson = gson.toJson(pacientes);

        PrintWriter out = response.getWriter();
        out.print(pacientesJson);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Paciente paciente = gson.fromJson(request.getReader(), Paciente.class);
        boolean success = pacienteDAO.insert(paciente);

        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Paciente paciente = gson.fromJson(request.getReader(), Paciente.class);
        boolean success = pacienteDAO.update(paciente);

        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pacIdentificacion = request.getParameter("pacIdentificacion");
        boolean success = pacienteDAO.delete(pacIdentificacion);

        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }

    @Override
    public void destroy() {
        super.destroy();
        mysql.closeConnection();
    }
}
