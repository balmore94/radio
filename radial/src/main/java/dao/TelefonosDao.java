package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.CompaniaBean;
import modelo.TelefonosBean;
/**
 *
 * @author maria.aguillonusam
 */
public class TelefonosDao {

    Conexion conn;

    public TelefonosDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(TelefonosBean tb) {
        String sql = "insert into telefonos values (?,?,?)";
        CompaniaBean cb = tb.getCompania();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, tb.getId_telefono());
            ps.setString(2, tb.getTelefono1());
            ps.setInt(3, cb.getId_compania());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(TelefonosBean tb) {
        String sql = "update telefonos set telefono1=?, compania=? where id_telefono=?";
        CompaniaBean cb = tb.getCompania();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, tb.getTelefono1());
            ps.setInt(2, cb.getId_compania());
            ps.setInt(3, tb.getId_telefono());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<TelefonosBean> consultarAll() {
        String sql = "select telefonos.*, compania.*\n"
                + "from telefonos, compania\n"
                + "where telefonos.compania=compania.id_compania";
        List<TelefonosBean> lista = new LinkedList<>();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            TelefonosBean tb;
            CompaniaBean cb;
            while (rs.next()) {
                tb = new TelefonosBean(rs.getInt("id_telefono"));
                tb.setTelefono1(rs.getString("telefono1"));
                cb = new CompaniaBean(rs.getInt("compania"));
                cb.setNombre_compania(rs.getString("nombre_compania"));
                tb.setCompania(cb);
                lista.add(tb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TelefonosBean> consultarById(int id_telefono) {
        String sql = "select * from telefonos where id_telefono=?";
        List<TelefonosBean> lista = new LinkedList<>();
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_telefono);
            ResultSet rs = ps.executeQuery();
            TelefonosBean tb;
            CompaniaBean cb;
            while (rs.next()) {
                tb = new TelefonosBean(rs.getInt("id_telefono"));
                tb.setTelefono1(rs.getString("telefono1"));
                cb = new CompaniaBean(rs.getInt("compania"));
                tb.setCompania(cb);
                lista.add(tb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean eliminar(int id_telefono) {
        String sql = "delete from telefonos where id_telefono=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_telefono);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
