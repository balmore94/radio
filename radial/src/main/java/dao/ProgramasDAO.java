package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public List<ProgramasBean> MostrarProgramas() {
        String query = "select p.id_programa, p.nombre_programa,g.nombre_genero from programas p inner join genero g on p.genero = g.id_genero;";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<ProgramasBean> lista = new LinkedList<>();
            ProgramasBean p;
            GeneroBean g;
            while (rs.next()) {
                p = new ProgramasBean(rs.getInt("id_programa"));
                p.setNombre_programa(rs.getString("nombre_programa"));
                g = new GeneroBean(rs.getInt("id_genero"));
                g.setNombre_genero(rs.getString("genero"));
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
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setString(1, po.getNombre_programa());
            stm.setInt(2, po.getGenero().getId_genero());
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

    public List<ProgramasBean> GetPrograById(int id_programa) {
        String query = "select * from programas where id_programa = ?";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setInt(1, id_programa);
            ResultSet rt = stm.executeQuery();
            List<ProgramasBean> lista = new LinkedList<>();
            ProgramasBean pro;
            GeneroBean gen;
            while (rt.next()) {
                pro = new ProgramasBean(rt.getInt("id_programa"));
                pro.setNombre_programa(rt.getString("nombre_programa"));
                gen = new GeneroBean(rt.getInt("id_genero"));
                gen.setId_genero(rt.getInt("id_genero"));
                pro.setGenero(gen);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean actualizar(ProgramasBean pr){
        String query ="update programas set nombre_programa=?, genero=? where id_programa = ?";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setString(1, pr.getNombre_programa());
            stm.setInt(2, pr.getGenero().getId_genero());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
