package com.mycompany.citas.Controller;
import com.mycompany.citas.Model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private Connection connection;

    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(Paciente paciente){
        String sql = "INSERT INTO paciente (pacIdentificacion, pacNombres, pacApellidos, pacFechaNacimiento, pacSexo)" + "VALUES (?,?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, paciente.getPacIdentificacion());
            statement.setString(2, paciente.getPacNombres());
            statement.setString(3, paciente.getPacApellidos());
            statement.setDate(4, new java.sql.Date(paciente.getPacFechaNacimiento().getTime()));
            statement.setString(5, paciente.getPacSexo());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }   

    public boolean update(Paciente Paciente){
        String sql = "UPDATE paciente SET pacNombres=?, pacApellidos=?, pacFechaNacimiento=?, pacSexo=? " + "WHERE pacIdentificacion = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, paciente.getPacNombres());
            statement.setString(2, paciente.getPacApellidos());
            statement.setDate(3, new java.sql.Date(paciente.getPacFechaNacimiento().getTime()));
            statement.setString(4, paciente.getPacSexo());
            statement.setString(5, paciente.getPacIdentificacion());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String pacIdentificacion) {
        String sql = "DELETE FROM paciente WHERE pacIdentificacion=?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pacIdentificacion);
            
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Paciente> getAll() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setPacIdentificacion(resultSet.getString("pacIdentificacion"));
                paciente.setPacNombres(resultSet.getString("pacNombres"));
                paciente.setPacApellidos(resultSet.getString("pacApellidos"));
                paciente.setPacFechaNacimiento(resultSet.getDate("pacFechaNacimiento"));
                paciente.setPacSexo(resultSet.getString("pacSexo"));
                
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return pacientes;
    }
}

