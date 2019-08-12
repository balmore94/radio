package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.EmisionesBean;

public class EmisionesDao {
    
    Conexion conn;
    
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
        String sql = "";
    }
}
