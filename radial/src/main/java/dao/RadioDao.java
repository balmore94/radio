package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import modelo.ProgramasBean;
import modelo.RadioBean;
import modelo.Tipo_transmisionBean;

/**
 *
 * @author ronald.reyesusam
 */
public class RadioDao {
    Conexion conn;

    public RadioDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insertar(RadioBean rab){
        String sql = "INSERT INTO radio VALUE(?,?,?,?,?)";
        Tipo_transmisionBean t = rab.getTransmision();
        ProgramasBean p = rab.getPrograma();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, rab.getId_radio());
            ps.setString(2, rab.getNombre_radio());
            ps.setString(3, rab.getFrecuencia());
            ps.setInt(4, t.getId_transmision());
            ps.setInt(5, p.getId_programa());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean actualizar(RadioBean rab){
        String sql = "UPDATE radio SET nombre_radio=?, frecuencia=?, transmision=?, programa=? WHERE id_radio =?";
        Tipo_transmisionBean t = rab.getTransmision();
        ProgramasBean p = rab.getPrograma();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            
            ps.setString(1, rab.getNombre_radio());
            ps.setString(2, rab.getFrecuencia());
            ps.setInt(3, t.getId_transmision());
            ps.setInt(4, p.getId_programa());
            ps.setInt(5, rab.getId_radio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
