import Model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    private Connection conexion;


    public MedicoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean insertarMedico(Medico medico) {
        String query = "INSERT INTO medicos (MedIdentificacion, MedNombres, MedApellidos) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, medico.getMedIdentificacion());
            stmt.setString(2, medico.getMedNombres());
            stmt.setString(3, medico.getMedApellidos());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean actualizarMedico(Medico medico) {
        String query = "UPDATE medicos SET MedNombres = ?, MedApellidos = ? WHERE MedIdentificacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, medico.getMedNombres());
            stmt.setString(2, medico.getMedApellidos());
            stmt.setString(3, medico.getMedIdentificacion());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarMedico(String medIdentificacion) {
        String query = "DELETE FROM medicos WHERE MedIdentificacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, medIdentificacion);

            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Medico> listarMedicos() {
        List<Medico> listaMedicos = new ArrayList<>();
        String query = "SELECT * FROM medicos";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setMedIdentificacion(rs.getString("MedIdentificacion"));
                medico.setMedNombres(rs.getString("MedNombres"));
                medico.setMedApellidos(rs.getString("MedApellidos"));
                listaMedicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMedicos;
    }

    public Medico buscarMedico(String medIdentificacion) {
        String query = "SELECT * FROM medicos WHERE MedIdentificacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, medIdentificacion);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Medico medico = new Medico();
                medico.setMedIdentificacion(rs.getString("MedIdentificacion"));
                medico.setMedNombres(rs.getString("MedNombres"));
                medico.setMedApellidos(rs.getString("MedApellidos"));
                return medico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
