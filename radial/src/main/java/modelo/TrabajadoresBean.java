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
public class TrabajadoresBean {
    
    private int id_trabajadores;
    private String nombre_trabajador;
    private String apellido_trabajador;
    private String dui;
    private CargosBean cargo;
    private ProgramasBean programa_trabajdor;

    public int getId_trabajadores() {
        return id_trabajadores;
    }

    public void setId_trabajadores(int id_trabajadores) {
        this.id_trabajadores = id_trabajadores;
    }

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
    }

    public String getApellido_trabajador() {
        return apellido_trabajador;
    }

    public void setApellido_trabajador(String apellido_trabajador) {
        this.apellido_trabajador = apellido_trabajador;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public CargosBean getCargo() {
        return cargo;
    }

    public void setCargo(CargosBean cargo) {
        this.cargo = cargo;
    }

    

    public ProgramasBean getPrograma_trabajdor() {
        return programa_trabajdor;
    }

    public void setPrograma_trabajdor(ProgramasBean programa_trabajdor) {
        this.programa_trabajdor = programa_trabajdor;
    }

    public TrabajadoresBean(int id_trabajadores) {
        this.id_trabajadores = id_trabajadores;
    }
    
    
}
