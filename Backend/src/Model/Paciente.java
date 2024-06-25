package Model;

import java.util.Date;


public class Paciente {
    private String pacIdentificacion;
    private String pacNombres;
    private String pacApellidos;
    private Date pacFechaNacimiento;
    private String pacSexo;

    public String getPacIdentificacion() {
        return pacIdentificacion;
    }

    public void setPacIdentificacion(String pacIdentificacion) {
        this.pacIdentificacion = pacIdentificacion;
    }

    public String getPacNombres() {
        return pacNombres;
    }

    public void setPacNombres(String pacNombres) {
        this.pacNombres = pacNombres;
    }

    public String getPacApellidos() {
        return pacApellidos;
    }

    public void setPacApellidos(String pacApellidos) {
        this.pacApellidos = pacApellidos;
    }

    public Date getPacFechaNacimiento() {
        return pacFechaNacimiento;
    }

    public void setPacFechaNacimiento(Date pacFechaNacimiento) {
        this.pacFechaNacimiento = pacFechaNacimiento;
    }

    public String getPacSexo() {
        return pacSexo;
    }

    public void setPacSexo(String pacSexo) {
        this.pacSexo = pacSexo;
    }
}
