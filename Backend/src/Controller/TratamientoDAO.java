import Model.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.gson;




public class TratamientoDAO {
    
    private Connection connection;

    public TratamientoDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(Tratamiento tratamiento) {
        String sql = "INSERT INTO tratamiento (traNumero, traFechaAsignado, traDescripcion, traFechaInicio, traFechaFin, traObservaciones, traPaciente) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, tratamiento.getTraNumero());
            statement.setDate(2, new java.sql.Date(tratamiento.getTraFechaAsignado().getTime()));
            statement.setString(3, tratamiento.getTraDescripcion());
            statement.setDate(4, new java.sql.Date(tratamiento.getTraFechaInicio().getTime()));
            statement.setDate(5, new java.sql.Date(tratamiento.getTraFechaFin().getTime()));
            statement.setString(6, tratamiento.getTraObservaciones());
            statement.setString(7, tratamiento.getTraPaciente());
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Tratamiento tratamiento) {
        String sql = "UPDATE tratamiento SET traFechaAsignado=?, traDescripcion=?, traFechaInicio=?, traFechaFin=?, traObservaciones=?, traPaciente=? " +
                     "WHERE traNumero=?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(tratamiento.getTraFechaAsignado().getTime()));
            statement.setString(2, tratamiento.getTraDescripcion());
            statement.setDate(3, new java.sql.Date(tratamiento.getTraFechaInicio().getTime()));
            statement.setDate(4, new java.sql.Date(tratamiento.getTraFechaFin().getTime()));
            statement.setString(5, tratamiento.getTraObservaciones());
            statement.setString(6, tratamiento.getTraPaciente());
            statement.setInt(7, tratamiento.getTraNumero());
            
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int traNumero) {
        String sql = "DELETE FROM tratamiento WHERE traNumero=?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, traNumero);
            
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Tratamiento> getAll() {
        List<Tratamiento> tratamientos = new ArrayList<>();
        String sql = "SELECT * FROM tratamiento";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setTraNumero(resultSet.getInt("traNumero"));
                tratamiento.setTraFechaAsignado(resultSet.getDate("traFechaAsignado"));
                tratamiento.setTraDescripcion(resultSet.getString("traDescripcion"));
                tratamiento.setTraFechaInicio(resultSet.getDate("traFechaInicio"));
                tratamiento.setTraFechaFin(resultSet.getDate("traFechaFin"));
                tratamiento.setTraObservaciones(resultSet.getString("traObservaciones"));
                tratamiento.setTraPaciente(resultSet.getString("traPaciente"));
                
                tratamientos.add(tratamiento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tratamientos;
    }
}
