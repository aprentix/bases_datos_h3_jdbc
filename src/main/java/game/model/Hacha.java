package game.model;

public class Hacha {
    private String nombreHacha;
    private int daño;
    private int pesoHacha;
    public Hacha(String nombreHacha, int daño, int pesoHacha) {
        this.nombreHacha = nombreHacha;
        this.daño = daño;
        this.pesoHacha = pesoHacha;
    }
    public String getNombreHacha() {
        return nombreHacha;
    }
    public int getDañoHacha() {
        return daño;
    }
    public int getPesoHacha() {
        return pesoHacha;
    }
}
