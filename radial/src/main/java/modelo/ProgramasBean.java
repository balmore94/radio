
package modelo;

/**
 *
 * @author mario.rodriguezusam
 */
public class ProgramasBean {
    
    private int id_programa;
    private String nombre_programa;
    private GeneroBean genero;

    public ProgramasBean(int id_programa) {
        this.id_programa = id_programa;
    }
    
    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public String getNombre_programa() {
        return nombre_programa;
    }

    public void setNombre_programa(String nombre_programa) {
        this.nombre_programa = nombre_programa;
    }

    public GeneroBean getGenero() {
        return genero;
    }

    public void setGenero(GeneroBean genero) {
        this.genero = genero;
    }
    
    
    
}
