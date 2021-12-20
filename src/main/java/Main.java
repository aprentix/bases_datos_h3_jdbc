import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import game.model.Dragon;
import game.model.Hacha;

public class Main {
    // @TODO: Sustituya xxxx por los parámetros de su conexión

    private static final String DB_SERVER = "localhost";

    private static final int DB_PORT = 3306;

    private static final String DB_NAME = "juego";

    private static final String DB_USER = "root";

    private static final String DB_PASS = "";

    private static Connection conn;


    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://" + DB_SERVER + ":" + DB_PORT + "/" + DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER, DB_PASS);
        System.out.println("///////////////////////////");
        dragones();
        nuevo_dragon("DRAKE",100,8); // DRAKE ES el (dragon de pruebas)
        System.out.println("///////////////////////////");
        dragones();
        System.out.println("///////////////////////////");
        List<Dragon> dragonesDerrotados = squad_derrota_dragones(1);
        for (Dragon dr: dragonesDerrotados){
            System.out.println(dr.getName());
        }
        System.out.println("///////////////////////////");
        List<Hacha> hachas = mostrar_hachas("forja de Harmek");
        for (Hacha hach: hachas){
            System.out.println(hach.getNombreHacha());
        }
        System.out.println("///////////////////////////");
        System.out.println(espada_porta_guerrero("Stanto"));
        conn.close();
    }

    // @TODO resuelva las siguientes funciones...

    public static void nuevo_dragon(String nombre,int vida,int orden){
        // @TODO: complete este método para que cree un nuevo dragón en la base de datos
        PreparedStatement ps;
        try{
            ps=conn.prepareStatement("INSERT INTO dragon(nombre_dragon,vida,orden)VALUES(?,?,?)");
            ps.setString(1,nombre);
            ps.setInt(2,vida);
            ps.setInt(3,orden);
            ps.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

/*Método para imprimir todos los dragones*/
    public static void dragones(){
        Statement stmt;
        ResultSet rs;
        String name;
        try{
            stmt= conn.createStatement();
            rs= stmt.executeQuery("SELECT * FROM dragon ORDER BY orden");
            System.out.println("Nombres dragones: ");
            while(rs.next()) {
                name = rs.getString("nombre_dragon");
                System.out.println(name);
            }
            rs.close();
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }


    public static List<Dragon> squad_derrota_dragones(int id_squad){
        // @TODO: complete este método para que devuelva una lista de los dragones derrotados por el squad
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto dragon para cada uno de los dragones, y añadirlos a la lista
        Statement stmt;
        ResultSet rs;
        Dragon dr;
        List<Dragon> lista = new ArrayList<>();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from escuadron_derrota_dragon NATURAL JOIN dragon where id_escuadron="+id_squad);
            while(rs.next()){
                String name = rs.getString("nombre_dragon");
                int life= rs.getInt("vida");
                int order=rs.getInt("orden");
                dr = new Dragon(name,life,order);
                lista.add(dr);
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return lista;

    }


    public static List<Hacha> mostrar_hachas(String nombre_forja){
        // @TODO: complete este método para que muestre por pantalla las hachas que pueden forjarse en "nombre_forja"
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto con cada hacha disponible en esa forja, y añadirlos a la lista
        Statement stmt;
        ResultSet rs;
        Hacha hacha;
        List<Hacha> lista = new ArrayList<>();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from forja_hacha NATURAL JOIN hacha where nombre_forja='"+nombre_forja+"'");
            while(rs.next()){
                String name = rs.getString("nombre_hacha");
                int danio= rs.getInt("daño");
                int peso=rs.getInt("peso");
                hacha = new Hacha(name,danio,peso);
                lista.add(hacha);
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return lista;
    }


    public static String espada_porta_guerrero(String nombre_guerrero){
        // @TODO: complete este método para que devuelva el nombre de la espada que porta el guerrero "nombre_guerrero"
        Statement stmt;
        ResultSet rs;
        String espada=null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from usa_espada WHERE nombre_personaje='"+nombre_guerrero+"'");
            if(rs.next())
            espada= rs.getString(1);
            rs.close();
            stmt.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return espada;
    }
}
