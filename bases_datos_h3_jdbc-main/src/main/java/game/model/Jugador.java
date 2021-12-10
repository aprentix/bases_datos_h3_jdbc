package game.model;

public class Jugador {
    private String nombreJugador;
    private int idJugador;

    public Jugador(String nombreJugador, int idJugador) {
        this.nombreJugador = nombreJugador;
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
}
