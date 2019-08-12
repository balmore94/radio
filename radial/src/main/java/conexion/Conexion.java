
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static String bd = "agenda";
    static String usuer = "root";
    static String pass = "root";
    static String url = "jdbc:mysql://localhost/" + bd + "?useSSL=false";
    Connection conn = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuer, pass);
            if (conn != null) {
                System.out.println("Exito en la conexion");
            }
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar() throws SQLException{
        conn.close();
    }
    
    public static void main(String[] args) {
        Conexion conn = new Conexion();
    }
}
