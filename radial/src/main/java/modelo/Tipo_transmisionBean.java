
package modelo;

/**
 *
 * @author mario.rodriguezusam
 */
public class Tipo_transmisionBean {
    
    private int id_transmision;
    private String nombre_transmision;

    public Tipo_transmisionBean(int id_transmision) {
        this.id_transmision = id_transmision;
    }
    
    public int getId_transmision() {
        return id_transmision;
    }

    public void setId_transmision(int id_transmision) {
        this.id_transmision = id_transmision;
    }

    public String getNombre_transmision() {
        return nombre_transmision;
    }

    public void setNombre_transmision(String nombre_transmision) {
        this.nombre_transmision = nombre_transmision;
    }
    
    
}
