package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import modelo.GeneroBean;
import modelo.ProgramasBean;

/**
 *
 * @author mario.rodriguezusam
 */
public class ProgramasDAO {

    Conexion conn;

    public ProgramasDAO(Conexion conn) {
        this.conn = conn;
    }

    public List<ProgramasBean> mostrarProgramas() {
        String query = "select p.id_programa, p.nombre_programa, g.id_genero, g.nombre_genero from programas p inner join genero g on p.genero = g.id_genero order by id_programa";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<ProgramasBean> lista = new LinkedList<>();
            while (rs.next()) {
                ProgramasBean p = new ProgramasBean(rs.getInt("id_programa"));
                p.setNombre_programa(rs.getString("nombre_programa"));
                GeneroBean g = new GeneroBean(rs.getInt("id_genero"));
                g.setNombre_genero(rs.getString("nombre_genero"));
                p.setGenero(g);
                lista.add(p);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean guardar(ProgramasBean po) {
        String query = "insert into programas (nombre_programa,genero) values (?,?);";
        GeneroBean ge = po.getGenero();
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setString(1, po.getNombre_programa());
            stm.setInt(2, ge.getId_genero());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean elimiar(int id_programa) {
        String query = "delete from programas where id_programa=?";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setInt(1, id_programa);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ProgramasBean> getById(int id) {
        String query = "select * from programas where id_programa = ?";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rt = stm.executeQuery();
            List<ProgramasBean> lista = new LinkedList<>();
            while (rt.next()) {
                ProgramasBean pro = new ProgramasBean(rt.getInt("id_programa"));
                pro.setNombre_programa(rt.getString("nombre_programa"));
                GeneroBean gen = new GeneroBean(rt.getInt("genero"));
                pro.setGenero(gen);
                lista.add(pro);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    /*public List<ProgramasBean> getById(int id) throws Exception {
        List<ProgramasBean> lista = new ArrayList<ProgramasBean>();
        ProgramasBean po = new ProgramasBean(0);
        try {
            conn.conectar();
            String query = "select * from programas where id_programa=?";
            PreparedStatement stm = this.conn.conectar().prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rt = stm.executeQuery();
            while (rt.next()) {
                GeneroBean ge = new GeneroBean(0);
                po.setId_programa(rt.getInt("id_programa"));
                po.setNombre_programa(rt.getString("nombre_programa"));
                ge.setId_genero(rt.getInt("genero"));
                po.setGenero(ge);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.desconectar();
        }
    } */

    public boolean actualizar(ProgramasBean pr){
        String query = "update programas set nombre_programa=?, genero=? where id_programa=?";
        GeneroBean geb = pr.getGenero();
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setString(1, pr.getNombre_programa());
            stm.setInt(2, geb.getId_genero());
            stm.setInt(3, pr.getId_programa());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
