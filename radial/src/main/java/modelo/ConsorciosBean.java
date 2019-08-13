package modelo;

public class ConsorciosBean {
    private int id_consorcio;
    private RadioBean radio_consorcio;
    private ProgramasBean programa_consorcio;
    private CompaniaBean compania_consorcio;

    public ConsorciosBean(int id_consorcio) {
        this.id_consorcio = id_consorcio;
    }

    public int getId_consorcio() {
        return id_consorcio;
    }

    public void setId_consorcio(int id_consorcio) {
        this.id_consorcio = id_consorcio;
    }

    public RadioBean getRadio_consorcio() {
        return radio_consorcio;
    }

    public void setRadio_consorcio(RadioBean radio_consorcio) {
        this.radio_consorcio = radio_consorcio;
    }

    public ProgramasBean getPrograma_consorcio() {
        return programa_consorcio;
    }

    public void setPrograma_consorcio(ProgramasBean programa_consorcio) {
        this.programa_consorcio = programa_consorcio;
    }

    public CompaniaBean getCompania_consorcio() {
        return compania_consorcio;
    }

    public void setCompania_consorcio(CompaniaBean compania_consorcio) {
        this.compania_consorcio = compania_consorcio;
    }
    
    
}
