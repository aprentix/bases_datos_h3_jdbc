package game.model;

public class Daga {
    private String nombreDaga;
    private int idDaga;
    private int pesoDaga;


    public Daga(String nombreDaga, int idDaga, int pesoDaga) {
        this.nombreDaga = nombreDaga;
        this.idDaga = idDaga;
        this.pesoDaga = pesoDaga;
    }

    public String getNombreDaga() {
        return nombreDaga;
    }

    public void setNombreDaga(String nombreDaga) {
        this.nombreDaga = nombreDaga;
    }

    public int getIdDaga() {
        return idDaga;
    }

    public void setIdDaga(int idDaga) {
        this.idDaga = idDaga;
    }

    public int getPesoDaga() {
        return pesoDaga;
    }

    public void setPesoDaga(int pesoDaga) {
        this.pesoDaga = pesoDaga;
    }
}
