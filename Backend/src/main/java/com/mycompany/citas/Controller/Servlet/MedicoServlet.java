package com.mycompany.citas.Controller.Servlet;



import com.mycompany.citas.Model.Medico;
import com.mycompany.citas.Model.MySQL;
import com.mycompany.citas.Controller.MedicoDAO;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/medicos")
public class MedicoServlet extends HttpServlet {

    private MySQL mysql;
    private MedicoDAO medicoDAO;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        mysql = new MySQL();
        medicoDAO = new MedicoDAO(mysql.getConnection());
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Medico> medicos = medicoDAO.listarMedicos();
        String medicosJson = gson.toJson(medicos);

        PrintWriter out = response.getWriter();
        out.print(medicosJson);
        out.flush();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String Nombre = request.getParameter("Nombre");
        String Apellido = request.getParameter("Apellido");

        Medico medico = new Medico();

        medico.setMedNombres(Nombre);
        medico.setMedApellidos(Apellido);

        boolean success = MedicoDAO.insertarMedico(medico);

        PrintWriter out = response.getWriter();
        out.print("{\"success\"}: " + success + "}");
        out.flush();
    }

       
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String Nombre = request.getParameter("Nombre");
        String Apellido = request.getParameter("Apellido");

        Medico medico = new Medico();

        // seguir cod

        boolean success = MedicoDAO.actualizarMedico(medico);

        PrintWriter out = response.getWriter();
        out.print("{\"success\"}: " + success + "}");
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        int medIdentificacion = Integer.parseInt(request.getParameter("medIdentificacion"));
        boolean success = MedicoDAO.eliminarMedico(medIdentificacion);

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
