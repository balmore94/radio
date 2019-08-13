
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Tipo_transmisionBean;


public class Tipo_TransmisionDAO {
    
    Conexion conn;

    public Tipo_TransmisionDAO(Conexion conn) {
        this.conn = conn;
    }
    
    
    public List<Tipo_transmisionBean> MostrarTipoTransmision(){   
    String query = "select id_transmision, nombre_transmision from tipo_transmision;";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<Tipo_transmisionBean> lista = new LinkedList<>();
            Tipo_transmisionBean tipot;
            while(rs.next()){
                tipot = new Tipo_transmisionBean(rs.getInt("id_transmision"));
                tipot.setNombre_transmision(rs.getString("nombre_transmision"));
                lista.add(tipot);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
        }
}
