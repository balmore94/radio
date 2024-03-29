package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
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
            ps.setInt(4, com.getId_compania());
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
            ps.setInt(3, com.getId_compania());
            ps.setInt(4, cob.getId_consorcio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM consorcios WHERE id_consorcio =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<ConsorciosBean>findAll(){
        String sql = "select consorcios.*, programas.*, compania.*, radio.* from consorcios, programas, compania, radio where consorcios.programa_consorcio = programas.id_programa and consorcios.radio_consorcio = radio.id_radio and consorcios.compania_consorcio = compania.id_compania";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ConsorciosBean> consorcios = new LinkedList<>();
            while(rs.next()){
                ConsorciosBean cs = new ConsorciosBean(rs.getInt("id_consorcio"));
                RadioBean ra = new RadioBean(rs.getInt("radio_consorcio"));
                ra.setNombre_radio(rs.getString("nombre_radio"));
                cs.setRadio_consorcio(ra);
                ProgramasBean pr = new ProgramasBean(rs.getInt("programa_consorcio"));
                pr.setNombre_programa(rs.getString("nombre_programa"));
                cs.setPrograma_consorcio(pr);
                CompaniaBean co = new CompaniaBean(rs.getInt("compania_consorcio"));
                co.setNombre_compania(rs.getString("nombre_compania"));
                cs.setCompania_consorcio(co);
                consorcios.add(cs);
            }
            return consorcios;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public List<ConsorciosBean>findById(int id){
        String sql = "select consorcios.*, programas.*, compania.*, radio.* from consorcios, programas, compania, radio where consorcios.programa_consorcio = programas.id_programa and consorcios.radio_consorcio = radio.id_radio and consorcios.compania_consorcio = compania.id_compania and consorcios.id_consorcio = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<ConsorciosBean> consorcio = new LinkedList<>();
            while(rs.next()){
                ConsorciosBean cs = new ConsorciosBean(rs.getInt("id_consorcio"));
                RadioBean ra = new RadioBean(rs.getInt("radio_consorcio"));
                ra.setNombre_radio(rs.getString("nombre_radio"));
                cs.setRadio_consorcio(ra);
                ProgramasBean pr = new ProgramasBean(rs.getInt("programa_consorcio"));
                pr.setNombre_programa(rs.getString("nombre_programa"));
                cs.setPrograma_consorcio(pr);
                CompaniaBean co = new CompaniaBean(rs.getInt("compania_consorcio"));
                co.setNombre_compania(rs.getString("nombre_compania"));
                cs.setCompania_consorcio(co);
                consorcio.add(cs);
            }
            return consorcio;
        } catch (Exception e) {
            return null;
        }
    }
}
