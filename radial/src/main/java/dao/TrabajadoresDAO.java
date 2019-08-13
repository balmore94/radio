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
import modelo.CargosBean;
import modelo.CompaniaBean;
import modelo.ProgramasBean;
import modelo.TrabajadoresBean;

/**
 *
 * @author rodrigo.martinezusam
 */
public class TrabajadoresDAO {

    Conexion conn;

    public TrabajadoresDAO(Conexion con) {
        this.conn = conn;
    }

    public boolean delete(int id) throws Exception {
        String query = "Delete from trabajadores where id_trabajadores=?";
        try {
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean update(TrabajadoresBean tr) throws Exception {
        String query = "update trabajadores set nombre_trabajador=?,apellido_trabjador=?,dui=?,cargo=?,programa_trabajador=? where id_trabajadores=?;";

        CargosBean c = tr.getCargo();
        ProgramasBean p = tr.getPrograma_trabajdor();

        try {
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            stm.setString(1, tr.getNombre_trabajador());
            stm.setString(2, tr.getApellido_trabajador());
            stm.setString(3, tr.getDui());
            stm.setInt(4, c.getId_cargo());
            stm.setInt(5, p.getId_programa());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean insertar(TrabajadoresBean tra) throws Exception {
        String query = "Insert into trabajadores values(?,?,?,?,?,?)";

        CargosBean c = tra.getCargo();
        ProgramasBean p = tra.getPrograma_trabajdor();
        try {
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            stm.setInt(1, tra.getId_trabajadores());
            stm.setString(2, tra.getNombre_trabajador());
            stm.setString(3, tra.getApellido_trabajador());
            stm.setString(4, tra.getDui());
            stm.setInt(5, c.getId_cargo());
            stm.setInt(6, p.getId_programa());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }

    }

    public List<TrabajadoresBean> LlenarTrabajadores() throws Exception {
        String query = "Select* from trabajadores;";
        try {
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            ResultSet rt = stm.executeQuery();
            List<TrabajadoresBean> Lista = new LinkedList<>();
            while (rt.next()) {                
                TrabajadoresBean tra = new TrabajadoresBean(rt.getInt("id_trabajadores"));
                tra.setNombre_trabajador(rt.getString("nombre_trabajador"));
                tra.setApellido_trabajador(rt.getString("apellido_trabajador"));
                tra.setDui(rt.getString("dui"));
                CargosBean car = new CargosBean(rt.getInt("id_cargo"));
                
                /*----------------------Incompleto---------------------------*/
            }
            return Lista;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<TrabajadoresBean> findbyid(int id) throws Exception{
        String query = "Select * from trabajadores where id_trabajadores=?";
          try {
             PreparedStatement stm = this.conn.conectar().prepareStatement(query);
             stm.setInt(1, id);
             ResultSet rt = stm.executeQuery();
             List<TrabajadoresBean> trabajadores = new LinkedList<>();
             while(rt.next()){
             TrabajadoresBean tr = new TrabajadoresBean(rt.getInt("id_trabajadores"));
              tr.setNombre_trabajador(rt.getString("nombre_trabajador"));
              tr.setApellido_trabajador(rt.getString("apellido_trabajador"));
              tr.setDui(rt.getString("dui"));
              
               /*----------------------Incompleto---------------------------*/
             }
             return trabajadores;
        } catch (Exception e) {
          throw e;
        }
    }

}
