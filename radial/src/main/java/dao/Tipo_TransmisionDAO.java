package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Tipo_transmisionBean;

/**
 *
 * @author mario.rodriguezusam
 */
public class Tipo_TransmisionDAO {

    Conexion conn;

    public Tipo_TransmisionDAO(Conexion conn) {
        this.conn = conn;
    }

    public List<Tipo_transmisionBean> MostrarTipoTransmision() {
        String query = "select id_transmision, nombre_transmision from tipo_transmision;";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<Tipo_transmisionBean> lista = new LinkedList<>();
            Tipo_transmisionBean tipot;
            while (rs.next()) {
                tipot = new Tipo_transmisionBean(rs.getInt("id_transmision"));
                tipot.setId_transmision(rs.getInt("id_transmision"));
                tipot.setNombre_transmision(rs.getString("nombre_transmision"));
                lista.add(tipot);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean guardar(Tipo_transmisionBean ti) {
        String query = "insert into tipo_transmision(nombre_transmision) values (?)";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setString(1, ti.getNombre_transmision());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id_transmision) {
        String query = "delete from tipo_transmision where id_transmision=?";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setInt(1, id_transmision);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actuliazar(Tipo_transmisionBean ti) {
        String query = "update tipo_transmision set nombre_transmision=? where id_transmision = ?";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setString(1, ti.getNombre_transmision());
            stm.setInt(1, ti.getId_transmision());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Tipo_transmisionBean> GetTipoById(int id_transmision) {
        String query = "select * from tipo_transmision where id_transmision=?";
        try {
            PreparedStatement stm = conn.conectar().prepareStatement(query);
            stm.setInt(1, id_transmision);
            ResultSet rt = stm.executeQuery();
            List<Tipo_transmisionBean> lista = new LinkedList<>();
            Tipo_transmisionBean t;
            while (rt.next()) {
                t = new Tipo_transmisionBean(rt.getInt("id_transmision"));
                t.setNombre_transmision(rt.getString("nombre_transmision"));
                lista.add(t);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
