package game.model;

public class mago {
    private int mana;
    private int vida;
    private String nombre_personaje;

    public mago(int mana,int vida, String nombre_personaje) {
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
