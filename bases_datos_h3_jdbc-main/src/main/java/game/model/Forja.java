package game.model;

public class Forja {
    private String nombreForja;
    private String nombreCiudad;


    public Forja(String nombreForja, String nombreCiudad) {
        this.nombreForja = nombreForja;
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombre() {
        return nombreForja;
    }

    public void setNombre(String nombreForja) {
        this.nombreForja = nombreForja;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
