package com.mycompany.citas.Controller.Servlet;

import com.mycompany.citas.Model.Tratamiento;
import com.mycompany.citas.Model.MySQL;
import com.google.gson.Gson;
import com.mycompany.citas.Controller.TratamientoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/tratamientos")
public class TratamientoServlet extends HttpServlet {

    private MySQL mysql;
    private TratamientoDAO tratamientoDAO;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        mysql = new MySQL();
        tratamientoDAO = new TratamientoDAO(mysql.getConnection());
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Tratamiento> tratamientos = tratamientoDAO.getAll();
        String tratamientosJson = gson.toJson(tratamientos);

        PrintWriter out = response.getWriter();
        out.print(tratamientosJson);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Tratamiento tratamiento = gson.fromJson(request.getReader(), Tratamiento.class);
        boolean success = tratamientoDAO.insert(tratamiento);

        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Tratamiento tratamiento = gson.fromJson(request.getReader(), Tratamiento.class);
        boolean success = tratamientoDAO.update(tratamiento);

        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        int traNumero = Integer.parseInt(request.getParameter("traNumero"));
        boolean success = tratamientoDAO.delete(traNumero);

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
