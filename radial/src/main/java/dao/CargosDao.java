package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.CargosBean;

public class CargosDao {
    
    Conexion conn;
    
    public CargosDao(Conexion conn){
        this.conn = conn;
    }
    
    public boolean insertar(CargosBean cb){
        String sql = "insert into cargos values (?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cb.getId_cargo());
            ps.setString(2, cb.getCargo());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
  
    public List<CargosBean> consultarAll(){
        String sql = "select * cargos";
        List<CargosBean> lista = new LinkedList<>();
        try {
           PreparedStatement ps = conn.conectar().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           CargosBean cb;
           while(rs.next()){
               cb = new CargosBean(rs.getInt("id_cargo"));
               cb.setCargo(rs.getString("cargo"));
               lista.add(cb);
           }
           return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
   
}
