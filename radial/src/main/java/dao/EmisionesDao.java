package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.EmisionesBean;

public class EmisionesDao {
    
    Conexion conn = new Conexion();
    
    public EmisionesDao(Conexion con){
        this.conn = conn; 
    }
    
    public boolean insertar(EmisionesBean eb){
        String sql = "insert into emisiones values (?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, eb.getId_emisiones());
            ps.setString(2, eb.getEmision());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
           return false;
        }
    }
    
    public boolean actualizar(EmisionesBean eb){
        String sql = "update emisiones set emision=? where id_emisiones=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, eb.getEmision());
            ps.setInt(2, eb.getId_emisiones());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<EmisionesBean> consultarAll(){
        String sql = "select telefonos.*, compania.*\n" +
"from telefonos, compania\n" +
"where telefonos.compania=compania.id_compania";
        List<EmisionesBean> lista = new LinkedList<>();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            EmisionesBean eb;
            while(rs.next()){
                eb = new EmisionesBean(rs.getInt("id_emisiones"));
                eb.setEmision(rs.getString("emision"));
                lista.add(eb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
      public List<EmisionesBean> consultarById(int id_emisiones){
        String sql = "select * from emisiones where id_emisiones=?";
        List<EmisionesBean> lista = new LinkedList<>();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_emisiones);
            ResultSet rs = ps.executeQuery();
            EmisionesBean eb;
            while(rs.next()){
                eb = new EmisionesBean(rs.getInt("id_emisiones"));
                eb.setEmision(rs.getString("emision"));
                lista.add(eb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }  
      
      public boolean eliminar(int id_emisiones){
          String sql = "delete from emisiones where id_emisiones=?";
          try {
              PreparedStatement ps = conn.conectar().prepareStatement(sql);
              ps.setInt(1, id_emisiones);
              ps.executeUpdate();
              
              return true;
          } catch (Exception e) {
              return false;
          }
          
      }
}
