package modelo;

public class EmisionesBean {

    private int id_emisiones;
    private String emision;

    public EmisionesBean(int id_emisiones) {
        this.id_emisiones = id_emisiones;
    }

    public int getId_emisiones() {
        return id_emisiones;
    }

    public void setId_emisiones(int id_emisiones) {
        this.id_emisiones = id_emisiones;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

}
