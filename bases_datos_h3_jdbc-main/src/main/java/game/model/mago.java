package game.model;

public class Mago {
    private int mana;
    private int vida;
    private String nombre_personaje;

    public Mago(int mana, int vida, String nombre_personaje) {
        this.mana = mana;
        this.vida = vida;
        this.nombre_personaje = nombre_personaje;
    }
    public int getMana() {
        return mana;
    }
    public int getVida() {
        return vida;
    }
    public String getNombre_personaje() {
        return nombre_personaje;
    }
}
