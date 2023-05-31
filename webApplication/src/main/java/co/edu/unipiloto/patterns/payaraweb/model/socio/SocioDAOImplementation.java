/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.patterns.payaraweb.model.socio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class SocioDAOImplementation implements SocioDAO {

    //Atributos
    private String driver;
    private String url;
    private String user;
    private String password;
    private String sentencia;
    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    private Socio est;

    //Constructor
    public SocioDAOImplementation() {
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
    public List<Socio> getAllSocios() {
        if (connection == null) {
            conectar();
        }
        List<Socio> lista = new ArrayList();

        sentencia = "SELECT * FROM SOCIOS";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sentencia);
            System.out.println("consulta ok");
            if (rs == null) {
                System.out.println("!No se encontraron socios!");
            }
            System.out.println(rs.first() + " " + rs.getRow() + " " + rs.getCursorName());
            do {

                int id = rs.getInt(1);
                System.out.println("Id " + id);

                String name = rs.getString(2);
                System.out.println("Name " + name);

                String email = rs.getString(3);
                System.out.println("Email " + email);

                int phoneNumber = rs.getInt(4);
                System.out.println("Phone number " + phoneNumber);

                TypeSocio typeSocio = TypeSocio.valueOf(rs.getString(5));
                System.out.println("Is member VIP? " + typeSocio);

                //Convierte el result set a un Array List
                lista.add(new Socio(id, name, email, phoneNumber, typeSocio));
                System.out.println(id + "\t\t" + name+ "\t\t" + email + "\t\t" + phoneNumber + "\t\t" + typeSocio);
            } while (rs.next());

        } catch (SQLException sqle) {
            System.out.println("Excepcion " + sqle.getSQLState());
        }

        return lista;

    }

    @Override
    public void updateSocio(Socio est) {
        if (connection == null) {
            conectar();
        }
        try {
            sentencia = "UPDATE SOCIOS SET "
                    + "NAME = '" + est.getName() + "',"
                    + "EMAIL = '" + est.getEmail() + "',"
                    + "PHONENUMBER = " + est.getPhoneNumber() + ","
                    + "TYPESOCIO =" + est.getTypeSocio() + ""
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
    public void deleteSocio(Socio est) {
        if (connection == null) {
            conectar();
        }
    }

    @Override
    public void addSocio(Socio est) {
        if (connection == null) {
            conectar();
        }
        System.out.println("Guardar estudiante");

        try {
            sentencia = "INSERT INTO estudiante VALUES("
                    + est.getId() + ",'"
                    + est.getName() + "','"
                    + est.getEmail() + "',"
                    + est.getPhoneNumber() + ","
                    + est.getTypeSocio() + ""
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
    public Socio searchSocio(int idBuscar) {
        Socio est = null;
        if (connection == null) {
            conectar();
        }
        sentencia = "SELECT * FROM SOCIOS WHERE ID=" + idBuscar + "";
        System.out.println("Sentencia: " + sentencia);
        try {

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sentencia);
            //no devuelve un resultado
            if (rs == null) {
                System.out.println("EL id: "+idBuscar+" no es un socio de la biblioteca");
            }
            //Se coloca en la primer posicion del result set
            rs.first();
            //Extrae los datos de cada fila del result set
            int id = rs.getInt(1);
            System.out.println("Id " + id);

            String name = rs.getString(2);
            System.out.println("Name " + name);

            String email = rs.getString(3);
            System.out.println("Email " + email);

            int phoneNumber = rs.getInt(4);
            System.out.println("Phone number " + phoneNumber);

            TypeSocio typeSocio = TypeSocio.valueOf(rs.getString(5));
            System.out.println("Is member VIP? " + typeSocio);


            est = new Socio(id, name, email, phoneNumber,typeSocio);
            System.out.println(id + "\t\t" + name + "\t\t" + email + "\t\t" + phoneNumber + "\t\t" + typeSocio);
        } catch (SQLException sqle) {
            System.out.println("Excepcion " + sqle.getSQLState());
        }

        return est;

    }

}
