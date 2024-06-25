package Model;

import java.util.Date;

public class Cita {
    private int citNumero;
    private Date citFecha;
    private String citHora;
    private String citPaciente;
    private String citMedico;
    private int citConsultorio;
    private String citEstado;

    public int getCitNumero() {
        return citNumero;
    }

    public void setCitNumero(int citNumero) {
        this.citNumero = citNumero;
    }

    public Date getCitFecha() {
        return citFecha;
    }

    public void setCitFecha(Date citFecha) {
        this.citFecha = citFecha;
    }

    public String getCitHora() {
        return citHora;
    }

    public void setCitHora(String citHora) {
        this.citHora = citHora;
    }

    public String getCitPaciente() {
        return citPaciente;
    }

    public void setCitPaciente(String citPaciente) {
        this.citPaciente = citPaciente;
    }

    public String getCitMedico() {
        return citMedico;
    }

    public void setCitMedico(String citMedico) {
        this.citMedico = citMedico;
    }

    public int getCitConsultorio() {
        return citConsultorio;
    }

    public void setCitConsultorio(int citConsultorio) {
        this.citConsultorio = citConsultorio;
    }

    public String getCitEstado() {
        return citEstado;
    }

    public void setCitEstado(String citEstado) {
        this.citEstado = citEstado;
    }
}
