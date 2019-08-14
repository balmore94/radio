package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.ProgramasBean;
import modelo.RadioBean;
import modelo.Tipo_transmisionBean;

/**
 *
 * @author ronald.reyesusam
 */
public class RadioDao {
    Conexion conn = new Conexion();

    public RadioDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insertar(RadioBean rab){
        String sql = "INSERT INTO radio VALUE(?,?,?,?,null)";
        Tipo_transmisionBean t = rab.getTransmision();
        //ProgramasBean p = rab.getPrograma();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, rab.getId_radio());
            ps.setString(2, rab.getNombre_radio());
            ps.setString(3, rab.getFrecuencia());
            ps.setInt(4, t.getId_transmision());
            //ps.setInt(5, p.getId_programa());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean actualizar(RadioBean rab){
        String sql = "UPDATE radio SET nombre_radio=?, frecuencia=?, transmision=? WHERE id_radio =?";
        Tipo_transmisionBean t = rab.getTransmision();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            
            ps.setString(1, rab.getNombre_radio());
            ps.setString(2, rab.getFrecuencia());
            ps.setInt(3, t.getId_transmision());
            ps.setInt(4, rab.getId_radio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM radio WHERE id_radio =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<RadioBean>findAll(){
        String sql = "select radio.*, tipo_transmision.* from radio, tipo_transmision where radio.transmision = tipo_transmision.id_transmision";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<RadioBean> radios = new LinkedList<>();
            while(rs.next()){
                RadioBean rad = new RadioBean(rs.getInt("id_radio"));
                rad.setNombre_radio(rs.getString("nombre_radio"));
                rad.setFrecuencia(rs.getString("frecuencia"));
                Tipo_transmisionBean tpd = new Tipo_transmisionBean(rs.getInt("transmision"));
                tpd.setNombre_transmision(rs.getString("nombre_transmision"));
                rad.setTransmision(tpd);
                radios.add(rad);
            }
            return radios;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<RadioBean>findById(int id){
        String sql = "select radio.*, tipo_transmision.* from radio, tipo_transmision where radio.transmision = tipo_transmision.id_transmision and radio.id_radio = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<RadioBean> radio = new LinkedList<>();
            while(rs.next()){
                RadioBean rad = new RadioBean(rs.getInt("id_radio"));
                rad.setNombre_radio(rs.getString("nombre_radio"));
                rad.setFrecuencia(rs.getString("frecuencia"));
                Tipo_transmisionBean tpd = new Tipo_transmisionBean(rs.getInt("transmision"));
                tpd.setNombre_transmision(rs.getString("nombre_transmision"));
                rad.setTransmision(tpd);
                radio.add(rad);
            }
            return radio;
        } catch (Exception e) {
            return null;
        }
    }
    
}
