package modelo;
/**
 *
 * @author maria.aguillonusam
 */
public class CargosBean {


    private int id_cargo;
    private String nombre_cargo;
    
    public CargosBean(int id_cargo){
        this.id_cargo = id_cargo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

   
    
    
}
