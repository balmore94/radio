package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.GeneroBean;

/**
 *
 * @author ronald.reyesusam
 */
public class GeneroDao {
    Conexion conn = new Conexion();

    public GeneroDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insertar(GeneroBean geb){
        String sql = "INSERT INTO genero VALUE(?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, geb.getId_genero());
            ps.setString(2, geb.getNombre_genero());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean actualizar(GeneroBean geb){
        String sql = "UPDATE genero SET nombre_genero =? WHERE id_genero =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            
            ps.setString(1, geb.getNombre_genero());
            ps.setInt(2, geb.getId_genero());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM genero WHERE id_genero =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<GeneroBean>findAll(){
        String sql = "SELECT * FROM genero";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<GeneroBean> generos = new LinkedList<>();
            while(rs.next()){
                GeneroBean geb = new GeneroBean(rs.getInt("id_genero"));
                geb.setNombre_genero(rs.getString("nombre_genero"));
                System.out.println(geb.getNombre_genero());
                generos.add(geb);
            }
            return generos;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<GeneroBean>findById(int id){
        String sql = "SELECT * FROM genero WHERE id_genero =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<GeneroBean> genero = new LinkedList<>();
            while(rs.next()){
                GeneroBean geb = new GeneroBean(rs.getInt("id_genero"));
                geb.setNombre_genero(rs.getString("nombre_genero"));
                genero.add(geb);
            }
            return genero;
        } catch (Exception e) {
            return null;
        }
    }
}
