package modelo;

public class TelefonosBean {

    private int id_telefono;
    private String telefono1;
    private Compania compania;

    public TelefonosBean(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    public int getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

}
