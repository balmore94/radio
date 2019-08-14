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
public class CompaniaBean {
    
    private int id_compania;
    private String registrofc;
    private String nombre_compania;

    public int getId_compania() {
        return id_compania;
    }

    public void setId_compania(int id_compania) {
        this.id_compania = id_compania;
    }

    public String getRegistrofc() {
        return registrofc;
    }

    public void setRegistrofc(String registrofc) {
        this.registrofc = registrofc;
    }

    public String getNombre_compania() {
        return nombre_compania;
    }

    public void setNombre_compania(String nombre_compania) {
        this.nombre_compania = nombre_compania;
    }

    public CompaniaBean(int id_compania) {
        this.id_compania = id_compania;
    }


    
}
