package game.model;

public class Baculo {
    private String nombreBaculo;
    private int idBaculo;
    private int pesoBaculo;


    public Baculo(String nombreBaculo, int idBaculo, int pesoBaculo) {
        this.nombreBaculo = nombreBaculo;
        this.idBaculo = idBaculo;
        this.pesoBaculo = pesoBaculo;
    }

    public String getNombreBaculo() {
        return nombreBaculo;
    }

    public void setNombreBaculo(String nombreBaculo) {
        this.nombreBaculo = nombreBaculo;
    }

    public int getIdBaculo() {
        return idBaculo;
    }

    public void setIdBaculo(int idBaculo) {
        this.idBaculo = idBaculo;
    }

    public int getPesoBaculo() {
        return pesoBaculo;
    }

    public void setPesoBaculo(int pesoBaculo) {
        this.pesoBaculo = pesoBaculo;
    }
}
