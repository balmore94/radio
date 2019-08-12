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

/**
 *
 * @author rodrigo.martinezusam
 */
public class CompaniaDAO{
    
    Conexion conn;
   
    public void eliminar(int id) throws Exception {
        
        try {
            String query="";
           
        } catch (Exception e) {
            throw e;
        }
    }

    public void guardar() throws Exception {
        try {
            String query = "";
            //PreparedStatement stm = this.conn

        } catch (Exception e) {
            throw e;
        } 
    }

    public List<CompaniaBean> llenarCompania() throws Exception {

        List<CompaniaBean> Lista = new ArrayList<>();
        try {
            String query = "select * from compania";
             PreparedStatement stm = this.conn.conectar().prepareStatement(query);
             ResultSet rs = stm.executeQuery();
             while(rs.next()){
             
                 CompaniaBean con = new CompaniaBean();
             }

        } catch (Exception e) {
            throw e;
        } 
        return Lista;
    }

}
