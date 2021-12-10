package game.model;

public class Pocion {
    private int idPocion;
    private String nombrePocion;
    private int vida;
    private int mana;

    public Pocion(int idPocion, String nombrePocion, int vida, int mana) {
        this.idPocion = idPocion;
        this.nombrePocion = nombrePocion;
        this.vida = vida;
        this.mana = mana;
    }

    public int getIdPocion() {
        return idPocion;
    }

    public void setIdPocion(int idPocion) {
        this.idPocion = idPocion;
    }

    public String getNombrePocion() {
        return nombrePocion;
    }

    public void setNombrePocion(String nombrePocion) {
        this.nombrePocion = nombrePocion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
