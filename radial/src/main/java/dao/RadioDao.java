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
        String sql = "select radio.*, tipo_transmision.*, programas.* from radio, tipo_transmision, programas where radio.transmision = tipo_transmision.id_transmision and radio.programa = programas.id_programa";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<RadioBean> radios = new LinkedList<>();
            while(rs.next()){
                RadioBean rad = new RadioBean(rs.getInt("id_radio"));
                rad.setNombre_radio(rs.getString("nombre_radio"));
                rad.setFrecuencia(rs.getString("frecuencia"));
                Tipo_transmisionBean tpd = new Tipo_transmisionBean(rs.getInt("transmision"));
                tpd.setNombre_transmision(rs.getString("nombre_"));
                rad.setTransmision(tpd);
                ProgramasBean prb = new ProgramasBean(rs.getInt("programa"));
                prb.setNombre_programa(rs.getString("nombre_programa"));
                rad.setPrograma(prb);
                radios.add(rad);
            }
            return radios;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<RadioBean>findById(int id){
        String sql = "select radio.*, tipo_transmision.*, programas.* from radio, tipo_transmision, programas where radio.transmision = tipo_transmision.id_transmision and radio.programa = programas.id_programa Where radio.id_radio=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<RadioBean> radios = new LinkedList<>();
            while(rs.next()){
                RadioBean rad = new RadioBean(rs.getInt("id_radio"));
                rad.setNombre_radio(rs.getString("nombre_radio"));
                rad.setFrecuencia(rs.getString("frecuencia"));
                Tipo_transmisionBean tpd = new Tipo_transmisionBean(rs.getInt("transmision"));
                tpd.setNombre_transmision(rs.getString("nombre_"));
                rad.setTransmision(tpd);
                ProgramasBean prb = new ProgramasBean(rs.getInt("programa"));
                prb.setNombre_programa(rs.getString("nombre_programa"));
                rad.setPrograma(prb);
                radios.add(rad);
            }
            return radios;
        } catch (Exception e) {
            return null;
        }
    }
    
}
