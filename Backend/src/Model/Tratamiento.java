
package Model;

import java.util.Date;


public class Tratamiento {
    private int traNumero;
    private Date traFechaAsignado;
    private String traDescripcion;
    private Date traFechaInicio;
    private Date traFechaFin;
    private String traObservaciones;
    private String traPaciente;

    public int getTraNumero() {
        return traNumero;
    }

    public void setTraNumero(int traNumero) {
        this.traNumero = traNumero;
    }

    public Date getTraFechaAsignado() {
        return traFechaAsignado;
    }

    public void setTraFechaAsignado(Date traFechaAsignado) {
        this.traFechaAsignado = traFechaAsignado;
    }

    public String getTraDescripcion() {
        return traDescripcion;
    }

    public void setTraDescripcion(String traDescripcion) {
        this.traDescripcion = traDescripcion;
    }

    public Date getTraFechaInicio() {
        return traFechaInicio;
    }

    public void setTraFechaInicio(Date traFechaInicio) {
        this.traFechaInicio = traFechaInicio;
    }

    public Date getTraFechaFin() {
        return traFechaFin;
    }

    public void setTraFechaFin(Date traFechaFin) {
        this.traFechaFin = traFechaFin;
    }

    public String getTraObservaciones() {
        return traObservaciones;
    }

    public void setTraObservaciones(String traObservaciones) {
        this.traObservaciones = traObservaciones;
    }

    public String getTraPaciente() {
        return traPaciente;
    }

    public void setTraPaciente(String traPaciente) {
        this.traPaciente = traPaciente;
    }
}
