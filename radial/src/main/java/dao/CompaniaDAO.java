/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.CompaniaBean;
import modelo.EmisionesBean;

/**
 *
 * @author rodrigo.martinezusam
 */
public class CompaniaDAO {

    Conexion conn;

    public CompaniaDAO(Conexion con) {
        this.conn = conn;
    }

    public boolean actualizar(CompaniaBean cb) {
        String query = "update compania set registrofc=?,nombre_compania=? where id_compania=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(query);
            ps.setString(1, cb.getRegistrofc());
            ps.setString(2, cb.getNombre_compania());
            ps.setInt(3, cb.getId_caompania());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    

    public void eliminar(int id) throws Exception {

        try {
            String query = "";

        } catch (Exception e) {
            throw e;
        }
    }

    public boolean insertar(CompaniaBean comp){
        String query = "insert into compania values (?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(query);
            ps.setInt(1, comp.getId_caompania());
            ps.setString(2, comp.getRegistrofc());
            ps.setString(2, comp.getNombre_compania());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<CompaniaBean> llenarCompania() throws Exception {

        List<CompaniaBean> Lista = new ArrayList<>();
        try {
            String query = "select * from compania";
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

            }

        } catch (Exception e) {
            throw e;
        }
        return Lista;
    }

}