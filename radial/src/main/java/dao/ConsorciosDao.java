package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import modelo.CompaniaBean;
import modelo.ConsorciosBean;
import modelo.ProgramasBean;
import modelo.RadioBean;

public class ConsorciosDao {
    
    Conexion conn;

    public ConsorciosDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insertar(ConsorciosBean cob){
        String sql = "INSERT INTO consorcios VALUE(?,?,?,?)";
        RadioBean ra = cob.getRadio_consorcio();
        ProgramasBean pr = cob.getPrograma_consorcio();
        CompaniaBean com = cob.getCompania_consorcio();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cob.getId_consorcio());
            ps.setInt(2, ra.getId_radio());
            ps.setInt(3, pr.getId_programa());
            ps.setInt(4, com.getId_caompania());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean actualizar(ConsorciosBean cob){
        String sql = "UPDATE consorcios SET radio_consorcio=?, programa_consorcio=?, compania_consorcio=? WHERE id_consorcio=?";
        RadioBean ra = cob.getRadio_consorcio();
        ProgramasBean pr = cob.getPrograma_consorcio();
        CompaniaBean com = cob.getCompania_consorcio();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, ra.getId_radio());
            ps.setInt(2, pr.getId_programa());
            ps.setInt(3, com.getId_caompania());
            ps.setInt(4, cob.getId_consorcio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM consorcio WHERE id_consorcio =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
