import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import game.model.Dragon;
import game.model.Hacha;
import java.sql.ResultSet;

public class Main {

    // @TODO: Sustituya xxxx por los parámetros de su conexión

    private static final String DB_SERVER = "localhost";

    private static final int DB_PORT = 3306;

    private static final String DB_NAME = "juego";

    private static final String DB_USER = "root";

    private static final String DB_PASS = "";

    private static Connection conn;

    public static void main(String[] args) throws Exception {
        List<Hacha> listaH = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://" + DB_SERVER + ":" + DB_PORT + "/" + DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER, DB_PASS);

        // @TODO pruebe sus funciones
        System.out.println(espada_porta_guerrero("Stanto"));
        conn.close();
    }

    // @TODO resuelva las siguientes funciones...
    // HECHO Y COMPROBADO CON EL METODO DRAGONES
    public static void nuevo_dragon(String nombre){
        // @TODO: complete este método para que cree un nuevo dragón en la base de datos
        PreparedStatement ps;
        int vida=100;
        int orden=4;
        String name=nombre;
        // @TODO: complete este método para que devuelva una lista de los dragones derrotados por el squad
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto dragon para cada uno de los dragones, y añadirlos a la lista
        try{
            ps=conn.prepareStatement("INSERT INTO dragon(nombre_dragon,vida,orden)VALUES(?,?,?)");
            ps.setString(1,name);
            ps.setInt(2,vida);
            ps.setInt(3,orden);
            ps.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void dragones(){
        Statement stmt;
        ResultSet rs;
        String name;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from dragon");
            while(rs.next()){
                name = rs.getString("nombre_dragon");
                System.out.println("Dragon: "+name);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static List<Dragon> squad_derrota_dragones(Long id_squad){
        Statement stmt = null;
        ResultSet rs = null;
        String name;
        Long id = id_squad;
        int life_points;
        Dragon dr;
        List<Dragon> lista = new ArrayList<>();
        // @TODO: complete este método para que devuelva una lista de los dragones derrotados por el squad
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto dragon para cada uno de los dragones, y añadirlos a la lista
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from escuadron_derrota_dragon where id_escuadron="+id);
            while(rs.next()){
                name = rs.getString("nombre_dragon");
                dr = new Dragon(name,0);
                lista.add(dr);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public static List<Hacha> mostrar_hachas(String nombre_forja){
        Statement stmt;
        ResultSet rs ;
        List<Hacha> lista = new ArrayList<>();
        String id = nombre_forja;
        String name;
        int peso;
        int daño;
        Hacha h;
        // @TODO: complete este método para que muestre por pantalla las hachas que pueden forjarse en "nombre_forja"
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto con cada hacha disponible en esa forja, y añadirlos a la lista
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from forja_fabrica_arma where nombre_forja="+id);
            while(rs.next()){
                name = rs.getString("nombre_hacha");
                peso = rs.getInt("peso");
                daño = rs.getInt("daño");
                h = new Hacha(name,daño,peso);
                lista.add(h);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public static String espada_porta_guerrero(String nombre_guerrero){
        Statement stmt;
        ResultSet rs;
        String espada="";
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from usa_espada where nombre_personaje="+nombre_guerrero);
            while(rs.next()){
                espada = rs.getString("nombre_espada");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        // @TODO: complete este método para que devuelva el nombre de la espada que porta el guerrero "nombre_guerrero"
        return espada;
    }

}
