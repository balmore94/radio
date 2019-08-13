/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.EmisionesBean;
import modelo.ProgramaradioBean;
import modelo.ProgramasBean;
import modelo.RadioBean;

/**
 *
 * @author rodrigo.martinezusam
 */
public class ProgramaradioDAO {

    Conexion conn;

    public ProgramaradioDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean delete(int id) throws Exception {
        String sql = "delete from programaradio where id_programaradio=?;";
        try {
            PreparedStatement stm = this.conn.conectar().prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean insertar(ProgramaradioBean pro) throws Exception {
        String mysql = "insert into programa_radio values(?,?,?,?,?,?,?,?)";
        ProgramasBean p = pro.getPrograma();
        RadioBean r = pro.getRadio();
        EmisionesBean em = pro.getEmisiones();
        try {
            PreparedStatement stm = this.conn.conectar().prepareStatement(mysql);
            stm.setInt(1, pro.getId_programaradio());
            stm.setInt(2, p.getId_programa());
            stm.setInt(3, r.getId_radio());
            stm.setDate(4, pro.getFecha());
            stm.setTime(5, pro.getHora_inicio());
            stm.setInt(6, pro.getDuracion());
            stm.setBoolean(7, pro.getRepeticion());
            stm.setInt(8, em.getId_emisiones());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean update(ProgramaradioBean progra) throws Exception {
        String ruta = "update trabjadores set programa=?,radio=?,fecha=?,hora_inicio=?,duracion=?,repeticion=?,emisiones=? WHERE id_programaradio =?;";

        ProgramasBean p = progra.getPrograma();
        RadioBean r = progra.getRadio();
        EmisionesBean em = progra.getEmisiones();
        try {
            PreparedStatement stm = this.conn.conectar().prepareStatement(ruta);
            stm.setInt(1, p.getId_programa());
            stm.setInt(2, r.getId_radio());
            stm.setDate(3, progra.getFecha());
            stm.setTime(4, progra.getHora_inicio());
            stm.setInt(5, progra.getDuracion());
            stm.setBoolean(6, progra.getRepeticion());
            stm.setInt(7, em.getId_emisiones());
            stm.setInt(8, progra.getId_programaradio());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }

    }

    public List<ProgramaradioBean> findAll() throws Exception {

        String query = "Select  programa_radio.*,radio.*,programas.*,emisiones.*  from programa_radio,radio,programas,emisiones where programa_radio.radio =radio.id_radio and programa_radio.programa = programas.id_programa and programa_radio.emisiones = emisiones.id_emisiones;";
        try {
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            ResultSet rt = stm.executeQuery();
            List<ProgramaradioBean> Lista = new LinkedList<>();
            while (rt.next()) {
                ProgramaradioBean prb = new ProgramaradioBean(rt.getInt("id_programaradio"));
                ProgramasBean pro = new ProgramasBean(rt.getInt("programa"));
                pro.setNombre_programa(rt.getString("nombre_programa"));
                prb.setPrograma(pro);
                RadioBean rad = new RadioBean(rt.getInt("radio"));
                rad.setNombre_radio(rt.getString("nombre_radio"));
                prb.setRadio(rad);
                prb.setFecha(rt.getDate("fecha"));
                prb.setHora_inicio(rt.getTime("hora_inicio"));
                prb.setDuracion(rt.getInt("duracion"));
                prb.setRepeticion(rt.getBoolean("repeticion"));
                EmisionesBean em = new EmisionesBean(rt.getInt("emisiones"));
                em.setEmision(rt.getString("emision"));
                prb.setEmisiones(em);
                Lista.add(prb);
            }
            return Lista;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ProgramaradioBean> finbyID(int id) throws Exception{
        
        String query="Select  programa_radio.*,radio.*,programas.*,emisiones.*  from programa_radio,radio,programas,emisiones where programa_radio.radio =radio.id_radio and programa_radio.programa = programas.id_programa and programa_radio.emisiones = emisiones.id_emisiones where programa_radio.id_programaradio=?;";
        try {
            
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rt = stm.executeQuery();
            List<ProgramaradioBean> programaradio = new LinkedList<>();
            while(rt.next()){
                ProgramaradioBean prb = new ProgramaradioBean(rt.getInt("id_programaradio"));
                ProgramasBean pro = new ProgramasBean(rt.getInt("programa"));
                pro.setNombre_programa(rt.getString("nombre_programa"));
                prb.setPrograma(pro);
                RadioBean rad = new RadioBean(rt.getInt("radio"));
                rad.setNombre_radio(rt.getString("nombre_radio"));
                prb.setRadio(rad);
                prb.setFecha(rt.getDate("fecha"));
                prb.setHora_inicio(rt.getTime("hora_inicio"));
                prb.setDuracion(rt.getInt("duracion"));
                prb.setRepeticion(rt.getBoolean("repeticion"));
                EmisionesBean em = new EmisionesBean(rt.getInt("emisiones"));
                em.setEmision(rt.getString("emision"));
                prb.setEmisiones(em);
                programaradio.add(prb);
            }
            return programaradio;
        } catch (Exception e) {
            throw  e;
        }
    }

}
