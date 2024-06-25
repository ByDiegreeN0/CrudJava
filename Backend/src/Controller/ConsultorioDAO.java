import Model.Consultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.gson;

public class ConsultorioDAO {

    private Connection conexion;

    // Constructor que recibe la conexión a la base de datos
    public ConsultorioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un nuevo consultorio
    public boolean insertarConsultorio(Consultorio consultorio) {
        String query = "INSERT INTO consultorios (ConNumero, ConNombre) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, consultorio.getConNumero());
            stmt.setString(2, consultorio.getConNombre());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar un consultorio existente
    public boolean actualizarConsultorio(Consultorio consultorio) {
        String query = "UPDATE consultorios SET ConNombre = ? WHERE ConNumero = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, consultorio.getConNombre());
            stmt.setInt(2, consultorio.getConNumero());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un consultorio
    public boolean eliminarConsultorio(int conNumero) {
        String query = "DELETE FROM consultorios WHERE ConNumero = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, conNumero);

            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todos los consultorios
    public List<Consultorio> listarConsultorios() {
        List<Consultorio> listaConsultorios = new ArrayList<>();
        String query = "SELECT * FROM consultorios";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Consultorio consultorio = new Consultorio();
                consultorio.setConNumero(rs.getInt("ConNumero"));
                consultorio.setConNombre(rs.getString("ConNombre"));
                listaConsultorios.add(consultorio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaConsultorios;
    }

    // Método para obtener un consultorio por su número
    public Consultorio buscarConsultorio(int conNumero) {
        String query = "SELECT * FROM consultorios WHERE ConNumero = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, conNumero);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Consultorio consultorio = new Consultorio();
                consultorio.setConNumero(rs.getInt("ConNumero"));
                consultorio.setConNombre(rs.getString("ConNombre"));
                return consultorio;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
