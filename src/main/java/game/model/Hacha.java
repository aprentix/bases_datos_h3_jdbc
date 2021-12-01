package game.model;

public class Hacha {
    private String nombreHacha;
    private int idHacha;
    private int pesoHacha;


    public Hacha(String nombreHacha, int idHacha, int pesoHacha) {
        this.nombreHacha = nombreHacha;
        this.idHacha = idHacha;
        this.pesoHacha = pesoHacha;
    }

    public String getNombreHacha() {
        return nombreHacha;
    }

    public void setNombreHacha(String nombreHacha) {
        this.nombreHacha = nombreHacha;
    }

    public int getIdHacha() {
        return idHacha;
    }

    public void setIdHacha(int idHacha) {
        this.idHacha = idHacha;
    }

    public int getPesoHacha() {
        return pesoHacha;
    }

    public void setPesoHacha(int pesoHacha) {
        this.pesoHacha = pesoHacha;
    }
}
