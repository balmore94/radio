package modelo;

/**
 *
 * @author mario.rodriguezusam
 */
public class EncuestasBean {

    private int id_encuestas;
    private int total_encuestados;
    private int aprobaciones;
    private int rechazos;
    private int indiferencias;
    private ProgramasBean programa;

    public EncuestasBean(int id_encuestas) {
        this.id_encuestas = id_encuestas;
    }

    public int getId_encuestas() {
        return id_encuestas;
    }

    public void setId_encuestas(int id_encuestas) {
        this.id_encuestas = id_encuestas;
    }

    public int getTotal_encuestados() {
        return total_encuestados;
    }

    public void setTotal_encuestados(int total_encuestados) {
        this.total_encuestados = total_encuestados;
    }

    public int getAprobaciones() {
        return aprobaciones;
    }

    public void setAprobaciones(int aprobaciones) {
        this.aprobaciones = aprobaciones;
    }

    public int getRechazos() {
        return rechazos;
    }

    public void setRechazos(int rechazos) {
        this.rechazos = rechazos;
    }

    public int getIndiferencias() {
        return indiferencias;
    }

    public void setIndiferencias(int indeferencias) {
        this.indiferencias = indeferencias;
    }

    public ProgramasBean getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramasBean programa) {
        this.programa = programa;
    }

}
