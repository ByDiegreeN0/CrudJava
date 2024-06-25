import Model.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    private Connection conexion;

    // Constructor que recibe la conexión a la base de datos
    public CitaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar una nueva cita
    public boolean insertarCita(Cita cita) {
        String query = "INSERT INTO citas (CitFecha, CitHora, CitPaciente, CitMedico, CitConsultorio, CitEstado) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(cita.getCitFecha().getTime()));
            stmt.setString(2, cita.getCitHora());
            stmt.setString(3, cita.getCitPaciente());
            stmt.setString(4, cita.getCitMedico());
            stmt.setInt(5, cita.getCitConsultorio());
            stmt.setString(6, cita.getCitEstado());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar una cita existente
    public boolean actualizarCita(Cita cita) {
        String query = "UPDATE citas SET CitFecha = ?, CitHora = ?, CitPaciente = ?, CitMedico = ?, " +
                "CitConsultorio = ?, CitEstado = ? WHERE CitNumero = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(cita.getCitFecha().getTime()));
            stmt.setString(2, cita.getCitHora());
            stmt.setString(3, cita.getCitPaciente());
            stmt.setString(4, cita.getCitMedico());
            stmt.setInt(5, cita.getCitConsultorio());
            stmt.setString(6, cita.getCitEstado());
            stmt.setInt(7, cita.getCitNumero());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar una cita
    public boolean eliminarCita(int citNumero) {
        String query = "DELETE FROM citas WHERE CitNumero = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, citNumero);

            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todas las citas
    public List<Cita> listarCitas() {
        List<Cita> listaCitas = new ArrayList<>();
        String query = "SELECT * FROM citas";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCitNumero(rs.getInt("CitNumero"));
                cita.setCitFecha(rs.getDate("CitFecha"));
                cita.setCitHora(rs.getString("CitHora"));
                cita.setCitPaciente(rs.getString("CitPaciente"));
                cita.setCitMedico(rs.getString("CitMedico"));
                cita.setCitConsultorio(rs.getInt("CitConsultorio"));
                cita.setCitEstado(rs.getString("CitEstado"));
                listaCitas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCitas;
    }

    // Método para obtener una cita por su número
    public Cita buscarCita(int citNumero) {
        String query = "SELECT * FROM citas WHERE CitNumero = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, citNumero);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cita cita = new Cita();
                cita.setCitNumero(rs.getInt("CitNumero"));
                cita.setCitFecha(rs.getDate("CitFecha"));
                cita.setCitHora(rs.getString("CitHora"));
                cita.setCitPaciente(rs.getString("CitPaciente"));
                cita.setCitMedico(rs.getString("CitMedico"));
                cita.setCitConsultorio(rs.getInt("CitConsultorio"));
                cita.setCitEstado(rs.getString("CitEstado"));
                return cita;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para obtener citas por paciente
    public List<Cita> buscarCitasPorPaciente(String citPaciente) {
        List<Cita> listaCitas = new ArrayList<>();
        String query = "SELECT * FROM citas WHERE CitPaciente = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, citPaciente);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCitNumero(rs.getInt("CitNumero"));
                cita.setCitFecha(rs.getDate("CitFecha"));
                cita.setCitHora(rs.getString("CitHora"));
                cita.setCitPaciente(rs.getString("CitPaciente"));
                cita.setCitMedico(rs.getString("CitMedico"));
                cita.setCitConsultorio(rs.getInt("CitConsultorio"));
                cita.setCitEstado(rs.getString("CitEstado"));
                listaCitas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCitas;
    }
}
