package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.EncuestasBean;
import modelo.ProgramasBean;

/**
 *
 * @author mario.rodriguezusam
 */
public class EncuestasDAO {

    Conexion conn;

    public EncuestasDAO(Conexion conn) {
        this.conn = conn;
    }

    public List<EncuestasBean> mostrarEncuestas() {
        String query = "select e.id_encuestas, e.total_encuestados, e.aprobaciones, e.rechazos, e.indiferencias, p.id_programa, p.nombre_programa from encuentas e inner join programas p on e.programa = p.id_programa";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            ResultSet rt = stm.executeQuery();
            List<EncuestasBean> lista = new LinkedList<>();
            while (rt.next()) {
                EncuestasBean e = new EncuestasBean(rt.getInt("id_encuestas"));
                e.setTotal_encuestados(rt.getInt("total_encuestados"));
                e.setAprobaciones(rt.getInt("aprobaciones"));
                e.setRechazos(rt.getInt("rechazos"));
                e.setIndiferencias(rt.getInt("indiferencias"));
                ProgramasBean p = new ProgramasBean(rt.getInt("id_programa"));
                p.setNombre_programa(rt.getString("nombre_programa"));
                e.setPrograma(p);
                lista.add(e);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean guardar(EncuestasBean en) {
        String query = "insert into encuentas (total_encuestados,aprobaciones,rechazos,indiferencias,programa) values (?,?,?,?,?);";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setInt(1, en.getTotal_encuestados());
            stm.setInt(2, en.getAprobaciones());
            stm.setInt(3, en.getRechazos());
            stm.setInt(4, en.getIndiferencias());
            stm.setInt(5, en.getPrograma().getId_programa());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id_encuestas) {
        String query = "delete from encuentas where id_encuestas=?";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setInt(1, id_encuestas);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<EncuestasBean> GetEncuById(int id) {
        String query = "select * from encuentas where id_encuestas=?";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rt = stm.executeQuery();
            List<EncuestasBean> lista = new LinkedList<>();
            while (rt.next()) {
                EncuestasBean ec = new EncuestasBean(rt.getInt("id_encuestas"));
                ec.setTotal_encuestados(rt.getInt("total_encuestados"));
                ec.setAprobaciones(rt.getInt("aprobaciones"));
                ec.setRechazos(rt.getInt("rechazos"));
                ec.setIndiferencias(rt.getInt("indiferencias"));
                ProgramasBean pr = new ProgramasBean(rt.getInt("programa"));
                ec.setPrograma(pr);
                lista.add(ec);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(EncuestasBean eu) {
        String query = "update encuentas set total_encuestados = ?, aprobaciones = ?, rechazos = ?, indiferencias = ?, programa = ? where id_encuestas = ?; ";
        ProgramasBean prg = eu.getPrograma();
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setInt(1, eu.getTotal_encuestados());
            stm.setInt(2, eu.getAprobaciones());
            stm.setInt(3, eu.getRechazos());
            stm.setInt(4, eu.getIndiferencias());
            stm.setInt(5, prg.getId_programa());
            stm.setInt(6, eu.getId_encuestas());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
