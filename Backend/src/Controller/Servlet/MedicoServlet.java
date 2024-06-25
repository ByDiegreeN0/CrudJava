package Controller.Servlet;

import Model.Medico;
import Model.MySQL;
import com.google.gson.Gson;
import Controller.MedicoDAO;

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
    public void destroy() {
        super.destroy();
        mysql.closeConnection();
    }
}
