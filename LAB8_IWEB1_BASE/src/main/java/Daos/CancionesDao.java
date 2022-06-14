package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

//dao creado por niurka
public class CancionesDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";

    //metodo stefhanie
    public ArrayList<Cancion> obtenerCancion (){
        ArrayList<Cancion> listaCancionesRecomendadas= new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("\n" +
                     "select idcancion,nombre_cancion,banda from cancion ca \n" +
                     "inner join reproduccion re on re.cancion_idcancion = ca.idcancion group by cancion_idcancion having\n" +
                     "count(*) >2 order by count(*) desc;");) {

            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setIdCancion(rs.getInt(1));
                cancion.setNombre_cancion(rs.getString(2));
                cancion.setBanda(rs.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCancionesRecomendadas;
    }

    //metodo stefhanie


    public ArrayList<Cancion> listaCanciones (){
        ArrayList<Cancion> listaCanciones= new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cancion;")) {  //Query creado por niurka

            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setIdCancion(rs.getInt(1));
                cancion.setNombre_cancion(rs.getString(2));
                cancion.setBanda(rs.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCanciones;
    }
}
