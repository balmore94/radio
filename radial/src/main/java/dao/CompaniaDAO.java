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
import java.util.LinkedList;
import java.util.List;
import modelo.CompaniaBean;
import modelo.EmisionesBean;

/**
 *
 * @author rodrigo.martinezusam
 */
public class CompaniaDAO {

    Conexion conn = new Conexion();

    public CompaniaDAO(Conexion con) {
        this.conn = conn;
    }

    public boolean actualizar(CompaniaBean cb)throws Exception{
        String query = "update compania set registrofc=?,nombre_compania=? where id_compania=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(query);
            ps.setString(1, cb.getRegistrofc());
            ps.setString(2, cb.getNombre_compania());
            ps.setInt(3, cb.getId_compania());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    

    public boolean delete(int id)throws Exception{
        String sql = "DELETE FROM compania WHERE id_compania =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean insertar(CompaniaBean comp)throws Exception{
        String query = "insert into compania values (?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(query);
            ps.setInt(1, comp.getId_compania());
            ps.setString(2, comp.getRegistrofc());
            ps.setString(3, comp.getNombre_compania());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<CompaniaBean> findAll(){
       
        try {
            String query = "select * from compania";
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            List<CompaniaBean> companias = new LinkedList<>();
            while (rs.next()) {
                CompaniaBean  com = new CompaniaBean(rs.getInt("id_compania"));
                com.setRegistrofc(rs.getString("registrofc"));
                com.setNombre_compania(rs.getString("nombre_compania"));
                companias.add(com);                       
            }
             return companias;
        } catch (Exception e) {
           return null;
        }
    }
    
    public List<CompaniaBean> findbyid(int id) throws Exception{
    String query="Select * from compania WHERE id_compania=?";
        try {
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rt = stm.executeQuery();
            List<CompaniaBean> compania = new LinkedList<>();
            while(rt.next()){
                CompaniaBean co = new CompaniaBean(rt.getInt("id_compania"));
                co.setRegistrofc(rt.getString("registrofc"));
                co.setNombre_compania(rt.getString("nombre_compania"));
                compania.add(co);
                        
            }
            return compania;
            
        } catch (Exception e) {
            throw e;
        }
    }

}