package com.mycompany.citas.Controller.Servlet;

import com.mycompany.citas.Controller.ConsultorioDAO;
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
public class ConsultorioServlet extends HttpServlet {

    private MySQL mysql;
    private ConsultorioDAO consultorioDAO;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        mysql = new MySQL();
        consultorioDAO = new ConsultorioDAO(mysql.getConnection());
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Consultorio> consultorios = consultorioDAO.listarConsultorios();
        String consultoriosJson = gson.toJson(consultorios);

        PrintWriter out = response.getWriter();
        out.print(consultoriosJson);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Consultorio consultorio = gson.fromJson(request.getReader(), Consultorio.class);
        boolean success = consultorioDAO.insertarConsultorio(consultorio);

        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Consultorio consultorio = gson.fromJson(request.getReader(), Consultorio.class);
        boolean success = consultorioDAO.actualizarConsultorio(consultorio);

        PrintWriter out = response.getWriter();
        out.print("{\"success\": " + success + "}");
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        int conNumero = Integer.parseInt(request.getParameter("conNumero"));
        boolean success = consultorioDAO.eliminarConsultorio(conNumero);

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
