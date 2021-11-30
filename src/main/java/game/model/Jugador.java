package game.model;

public class Jugador {
    private String nombre_personaje;
    private int id_jugador;
    public Jugador(String nombre_personaje, int id_jugador){
        this.nombre_personaje = nombre_personaje;
        this.id_jugador = id_jugador;
    }
    public String getNombre_personaje(){
        return this.nombre_personaje;
    }
    public int getId_jugador(){
        return this.id_jugador;
    }
}
