/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author rodrigo.martinezusam
 */
public class ProgramaradioBean {
    
    private int id_programaradio;
    private ProgramasBean programa;
    private RadioBean radio;
    private Date fecha;
    private Time hora_inicio;
    private int duracion;
    private boolean repeticion;
    private EmisionesBean emisiones;

    public int getId_programaradio() {
        return id_programaradio;
    }

    public void setId_programaradio(int id_programaradio) {
        this.id_programaradio = id_programaradio;
    }

    public ProgramasBean getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramasBean programa) {
        this.programa = programa;
    }

    public RadioBean getRadio() {
        return radio;
    }

    public void setRadio(RadioBean radio) {
        this.radio = radio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(boolean repeticion) {
        this.repeticion = repeticion;
    }

    public EmisionesBean getEmisiones() {
        return emisiones;
    }

    public void setEmisiones(EmisionesBean emisiones) {
        this.emisiones = emisiones;
    }

    public ProgramaradioBean(int id_programaradio) {
        this.id_programaradio = id_programaradio;
    }

    
}
