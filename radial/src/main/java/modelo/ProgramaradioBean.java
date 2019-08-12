/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rodrigo.martinezusam
 */
public class ProgramaradioBean {
    
    private int id_programaradio;
    private ProgramaBean programa;
    private RadioBean radio;
    private String fecha;
    private String hora_inicio;
    private int duracion;
    private boolean repeticion;
    private programaemisionesBean emisiones;

    public int getId_programaradio() {
        return id_programaradio;
    }

    public void setId_programaradio(int id_programaradio) {
        this.id_programaradio = id_programaradio;
    }

    public ProgramaBean getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaBean programa) {
        this.programa = programa;
    }

    public RadioBean getRadio() {
        return radio;
    }

    public void setRadio(RadioBean radio) {
        this.radio = radio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isRepeticion() {
        return repeticion;
    }

    public void setRepeticion(boolean repeticion) {
        this.repeticion = repeticion;
    }

    public programaemisionesBean getEmisiones() {
        return emisiones;
    }

    public void setEmisiones(programaemisionesBean emisiones) {
        this.emisiones = emisiones;
    }
    
    
    
}
