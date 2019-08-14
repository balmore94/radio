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
    
    public List<ConsorciosBean>findAll(){
        String sql = "SELECT * FROM consorcios";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ConsorciosBean> consorcios = new LinkedList<>();
            while(rs.next()){
                ConsorciosBean cs = new ConsorciosBean(rs.getInt("id_consorcio"));
                RadioBean ra = new RadioBean(rs.getInt("radio_consorcio"));
                cs.setRadio_consorcio(ra);
                ProgramasBean pr = new ProgramasBean(rs.getInt("programa_consorcio"));
                cs.setPrograma_consorcio(pr);
                CompaniaBean co = new CompaniaBean(rs.getInt("compania_consorcio"));
                cs.setCompania_consorcio(co);
                consorcios.add(cs);
            }
            return consorcios;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public List<ConsorciosBean>findById(int id){
        String sql = "SELECT * FROM consorcios WHERE id_consorcio=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<ConsorciosBean> consorcios = new LinkedList<>();
            while(rs.next()){
                ConsorciosBean cs = new ConsorciosBean(rs.getInt("id_consorcio"));
                RadioBean ra = new RadioBean(rs.getInt("radio_consorcio"));
                cs.setRadio_consorcio(ra);
                ProgramasBean pr = new ProgramasBean(rs.getInt("programa_consorcio"));
                cs.setPrograma_consorcio(pr);
                CompaniaBean co = new CompaniaBean(rs.getInt("compania_consorcio"));
                cs.setCompania_consorcio(co);
                consorcios.add(cs);
            }
            return consorcios;
        } catch (Exception e) {
            return null;
        }
    }
}
