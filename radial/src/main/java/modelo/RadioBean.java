package modelo;

public class RadioBean {
    private int id_radio;
    private String nombre_radio;
    private String frecuencia;
    private Tipo_transmisionBean transmision;
    private ProgramasBean programa;

    public RadioBean(int id_radio) {
        this.id_radio = id_radio;
    }

    public int getId_radio() {
        return id_radio;
    }

    public void setId_radio(int id_radio) {
        this.id_radio = id_radio;
    }

    public String getNombre_radio() {
        return nombre_radio;
    }

    public void setNombre_radio(String nombre_radio) {
        this.nombre_radio = nombre_radio;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Tipo_transmisionBean getTransmision() {
        return transmision;
    }

    public void setTransmision(Tipo_transmisionBean transmision) {
        this.transmision = transmision;
    }

    public ProgramasBean getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramasBean programa) {
        this.programa = programa;
    }
    
    
}
