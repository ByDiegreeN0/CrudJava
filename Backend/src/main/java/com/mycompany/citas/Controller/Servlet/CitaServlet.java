package com.mycompany.citas.Controller.Servlet;

import com.mycompany.citas.Controller.CitaDAO;
import com.mycompany.citas.Model.Cita;
import com.mycompany.citas.Model.MySQL;
// import com.mycompany.citas.Model.Tratamiento;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Date;
// import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;  



@WebServlet("/citas")

public class CitaServlet extends HttpServlet {

    private MySQL mysql;
    private CitaDAO CitaDAO;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        mysql = new MySQL();
        CitaDAO = new CitaDAO(mysql.getConnection());
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Obtiene el parámetro "citNumero" de la solicitud HTTP
        String citNumeroParam = request.getParameter("citNumero");
        // Obtiene el parámetro "citPaciente" de la solicitud HTTP
        String citPacienteParam = request.getParameter("citPaciente");

        List<Cita> citas;
        if (citNumeroParam != null) {
            int citNumero = Integer.parseInt(citNumeroParam);
            Cita cita = CitaDAO.buscarCita(citNumero);
            citas = cita != null ? Collections.singletonList(cita) : Collections.emptyList();
        } else if (citPacienteParam != null) {
            citas = CitaDAO.buscarCitasPorPaciente(citPacienteParam);
        } else {
            citas = CitaDAO.listarCitas();
        }

        String citasJson = gson.toJson(citas);

        PrintWriter out = response.getWriter();
        out.print(citasJson);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date Date = null;
        try {
                Date = format.parse(request.getParameter("FechaDeLacita"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String Time =  request.getParameter("CitaFecha");
        String Paciente =  request.getParameter("Paciente");
        String Medico =  request.getParameter("Medico");
    
        int Consultorio = Integer.parseInt(request.getParameter("Consultorio"));
        String Estado =  request.getParameter("Estado");

        Cita cita = new Cita();

        cita.setCitFecha(Date);
        cita.setCitHora(Time);
        cita.setCitPaciente(Paciente);
        cita.setCitMedico(Medico);
        cita.setCitConsultorio(Consultorio);
        cita.setCitEstado(Estado);

        boolean success = CitaDAO.insertarCita(cita);

        PrintWriter out = response.getWriter();
        out.print("{\"success\"}: " + success + "}");
        out.flush();

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

       
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        int citNumero = Integer.parseInt(request.getParameter("citNumero"));

        boolean success = CitaDAO.eliminarCita(citNumero);

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
