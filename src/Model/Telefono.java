package Model;

public class Telefono {
    private String extension;
    private String pais;
    private String numeroDeTelefono;

    public Telefono(String extension, String pais, String numeroDeTelefono){
        this.extension = extension;
        this.numeroDeTelefono = numeroDeTelefono;
        this.pais = pais;
    }

    public void setExtension(String extension){
        this.extension = extension;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public void setNumeroTelefono(String numeroTelefono){
        this.numeroDeTelefono = numeroTelefono;
    }


    public String getExtension(){
        return extension;
    }

    public String getPais(){
        return pais;
    }

    public String getNumeroTelefono(){
        return numeroDeTelefono;
    }
}
