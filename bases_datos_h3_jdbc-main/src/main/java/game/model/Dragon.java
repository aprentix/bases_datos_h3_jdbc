package game.model;

/**
 * Modela un dragón. No es necesario modificar esta clase. Pero debe crear tantas clases como entidades
 * necesite para llevar a cabo esta parte del hito 3. Inclúyalas en el paquete "game.model"
 */
public class Dragon {

    private String nombre;
    private int vida;
    private int orden;

    public Dragon(String name, int life,int orden) {
        this.nombre = name;
        this.vida = life;
        this.orden=orden;
    }

    public int getLife() {
        return this.vida;
    }

    public String getName() {
        return this.nombre;
    }
    public int getOrden(){return this.orden;}
}
