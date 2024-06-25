package com.mycompany.citas.Controller;
import com.mycompany.citas.Model.Paciente;
import java.sql.Connection;


public class PacienteDAO {
      private Connection connection;

    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }
}

