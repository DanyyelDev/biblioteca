/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.patterns.payaraweb.model.Libro;

import co.edu.unipiloto.patterns.payaraweb.model.Libro.Libro;
import co.edu.unipiloto.patterns.payaraweb.model.Libro.LibroDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class LibroDAOImplementation implements LibroDAO {

    //Atributos
    private String driver;
    private String url;
    private String user;
    private String password;
    private String sentencia;
    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    private Libro est;

    //Constructor
    public LibroDAOImplementation() {
        /*

        driver = "org.apache.derby.jdbc.ClientDriver";
        url = "jdbc:derby://localhost:1527/sample";
        login = "app";
        password = "app";
        sentencia = "";
        connection = null;
        statement = null;
        rs = null;

         */
        driver = "org.postgresql.Driver";
        url = "jdbc:postgresql://localhost:5432/biblioteca";
        user = "root";
        password = "root";
        sentencia = "";
        connection = null;
        statement = null;
        rs = null;
    }

    //Metodos 
    protected void conectar() {
        try {
            //Cargar los controladores para el acceso a la BD
            Class.forName(driver);
            System.out.println("Cargar los controladores para el acceso a la BD");
            //Establecer la conexión con la BD Empresa
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error 1-" + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("Error 2-" + sqle.getMessage());
        }

    }

    public void desconectar(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Libro> getAllLibro() {
        if (connection == null) {
            conectar();
        }
        List<Libro> lista = new ArrayList();

        sentencia = "SELECT * FROM LIBROS";
        try {
            //Crear una sentencia
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //Crear un objeto ResultSet para guardar lo obtenido
            //y ejecutar la sentencia SQL
            rs = statement.executeQuery(sentencia);
            System.out.println("consulta ok");
            if (rs == null) {
                System.out.println("No hay Libros en la DB");
            }
            System.out.println(rs.first() + " " + rs.getRow() + " " + rs.getCursorName());
            do {

                int id = rs.getInt(1);
                String name = rs.getString(2);
                String autor = rs.getString(3);
                boolean state = rs.getBoolean(4);
                String editorial = rs.getString(5);
                String edicion = rs.getString(6);
                int tiempoDePrestamo = rs.getInt(7);

                //Convierte el result set a un Array List
                lista.add(new Libro(id, name, autor, state, editorial, edicion, tiempoDePrestamo));
            } while (rs.next());

        } catch (SQLException sqle) {
            System.out.println("Excepcion " + sqle.getSQLState());
        }

        return lista;

    }

    @Override
    public void updateLibro(Libro est) {
        if (connection == null) {
            conectar();
        }
        try {
            sentencia = "UPDATE LIBROS SET "
                    + "NAME = '" + est.getName() + "',"
                    + "AUTOR = '" + est.getAutor() + "',"
                    + "STATE = '" + est.getState() + "',"
                    + "EDITORIAL = '" + est.getEditorial() + "',"
                    + "EDICION = '" + est.getEdicion() + "',"
                    + "TIEMPODEPRESTAMO = " + est.getTiempoDePrestamo()
                    + " WHERE ID = " + est.getId();
           
            System.out.println("Sentencia " + sentencia);
            //Crear una sentencia
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            statement.executeUpdate(sentencia);
        } catch (SQLException sqle) {
            System.out.println("Error en " + sqle.getSQLState());
        }
    }

    @Override
    public void deleteLibro(Libro est) {
        if (connection == null) {
            conectar();
        }
    }

    @Override
    public void addLibro(Libro est) {
        if (connection == null) {
            conectar();
        }
        System.out.println("Guardar libro");

        try {
            sentencia = "INSERT INTO LIBROS VALUES("
                    + est.getId() + ",'"
                    + est.getName() + "','"
                    + est.getAutor() + "','"
                    + est.getState() + "','"
                    + est.getEditorial() + "','"
                    + est.getEdicion() + "',"
                    + est.getTiempoDePrestamo() + ""
                    + ")";

            System.out.println("Sentencia " + sentencia);
            //Crear una sentencia
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            statement.executeUpdate(sentencia);
        } catch (SQLException sqle) {
            System.out.println("Error en " + sqle.getSQLState());
        }

    }

    @Override
    public Libro searchLibro(int idBuscar) {
        Libro est = null;
        if (connection == null) {
            conectar();
        }
        sentencia = "SELECT * FROM LIBROS WHERE ID=" + idBuscar + "";
        System.out.println("Sentencia: " + sentencia);
        try {

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("Ejecutando query");
            rs = statement.executeQuery(sentencia);
            //no devuelve un resultado
            if (rs == null) {
                System.out.println("No se encontro el libro");
            }
            rs.first();

            int id = rs.getInt(1);

            String name = rs.getString(2);

            String autor = rs.getString(3);

            boolean state = rs.getBoolean(4);

            String editorial = rs.getString(5);

            String edicion = rs.getString(6);

            int tiempoDePrestamo = rs.getInt(7);

            est = new Libro(id, name, autor, state, editorial, edicion, tiempoDePrestamo);
            System.out.println(id + "\t\t" + name + "\t\t" + state);
        } catch (SQLException sqle) {
            System.out.println("Excepcion " + sqle.getSQLState());
        }

        return est;

    }

}
